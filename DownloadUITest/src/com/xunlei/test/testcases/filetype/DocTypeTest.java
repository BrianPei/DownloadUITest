package com.xunlei.test.testcases.filetype;

import static org.junit.Assert.assertTrue;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.xunlei.test.modules.BaiduPanDownload;
import com.xunlei.test.utils.BaseCase;
import com.xunlei.test.utils.Constant;
import com.xunlei.test.utils.DownloadList;
import com.xunlei.test.utils.RetryOnFailure;

public class DocTypeTest extends BaseCase {
	private static AppiumDriver driverDownload;
	
	private static Logger logger = Logger.getLogger(DocTypeTest.class
			.getName());
	
	@Rule
	public RetryOnFailure retryOnFailure = new RetryOnFailure(2);

	/*
	 * txt格式下载测试
	 */
	@Test
	public void txtDownload() throws MalformedURLException {
		// 从百度网盘下载txt格式文件
		BaiduPanDownload.downloadDocfile(1);
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
	 * doc格式下载测试
	 */
	@Test
	public void docDownload() throws MalformedURLException {
		// 从百度网盘下载doc格式文件
		BaiduPanDownload.downloadDocfile(2);
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
	 * xls格式下载测试
	 */
	@Test
	public void xlsDownload() throws MalformedURLException {
		// 从百度网盘下载xls格式文件
		BaiduPanDownload.downloadDocfile(3);
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
	 * ppt格式下载测试
	 */
	@Test
	public void pptDownload() throws MalformedURLException {
		// 从百度网盘下载pptx格式文件
		BaiduPanDownload.downloadDocfile(4);
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
	 * pdf格式下载测试
	 */
	@Test
	public void pdfDownload() throws MalformedURLException {
		// 从百度网盘下载pdf格式文件
		BaiduPanDownload.downloadDocfile(5);
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
