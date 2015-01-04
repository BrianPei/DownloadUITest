package com.xunlei.test.testcases.filetype;

import static org.junit.Assert.assertTrue;

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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class OtherTypeTest extends BaseCase {
	private static AppiumDriver driverDownload;

	private static Logger logger = Logger.getLogger(OtherTypeTest.class
			.getName());
	
	@Rule
	public RetryOnFailure retryOnFailure = new RetryOnFailure(2);

	/*
	 * apk格式下载测试
	 */
	@Test
	public void apkDownload() throws MalformedURLException {
		// 从百度网盘下载apk格式文件
		BaiduPanDownload.downloadOtherfile(1);
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
	 * zip格式下载测试
	 */
	@Test
	public void zipDownload() throws MalformedURLException {
		// 从百度网盘下载zip格式文件
		BaiduPanDownload.downloadOtherfile(2);
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
	 * rar格式下载测试
	 */
	@Test
	public void rarDownload() throws MalformedURLException {
		// 从百度网盘下载rar格式文件
		BaiduPanDownload.downloadOtherfile(3);
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
	 * img格式下载测试
	 */
	@Test
	public void imgDownload() throws MalformedURLException {
		// 从百度网盘下载img格式文件
		BaiduPanDownload.downloadOtherfile(4);
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
	 * tgz格式下载测试
	 */
	@Test
	public void tgzDownload() throws MalformedURLException {
		// 从百度网盘下载tgz格式文件
		BaiduPanDownload.downloadOtherfile(5);
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
	 * 超大文件下载测试
	 */
	@Test
	public void bigFileDownload() throws MalformedURLException {
		// 从百度网盘下载超大文件
		BaiduPanDownload.downloadBigfile();
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
