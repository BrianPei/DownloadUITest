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

import com.xunlei.test.modules.GameDownload;
import com.xunlei.test.modules.MarketDownload;
import com.xunlei.test.modules.MusicDownload;
import com.xunlei.test.modules.ThemeDownload;
import com.xunlei.test.utils.BaseCase;
import com.xunlei.test.utils.Constant;
import com.xunlei.test.utils.DownloadList;
import com.xunlei.test.utils.RetryOnFailure;

/**
 * 同一来源多任务下载测试用例
 * 
 * @author peiyu
 * 
 */
public class MultiTaskTest extends BaseCase {
	private static AppiumDriver driverDownload;

	private static Logger logger = Logger.getLogger(MultiTaskTest.class
			.getName());

	@Rule
	public RetryOnFailure retryOnFailure = new RetryOnFailure(2);

	/*
	 * 从应用商店下载3个任务
	 */
	@Test
	public void marketMultiDownload() throws MalformedURLException {
		// 从应用商店排行榜添加三个下载任务
		MarketDownload.downloadRankApp(3);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务并验证状态
		WebElement downloadItem1 = DownloadList.getDownloadTask(driverDownload,
				0);
		String taskName1 = DownloadList.getTaskName(downloadItem1);
		logger.info("下载任务1名称: " + taskName1);
		String statusText1 = DownloadList.getDownloadSpeed(downloadItem1);
		logger.info("任务1当前下载状态: " + statusText1);
		assertEquals(statusText1, "连接中");
		// 获取第二个下载任务并验证状态
		WebElement downloadItem2 = DownloadList.getDownloadTask(driverDownload,
				2);
		String taskName2 = DownloadList.getTaskName(downloadItem2);
		logger.info("下载任务2名称: " + taskName2);
		String statusText2 = DownloadList.getDownloadSpeed(downloadItem2);
		logger.info("任务2当前下载状态: " + statusText2);
		assertTrue(statusText2.indexOf("B/s") > -1);
		// 获取第三个下载任务并验证状态
		WebElement downloadItem3 = DownloadList.getDownloadTask(driverDownload,
				6);
		String taskName3 = DownloadList.getTaskName(downloadItem3);
		logger.info("下载任务3名称: " + taskName3);
		String statusText3 = DownloadList.getDownloadSpeed(downloadItem3);
		logger.info("任务3当前下载状态: " + statusText3);
		assertTrue(statusText3.indexOf("B/s") > -1);
	}

	/*
	 * 从游戏中心下载2个任务 (下载超过2个任务时，策略为在游戏中心内等待下载，不会将第3个任务加入下载列表)
	 */
	@Test
	public void gameMultiDownload() throws MalformedURLException {
		// 从游戏中心下载添加两个下载任务
		GameDownload.downloadGame(2);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务并验证状态
		WebElement downloadItem1 = DownloadList.getDownloadTask(driverDownload,
				0);
		String taskName1 = DownloadList.getTaskName(downloadItem1);
		logger.info("下载任务1名称: " + taskName1);
		String statusText1 = DownloadList.getDownloadSpeed(downloadItem1);
		logger.info("任务1当前下载状态: " + statusText1);
		assertEquals(statusText1, "连接中");
		// 获取第二个下载任务并验证状态
		WebElement downloadItem2 = DownloadList.getDownloadTask(driverDownload,
				2);
		String taskName2 = DownloadList.getTaskName(downloadItem2);
		logger.info("下载任务2名称: " + taskName2);
		String statusText2 = DownloadList.getDownloadSpeed(downloadItem2);
		logger.info("任务2当前下载状态: " + statusText2);
		assertTrue(statusText2.indexOf("B/s") > -1);
	}

	/*
	 * 从主题商店下载3个免费任务
	 */
	@Test
	public void themeMultiDownload() throws MalformedURLException {
		// 从免费主题列表添加三个下载任务
		ThemeDownload.searchFreeTheme(3);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务并验证状态
		WebElement downloadItem1 = DownloadList.getDownloadTask(driverDownload,
				0);
		String taskName1 = DownloadList.getTaskName(downloadItem1);
		logger.info("下载任务1名称: " + taskName1);
		String statusText1 = DownloadList.getDownloadSpeed(downloadItem1);
		logger.info("任务1当前下载状态: " + statusText1);
		assertEquals(statusText1, "连接中");
		// 获取第二个下载任务并验证状态
		WebElement downloadItem2 = DownloadList.getDownloadTask(driverDownload,
				2);
		String taskName2 = DownloadList.getTaskName(downloadItem2);
		logger.info("下载任务2名称: " + taskName2);
		String statusText2 = DownloadList.getDownloadSpeed(downloadItem2);
		logger.info("任务2当前下载状态: " + statusText2);
		assertTrue(statusText2.indexOf("B/s") > -1);
		// 获取第三个下载任务并验证状态
		WebElement downloadItem3 = DownloadList.getDownloadTask(driverDownload,
				6);
		String taskName3 = DownloadList.getTaskName(downloadItem3);
		logger.info("下载任务3名称: " + taskName3);
		String statusText3 = DownloadList.getDownloadSpeed(downloadItem3);
		logger.info("任务3当前下载状态: " + statusText3);
		assertTrue(statusText3.indexOf("B/s") > -1);
	}

	/*
	 * 从音乐管理器下载3个任务
	 */
	@Test
	public void musicMultiDownload() throws MalformedURLException {
		// 从我收藏的音乐中添加三个下载任务
		MusicDownload.downloadFavoriteMusic(3);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务并验证状态
		WebElement downloadItem1 = DownloadList.getDownloadTask(driverDownload,
				0);
		String taskName1 = DownloadList.getTaskName(downloadItem1);
		logger.info("下载任务1名称: " + taskName1);
		String statusText1 = DownloadList.getDownloadSpeed(downloadItem1);
		logger.info("任务1当前下载状态: " + statusText1);
		assertEquals(statusText1, "连接中");
		// 获取第二个下载任务并验证状态
		WebElement downloadItem2 = DownloadList.getDownloadTask(driverDownload,
				2);
		String taskName2 = DownloadList.getTaskName(downloadItem2);
		logger.info("下载任务2名称: " + taskName2);
		String statusText2 = DownloadList.getDownloadSpeed(downloadItem2);
		logger.info("任务2当前下载状态: " + statusText2);
		assertTrue(statusText2.indexOf("B/s") > -1);
		// 获取第三个下载任务并验证状态
		WebElement downloadItem3 = DownloadList.getDownloadTask(driverDownload,
				6);
		String taskName3 = DownloadList.getTaskName(downloadItem3);
		logger.info("下载任务3名称: " + taskName3);
		String statusText3 = DownloadList.getDownloadSpeed(downloadItem3);
		logger.info("任务3当前下载状态: " + statusText3);
		assertTrue(statusText3.indexOf("B/s") > -1);
	}
}
