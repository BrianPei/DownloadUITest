package com.xunlei.test.modules;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.xunlei.test.utils.Constant;

/**
 * 从应用市场添加下载任务
 * 
 * @author peiyu
 * 
 */
public class MarketDownload {
	private static AppiumDriver driverMarket;
	private static DesiredCapabilities capMarket = new DesiredCapabilities();
	private static Logger logger = Logger.getLogger(MarketDownload.class
			.getName());
	
	static {
		capMarket.setCapability("deviceName", Constant.DEVICEMI3);
		capMarket.setCapability("platformVersion", Constant.VERSION);
		capMarket.setCapability("platformName", Constant.PLATFORM);
		capMarket.setCapability("appPackage", Constant.MARKETPACKAGE);
		capMarket.setCapability("appActivity", Constant.MARKETACTIVITY);
	}

	/**
	 * 从首页列表添加一个下载任务
	 */
	public static void downloadApp(int n) {
		try {
			// 调起market进程
			driverMarket = new AndroidDriver(new URL(Constant.URL), capMarket);
			driverMarket.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);

			// 获取market首页下载项列表
			WebElement mainList = driverMarket.findElement(By
					.id("android:id/list"));
			List<WebElement> downloadList = mainList.findElements(By
					.className("android.widget.RelativeLayout"));
			// 点击下载项的下载按钮
			for (int i = 0; i < n; i++) {
				WebElement downloadItem = downloadList.get(i);
				WebElement downloadBtn = downloadItem.findElement(By
						.id("com.xiaomi.market:id/button"));
				downloadBtn.click();
				logger.info("应用市场添加下载任务成功!");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("应用市场添加下载任务失败!");
		} finally {
			// 退出进程
			driverMarket.quit();
		}
	}

	/**
	 * 从应用排行列表添加下载任务
	 * 
	 * @param n
	 */
	public static void downloadRankApp(int n) {
		try {
			// 调起Market进程
			driverMarket = new AndroidDriver(new URL(Constant.URL), capMarket);
			driverMarket.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);

			// 获取首页分类tab
			WebElement mainTab = driverMarket.findElement(By
					.className("android.widget.HorizontalScrollView"));
			// 点击跳转至排行页面
			List<WebElement> tabList = mainTab.findElements(By
					.className("android.widget.LinearLayout"));
			WebElement rankTab = tabList.get(2);
			rankTab.click();
			// 获取list中的下载项
			Thread.sleep(1000);
			WebElement rankList = driverMarket.findElement(By
					.id("android:id/list"));
			List<WebElement> appList = rankList.findElements(By
					.className("android.widget.RelativeLayout"));
			// 下载app
			for (int i = 0; i < n; i++) {
				WebElement appItem = appList.get(i);
				WebElement downloadBtn = appItem.findElement(By
						.id("com.xiaomi.market:id/button"));
				downloadBtn.click();
			}
			logger.info("应用市场添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("应用市场添加下载任务失败!");
		} finally {
			// 退出进程
			driverMarket.quit();
		}
	}
}
