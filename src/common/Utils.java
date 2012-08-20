package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static int getToday(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(df.format(date));
	}
	
	public static int getDate(long time){
		Date date = new Date(time);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(df.format(date));
	}
	
	public static String formatDate(long time, String style){
		Date date = new Date(time);
		SimpleDateFormat df = new SimpleDateFormat(style);
		return df.format(date);
	}
	
	public static void main(String[] argv){
		Date date = new Date();
		String d = formatDate(date.getTime(), "yyyy/M/d");
		System.out.println(d);
	}
}
