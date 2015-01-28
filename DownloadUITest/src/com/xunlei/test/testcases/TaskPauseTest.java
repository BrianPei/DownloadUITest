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
import com.xunlei.test.utils.BaseCase;
import com.xunlei.test.utils.Constant;
import com.xunlei.test.utils.DownloadList;
import com.xunlei.test.utils.RetryOnFailure;

public class TaskPauseTest extends BaseCase {
	private static AppiumDriver driverDownload;

	private static Logger logger = Logger.getLogger(TaskPauseTest.class
			.getName());

	@Rule
	public RetryOnFailure retryOnFailure = new RetryOnFailure(2);

	/*
	 * 单个下载任务暂停与续传
	 */
	@Test
	public void singlePauseTest() throws MalformedURLException {
		// 从游戏中心首页下载第一个应用
		GameDownload.downloadRankGame(1);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务
		WebElement downloadItem = DownloadList.getDownloadTask(driverDownload,
				0);
		// 验证下载任务状态
		String taskName = DownloadList.getTaskName(downloadItem);
		logger.info("下载任务名称: " + taskName);
		String startStatusText = DownloadList.getDownloadSpeed(downloadItem);
		logger.info("当前下载状态: " + startStatusText);
		assertTrue(startStatusText.indexOf("B/s") > -1);
		sleep(1);
		// 暂停任务并验证状态
		WebElement pauseBtn = DownloadList.getPauseButton(downloadItem);
		pauseBtn.click();
		logger.info("暂停按钮已点击");
		sleep(1);
		String pauseStatusText = DownloadList.getPauseStatus(downloadItem);
		logger.info("当前下载状态: " + pauseStatusText);
		assertEquals(pauseStatusText, "已暂停");
		sleep(1);
		// 重新开始任务并验证状态
		pauseBtn.click();
		logger.info("续传按钮已点击");
		sleep(2);
		String resumeStatusText = DownloadList.getDownloadSpeed(downloadItem);
		logger.info("当前下载状态: " + resumeStatusText);
		assertTrue(resumeStatusText.indexOf("B/s") > -1);
	}

	/*
	 * 多个下载任务暂停与续传
	 */
	@Test
	public void allPauseTest() throws MalformedURLException {
		// 从游戏中心排行榜下载添加两个下载任务
		GameDownload.downloadRankGame(2);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取两个下载任务并验证状态
		WebElement downloadItem1 = DownloadList.getDownloadTask(driverDownload,
				0);
		WebElement downloadItem2 = DownloadList.getDownloadTask(driverDownload,
				2);
		String taskName1 = DownloadList.getTaskName(downloadItem1);
		logger.info("下载任务1名称: " + taskName1);
		String startStatusText1 = DownloadList.getDownloadSpeed(downloadItem1);
		logger.info("任务1当前下载状态: " + startStatusText1);
		assertTrue(startStatusText1.indexOf("B/s") > -1);
		String taskName2 = DownloadList.getTaskName(downloadItem2);
		logger.info("下载任务2名称: " + taskName2);
		String startStatusText2 = DownloadList.getDownloadSpeed(downloadItem2);
		logger.info("任务2当前下载状态: " + startStatusText2);
		assertTrue(startStatusText2.indexOf("B/s") > -1);
		// 从菜单中点击全部暂停
		WebElement moreBtn = driverDownload.findElementById("miui:id/more");
		moreBtn.click();
		WebElement allPauseBtn = driverDownload.findElementByName("全部暂停");
		allPauseBtn.click();
		logger.info("全部暂停按钮已点击");
		sleep(1);
		// 验证任务状态
		String pauseStatusText1 = DownloadList.getPauseStatus(downloadItem1);
		logger.info("任务1当前下载状态: " + pauseStatusText1);
		assertEquals(pauseStatusText1, "已暂停");
		String pauseStatusText2 = DownloadList.getPauseStatus(downloadItem2);
		logger.info("任务2当前下载状态: " + pauseStatusText2);
		assertEquals(pauseStatusText2, "已暂停");
		sleep(1);
		// 从菜单中点击全部开始
		moreBtn.click();
		WebElement allStartBtn = driverDownload.findElementByName("全部开始");
		allStartBtn.click();
		logger.info("全部开始按钮已点击");
		sleep(2);
		// 验证任务状态
		String resumeStatusText1 = DownloadList.getDownloadSpeed(downloadItem1);
		logger.info("任务1当前下载状态: " + resumeStatusText1);
		assertTrue(resumeStatusText1.indexOf("B/s") > -1);
		String resumeStatusText2 = DownloadList.getDownloadSpeed(downloadItem2);
		logger.info("任务2当前下载状态: " + resumeStatusText2);
		assertTrue(resumeStatusText2.indexOf("B/s") > -1);
	}

	/*
	 * 单个下载任务重复暂停续传
	 */
	@Test
	public void repeatPauseTest() throws MalformedURLException {
		// 从游戏中心首页下载第一个应用
		GameDownload.downloadGame(1);
		// 启动下载管理进程
		driverDownload = new AndroidDriver(new URL(Constant.URL), capDownload);
		driverDownload.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		retryOnFailure.set(driverDownload);
		// 获取第一个下载任务并验证状态
		WebElement downloadItem = DownloadList.getDownloadTask(driverDownload,
				0);
		String taskName = DownloadList.getTaskName(downloadItem);
		logger.info("下载任务名称: " + taskName);
		String startStatusText = DownloadList.getDownloadSpeed(downloadItem);
		logger.info("当前下载状态: " + startStatusText);
		assertTrue(startStatusText.indexOf("B/s") > -1);
		// 重复暂停续传3次并验证状态
		for (int i = 0; i < 3; i++) {
			WebElement pauseBtn = DownloadList.getPauseButton(downloadItem);
			pauseBtn.click();
			logger.info("暂停按钮已点击");
			sleep(1);
			String pauseStatusText = DownloadList
					.getPauseStatus(downloadItem);
			logger.info("当前下载状态: " + pauseStatusText);
			assertEquals(pauseStatusText, "已暂停");
			sleep(1);

			pauseBtn.click();
			logger.info("续传按钮已点击");
			sleep(2);
			String resumeStatusText = DownloadList
					.getDownloadSpeed(downloadItem);
			logger.info("当前下载状态: " + resumeStatusText);
			assertTrue(resumeStatusText.indexOf("B/s") > -1);
			sleep(1);
		}
	}
}
