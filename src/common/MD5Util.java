package common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.diancan.model.User;

public class MD5Util {
	
	/**
	 * 用MD5算法对字符串进行摘要计算，并返回
	 * @param 原始字符串
	 * @return 用MD5算法产生的摘要，以字符串形式返回
	 */
	public static String getMD5Digest(String text){
		if(text == null || text.equals(""))
			return "";
		StringBuffer buf = new StringBuffer(""); 
		try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(text.getBytes());
		        byte[] b = md.digest();
				for( byte bi : b){
				 	if(bi<0) 
				 		bi += 256; 
				 	if(bi<16) 
				 		buf.append("0"); 
				 	buf.append(Integer.toHexString(bi)); 
				}
			}
			catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		return buf.toString();
	}
	
	/**
	 *转换User对的pass字段，用MD5加密，并更新 
	 */
	public static void setPassMD5(User user){
		if(user.getPassword()==null || user.getPassword().equals(""))
			return;
		else{
			String userPass = user.getPassword();
			user.setPassword(getMD5Digest(userPass));
		}
	}
	
}
