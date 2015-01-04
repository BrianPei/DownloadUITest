package com.xunlei.test.modules;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.xunlei.test.utils.Constant;

/**
 * 从浏览器添加下载任务
 * 
 * @author peiyu
 * 
 */
public class BrowserDownload {
	protected static AppiumDriver driverBrowser;
	protected static DesiredCapabilities capBrowser = new DesiredCapabilities();
	private static Logger logger = Logger.getLogger(BrowserDownload.class
			.getName());
	
	static {
		capBrowser.setCapability("deviceName", Constant.DEVICEMI3);
		capBrowser.setCapability("platformVersion", Constant.VERSION);
		capBrowser.setCapability("platformName", Constant.PLATFORM);
		capBrowser.setCapability("appPackage", Constant.BROWSERPACKAGE);
		capBrowser.setCapability("appActivity", Constant.BROWSERACTIVITY);
	}

	/**
	 * 从百度网盘添加一个下载任务
	 */
	public static void downloadFromBaiduPan() {
		try {
			// 调起browser进程
			driverBrowser = new AndroidDriver(new URL(Constant.URL), capBrowser);
			driverBrowser.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);

			// 打开新页面
			openNewPage(driverBrowser);
			// 从首页点击访问百度网盘
			BaiduPanDownload.openBaiduPan(driverBrowser);
			// 切换至webview模式（webview下无法查找到元素，暂时无解）
			// driverBrowser.context("WEBVIEW_com.android.browser");
			// 点击列表第一个文件
			driverBrowser.tap(1, 550, 960, 300);
			Thread.sleep(3000);
			// 点击下载按钮
			driverBrowser.tap(1, 550, 1450, 300);
			Thread.sleep(3000);
			// 点击确定按钮
			driverBrowser.findElement(By.id("android:id/button1")).click();
			logger.info("百度网盘添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("百度网盘添加下载任务失败!");
		} finally {
			// 退出进程
			driverBrowser.quit();
		}
	}

	/*
	 * 打开浏览器新页面
	 */
	public static void openNewPage(AppiumDriver driver)
			throws InterruptedException {
		WebElement bottomBar = driver.findElement(By
				.id("com.android.browser:id/bottomBar"));
		WebElement newBtn = bottomBar.findElement(By
				.id("com.android.browser:id/action_new_tab"));
		newBtn.click();
		Thread.sleep(1000);
	}

	/*
	 * 访问指定的url
	 */
	public static void visitUrl(AppiumDriver driver, String url)
			throws InterruptedException {
		WebElement urlField = driver
				.findElementById("com.android.browser:id/url");
		urlField.sendKeys(url);
		driver.sendKeyEvent(66);
		Thread.sleep(5000);
	}
}
