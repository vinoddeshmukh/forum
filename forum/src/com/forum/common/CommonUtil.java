package com.forum.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
	public static String getDateInStringFormat(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy");
		return simpleDateFormat.format(date);
	}
}
