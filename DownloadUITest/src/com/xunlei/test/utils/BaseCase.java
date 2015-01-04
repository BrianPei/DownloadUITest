package com.xunlei.test.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 测试用例基类
 * 
 * @author peiyu
 * 
 */
public class BaseCase {
	protected static DesiredCapabilities capDownload = new DesiredCapabilities();

	public BaseCase() {
		capDownload.setCapability("deviceName", Constant.DEVICEMI3);
		capDownload.setCapability("platformVersion", Constant.VERSION);
		capDownload.setCapability("platformName", Constant.PLATFORM);
		capDownload.setCapability("appPackage", Constant.DOWNLOADPACKAGE);
		capDownload.setCapability("appActivity", Constant.DOWNLOADACTIVITY);
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
