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
 * 从游戏中心添加下载任务
 * 
 * @author peiyu
 * 
 */
public class GameDownload {
	private static AppiumDriver driverGame;
	private static DesiredCapabilities capGame = new DesiredCapabilities();
	private static Logger logger = Logger.getLogger(GameDownload.class
			.getName());
	
	static {
		capGame.setCapability("deviceName", Constant.DEVICEMI3);
		capGame.setCapability("platformVersion", Constant.VERSION);
		capGame.setCapability("platformName", Constant.PLATFORM);
		capGame.setCapability("appPackage", Constant.GAMEPACKAGE);
		capGame.setCapability("appActivity", Constant.GAMEACTIVITY);
	}

	/**
	 * 从首页列表添加一个下载任务
	 * 
	 * @throws MalformedURLException
	 */
	public static void downloadGame(int n) {
		try {
			// 调起gameCenter进程
			driverGame = new AndroidDriver(new URL(Constant.URL), capGame);
			driverGame.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			// 获取gameCenter首页列表
			WebElement mainList = driverGame.findElement(By
					.id("android:id/list"));
			List<WebElement> downloadList = mainList.findElements(By
					.className("android.widget.RelativeLayout"));
			// 点击下载项的下载按钮
			for (int i = 0; i < n; i++) {
				WebElement downloadItem = downloadList.get(i);
				WebElement downloadBtn = downloadItem
						.findElement(By.name("安装"));
				downloadBtn.click();
				logger.info("游戏中心添加下载任务成功!");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("游戏中心添加下载任务失败!");
		} finally {
			// 退出进程
			driverGame.quit();
		}
	}

	/**
	 * 从游戏排行列表添加下载任务
	 * 
	 * @param n
	 */
	public static void downloadRankGame(int n) {
		try {
			// 调起Market进程
			driverGame = new AndroidDriver(new URL(Constant.URL), capGame);
			driverGame.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			// 获取首页分类tab
			WebElement mainTab = driverGame.findElement(By
					.className("android.widget.HorizontalScrollView"));
			// 点击跳转至排行页面
			List<WebElement> tabList = mainTab.findElements(By
					.className("android.widget.LinearLayout"));
			WebElement rankTab = tabList.get(3);
			rankTab.click();
			// 获取list中的下载项
			Thread.sleep(1000);
			WebElement rankList = driverGame.findElement(By
					.id("android:id/list"));
			List<WebElement> appList = rankList.findElements(By
					.className("android.widget.RelativeLayout"));
			// 下载app
			for (int i = 0; i < n; i++) {
				WebElement appItem = appList.get(i * 2);
				WebElement downloadBtn = appItem.findElement(By
						.id("com.xiaomi.gamecenter:id/action"));
				downloadBtn.click();
			}
			logger.info("游戏中心添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("游戏中心添加下载任务失败!");
		} finally {
			// 退出进程
			driverGame.quit();
		}
	}
}
