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
}
