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

public class ImageTypeTest extends BaseCase {
	private static AppiumDriver driverDownload;

	private static Logger logger = Logger.getLogger(ImageTypeTest.class
			.getName());

	@Rule
	public RetryOnFailure retryOnFailure = new RetryOnFailure(2);

	/*
	 * jpg格式下载测试
	 */
	@Test
	public void jpgDownload() throws MalformedURLException {
		// 从百度网盘下载jpg格式文件
		BaiduPanDownload.downloadImagefile(1);
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
	 * jpeg格式下载测试
	 */
	@Test
	public void jpegDownload() throws MalformedURLException {
		// 从百度网盘下载jpeg格式文件
		BaiduPanDownload.downloadImagefile(2);
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
	 * png格式下载测试
	 */
	@Test
	public void pngDownload() throws MalformedURLException {
		// 从百度网盘下载png格式文件
		BaiduPanDownload.downloadImagefile(3);
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
	 * bmp格式下载测试
	 */
	@Test
	public void bmpDownload() throws MalformedURLException {
		// 从百度网盘下载bmp格式文件
		BaiduPanDownload.downloadImagefile(4);
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
	 * gif格式下载测试
	 */
	@Test
	public void gifDownload() throws MalformedURLException {
		// 从百度网盘下载gif格式文件
		BaiduPanDownload.downloadImagefile(5);
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
