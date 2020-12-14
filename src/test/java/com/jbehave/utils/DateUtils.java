package com.jbehave.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
	
	private static Logger log = LoggerFactory.getLogger(DateUtils.class.getName());
	
	public static String getFormatedDate(String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		log.info("Expected Date:"+date);
		return date;
	}
	
	public static String changeDateByDays(int days, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		String date = simpleDateFormat.format(cal.getTime());
		log.info("Expected Date:"+date);
		return date;
	}
	
	public static String changeDateByMonths(int months, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, months);
		String date = simpleDateFormat.format(cal.getTime());
		log.info("Expected Date:"+date);
		return date;
	}
	
	public static String changeDateByYears(int years, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, years);
		String date = simpleDateFormat.format(cal.getTime());
		log.info("Expected Date:"+date);
		return date;
	}
}
