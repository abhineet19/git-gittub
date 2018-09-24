package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Captcha {
	static WebDriver driver;
	static int value = 0;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\MARS_FRAMEWORK\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://general.bajajallianz.com/MotorInsurance/onlineportal/motorNew/indexCar.jsp?p_product_code=1801&src=CBM_01170&u_action=saved_quote");
		String s1 = driver.findElement(By.xpath("//div[@id='math']/child::*")).getText().trim();
		String[] s2 = s1.split(" ");
		int firstNumber = Integer.parseInt(s2[2]);
		String symbol = s2[3];
		int secondNumber = Character.getNumericValue(s2[4].charAt(0));
		
		
			if(symbol.equals("+")) {
				value = firstNumber + secondNumber;
			}
			else if(symbol.equals("-")) {
				value = firstNumber - secondNumber;
			}
			else if(symbol.equals("*")) {
				value = firstNumber * secondNumber;
			}
			else if(symbol.equals("/")) {
				value = firstNumber / secondNumber;
			}
			
			String finalValue = value+"";
		
			
			driver.findElement(By.id("BotBootInput")).sendKeys(finalValue);
		

	}

}
