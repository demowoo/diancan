package com.diancan.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diancan.model.User;
import com.diancan.service.UserService;

import common.Constant;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("activeuser.action")
	public String activeUser(int userId, HttpSession httpSession, ModelMap model){
		User loginUser = (User)httpSession.getAttribute(Constant.LOGININFO);
		if(loginUser.getType() != User.ADMIN){
			model.put(Constant.INFO, "你没有权限执行此操作！");
			return Constant.INFO;
		}
		userService.activeUser(userId);
		return "redirect:admin.htm";
	}
}
