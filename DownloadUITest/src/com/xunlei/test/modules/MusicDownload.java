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
 * 从音乐播放器添加下载任务
 * 
 * @author peiyu
 * 
 */
public class MusicDownload {
	private static AppiumDriver driverMusic;
	private static DesiredCapabilities capMusic = new DesiredCapabilities();
	private static Logger logger = Logger.getLogger(MusicDownload.class
			.getName());
	
	static {
		capMusic.setCapability("deviceName", Constant.DEVICEMI3);
		capMusic.setCapability("platformVersion", Constant.VERSION);
		capMusic.setCapability("platformName", Constant.PLATFORM);
		capMusic.setCapability("appPackage", Constant.MUSICPACKAGE);
		capMusic.setCapability("appActivity", Constant.MUSICACTIVITY);
	}

	/**
	 * 从收藏的音乐中添加下载任务
	 * 
	 * @throws MalformedURLException
	 */
	public static void downloadFavoriteMusic(int n){
		try {
			// 调起music进程
			driverMusic = new AndroidDriver(new URL(Constant.URL), capMusic);
			driverMusic.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			// 点击首页顶部我的音乐tab
			List<WebElement> tabList = driverMusic.findElements(By
					.id("com.miui.player:id/text"));
			tabList.get(1).click();
			// 点击我收藏的单曲
			WebElement mainList = driverMusic.findElement(By
					.id("android:id/list"));
			WebElement favItem = mainList.findElements(
					By.className("android.widget.RelativeLayout")).get(2);
			favItem.click();
			// 点击一首歌的下载按钮
			WebElement favList = driverMusic.findElement(By
					.id("com.miui.player:id/list"));
			for (int i = 0; i < n; i++) {
				WebElement firstMusic = favList.findElements(
						By.className("android.widget.RelativeLayout")).get(
						i * 2);
				WebElement downloadBtn = firstMusic.findElement(By
						.id("com.miui.player:id/download"));
				downloadBtn.click();
			}
			logger.info("音乐收藏添加下载任务成功!");
		}catch(MalformedURLException e){
			e.printStackTrace();
			logger.info("音乐收藏添加下载任务失败!");
		}
		finally {
			// 退出进程
			driverMusic.quit();
		}
	}
}
