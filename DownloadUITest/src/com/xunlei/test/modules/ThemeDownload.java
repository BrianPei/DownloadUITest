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
 * 从主题风格添加下载任务
 * 
 * @author peiyu
 * 
 */
public class ThemeDownload {
	private static AppiumDriver driverTheme;
	private static DesiredCapabilities capTheme = new DesiredCapabilities();
	private static Logger logger = Logger.getLogger(ThemeDownload.class
			.getName());
		
	static {
		capTheme.setCapability("deviceName", Constant.DEVICEMI3);
		capTheme.setCapability("platformVersion", Constant.VERSION);
		capTheme.setCapability("platformName", Constant.PLATFORM);
		capTheme.setCapability("appPackage", Constant.THEMEPACKAGE);
		capTheme.setCapability("appActivity", Constant.THEMEACTIVITY);
	}

	/**
	 * 搜索免费主题并添加下载任务
	 * 
	 * @param n
	 */
	public static void searchFreeTheme(int n) {
		try {
			// 调起Theme进程
			driverTheme = new AndroidDriver(new URL(Constant.URL), capTheme);
			driverTheme.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			// 点击首页搜索按钮
			WebElement searchBtn = driverTheme
					.findElementById("com.android.thememanager:id/icon_search");
			searchBtn.click();
			// 搜索“免费”主题
			WebElement textField = driverTheme
					.findElementById("com.android.thememanager:id/search_view");
			textField.sendKeys("mianfei");
			driverTheme.sendKeyEvent(66);
			// 获取搜索结果页第一行主题
			Thread.sleep(2000);
			WebElement freeList = driverTheme.findElement(By
					.id("android:id/list"));
			WebElement freeRow = freeList.findElements(
					By.className("android.widget.LinearLayout")).get(1);
			// 点击第一行免费主题
			for (int i = 0; i < n; i++) {
				List<WebElement> themeList = freeRow.findElements(By
						.className("android.widget.LinearLayout"));
				WebElement themeItem = themeList.get(i * 2);
				themeItem.click();
				// 点击下载按钮
				Thread.sleep(3000);
				WebElement downloadBtn = driverTheme.findElement(By
						.id("com.android.thememanager:id/downloadBtn"));
				downloadBtn.click();
				driverTheme.navigate().back();
			}
			logger.info("主题商店添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("主题商店添加下载任务失败!");
		} finally {
			// 退出进程
			driverTheme.quit();
		}
	}

	/**
	 * 从免费排行列表添加一个下载任务(列表位置不固定，暂时不用)
	 */
	public static void downloadFreeTheme(int n) {
		try {
			// 调起Theme进程
			driverTheme = new AndroidDriver(new URL(Constant.URL), capTheme);
			driverTheme.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			// 获取首页分类tab
			WebElement mainTab = driverTheme.findElement(By
					.className("android.widget.HorizontalScrollView"));
			// 点击跳转至排行页面
			List<WebElement> tabList = mainTab.findElements(By
					.className("android.widget.LinearLayout"));
			WebElement rankTab = tabList.get(2);
			rankTab.click();
			// 点击免费tab跳转至免费排行页面
			Thread.sleep(2000);
			WebElement rankView = driverTheme.findElement(By
					.id("miui:id/view_pager"));
			WebElement freeTab = rankView
					.findElements(
							By.id("com.android.thememanager:id/resource_secondary_tab"))
					.get(1);
			freeTab.click();
			// 点击第一行免费主题
			Thread.sleep(3000);
			WebElement freeList = driverTheme.findElement(By
					.id("android:id/list"));
			WebElement freeRow = freeList.findElements(
					By.className("android.widget.LinearLayout")).get(1);
			for (int i = 0; i < n; i++) {
				List<WebElement> imageList = freeRow.findElements(By
						.className("android.widget.LinearLayout"));
				WebElement themeImage = imageList.get(i);
				themeImage.click();
				// 点击下载按钮
				WebElement downloadBtn = driverTheme.findElement(By
						.id("com.android.thememanager:id/downloadBtn"));
				downloadBtn.click();
			}
			logger.info("主题商店添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("主题商店添加下载任务失败!");
		} finally {
			// 退出进程
			driverTheme.quit();
		}
	}

}
