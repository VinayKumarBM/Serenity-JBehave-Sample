package com.jbehave.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementOperations {
	
	private static Logger LOG = LoggerFactory.getLogger(ElementOperations.class.getName());
	
	public static void pause(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String getAlertMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();		
		LOG.info("Message: "+message);
		alert.accept();
		return message;
	}
}
