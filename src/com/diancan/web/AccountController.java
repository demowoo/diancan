package com.diancan.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diancan.model.User;
import com.diancan.service.UserService;
import common.Constant;
import common.MD5Util;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.action", method=RequestMethod.POST)
	public String login(String name, String pass,  HttpSession httpSession){
		
		if(name == null || name.equals(""))//用户名不为空
			return "forward:login.jsp";
		if(pass == null || pass.equals(""))//密码不为空
			return "forward:login.jsp";
		
		User user = userService.getUserByLoginName(name);
		if(user == null)//数据库没有此用户
			return "forward:login.jsp";
		if(!user.isActive())//用户未激活
			return "forward:login.jsp";
		
		pass = MD5Util.getMD5Digest(pass);
		if(pass.equals(user.getPassword())){
			httpSession.setAttribute(Constant.LOGININFO, user);
		}else
			return "forward:login.jsp";//密码错误
		
		return "forward:welcome.action";
	}
	
	/**
	 *登陆ajax验证
	 */
	@RequestMapping("validate.do")
	public 	@ResponseBody String valdate(String name, String pass){
		pass = MD5Util.getMD5Digest(pass);
		
		if(name == null || name.equals(""))
			return "用户名不能为空";
		if(pass == null || pass.equals(""))
			return "密码不能为空";
		User user = userService.getUserByLoginName(name);
		if(user == null)
			return "用户名或密码错误";
		else if(!user.isActive())
			return "账号未激活";
		else if(user.getPassword().equals(pass) && user.isActive())
			return Constant.AJAX_SUC;
		else
			return "用户名或密码错误";
	}
	
	//注册用户
	@RequestMapping(value="register.action", method=RequestMethod.POST)
	public String addUser(User user, ModelMap model){
		if(!regValidate(user).equals(Constant.AJAX_SUC))
			return "forward:register.jsp";
		
		user.setActive(false);
		user.setType(User.COMMON);
		MD5Util.setPassMD5(user);
		userService.addUser(user);
		
		model.put(Constant.INFO, "注册成功，请等待管理员激活");
		return Constant.INFO;
	}
	
	//验证注册
	@RequestMapping("regValidate.do")
	public @ResponseBody String regValidate(User user){
		if(user.getLoginname() == null || user.getLoginname().equals(""))
			return "账号不能为空";
		if(user.getRealname() == null || user.getRealname().equals(""))
			return "真实姓名不能为空";
		if(user.getPassword() == null || user.getPassword().equals(""))
			return "密码不能为空";
		
		User loginUser = userService.getUserByLoginName(user.getLoginname());
		if(loginUser != null)
			return "账号已经被占用";
		
		loginUser = null;
		loginUser = userService.getUserByRealName(user.getRealname());
		if(loginUser != null)
			return "名称已经存在";
		
		if(user.getPassword() == null || user.getPassword().equals(""))
			return "密码不能为空";
		
		return Constant.AJAX_SUC;
	}
	
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser.do")
	public @ResponseBody String updateUserInfo(User user){
		userService.updateUserInfo(user);
		return Constant.AJAX_SUC;
	}
}
