package com.xunlei.test.testcases;

import static org.junit.Assert.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.xunlei.test.modules.BrowserDownload;
import com.xunlei.test.modules.GameDownload;
import com.xunlei.test.modules.MarketDownload;
import com.xunlei.test.modules.MusicDownload;
import com.xunlei.test.modules.ThemeDownload;
import com.xunlei.test.utils.BaseCase;
import com.xunlei.test.utils.Constant;
import com.xunlei.test.utils.DownloadList;
import com.xunlei.test.utils.RetryOnFailure;

/**
 * 单任务下载测试用例
 * 
 * @author peiyu
 * 
 */
public class SingleTaskTest extends BaseCase {
	private static AppiumDriver driverDownload;

	private static Logger logger = Logger.getLogger(SingleTaskTest.class
			.getName());

	@Rule
	public RetryOnFailure retryOnFailure = new RetryOnFailure(2);

	/*
	 * 从应用商店下载单个任务
	 */
	@Test
	public void marketSingleDownload() throws MalformedURLException {
		// 从应用商店首页下载第一个应用
		MarketDownload.downloadApp(1);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务
		WebElement downloadItem = DownloadList.getDownloadTask(driverDownload,
				0);
		// 验证下载状态
		String taskName = DownloadList.getTaskName(downloadItem);
		logger.info("下载任务名称: " + taskName);
		String statusText = DownloadList.getDownloadSpeed(downloadItem);
		logger.info("当前下载状态: " + statusText);
		assertTrue(statusText.indexOf("B/s") > -1);
	}

	/*
	 * 从游戏中心下载单个任务
	 */
	@Test
	public void gameSingleDownload() throws MalformedURLException {
		// 从游戏中心首页下载第一个游戏
		GameDownload.downloadGame(1);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务
		WebElement downloadItem = DownloadList.getDownloadTask(driverDownload,
				0);
		// 验证下载状态
		String taskName = DownloadList.getTaskName(downloadItem);
		logger.info("下载任务名称: " + taskName);
		String statusText = DownloadList.getDownloadSpeed(downloadItem);
		logger.info("当前下载状态: " + statusText);
		assertTrue(statusText.indexOf("B/s") > -1);
	}

	/*
	 * 从主题商店下载单个任务
	 */
	@Test
	public void themeSingleDownload() throws MalformedURLException {
		// 从主题商店下载一个免费主题
		ThemeDownload.searchFreeTheme(1);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务
		WebElement downloadItem = DownloadList.getDownloadTask(driverDownload,
				0);
		// 验证下载状态
		String taskName = DownloadList.getTaskName(downloadItem);
		logger.info("下载任务名称: " + taskName);
		String statusText = DownloadList.getDownloadSpeed(downloadItem);
		logger.info("当前下载状态: " + statusText);
		assertTrue(statusText.indexOf("B/s") > -1);
	}

	/*
	 * 从音乐管理器下载单个任务
	 */
	@Test
	public void musicSingleDownload() throws MalformedURLException {
		// 从我的音乐下载一个收藏的音乐
		MusicDownload.downloadFavoriteMusic(1);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务
		WebElement downloadItem = DownloadList.getDownloadTask(driverDownload,
				0);
		// 验证下载状态
		String taskName = DownloadList.getTaskName(downloadItem);
		logger.info("下载任务名称: " + taskName);
		String statusText = DownloadList.getDownloadSpeed(downloadItem);
		logger.info("当前下载状态: " + statusText);
		assertTrue(statusText.indexOf("B/s") > -1);
	}

	/*
	 * 从浏览器下载单个任务
	 */
	@Test
	public void browserSingleDownload() throws MalformedURLException {
		// 从浏览器百度网盘下载一个文件
		BrowserDownload.downloadFromBaiduPan();
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务
		WebElement downloadItem = DownloadList.getDownloadTask(driverDownload,
				0);
		// 验证下载状态
		String taskName = DownloadList.getTaskName(downloadItem);
		logger.info("下载任务名称: " + taskName);
		String statusText = DownloadList.getDownloadSpeed(downloadItem);
		logger.info("当前下载状态: " + statusText);
		assertTrue(statusText.indexOf("B/s") > -1);
	}
}
