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

import com.xunlei.test.utils.Constant;
import com.xunlei.test.utils.enums.DocType;
import com.xunlei.test.utils.enums.FileType;
import com.xunlei.test.utils.enums.ImageType;
import com.xunlei.test.utils.enums.MediaType;

/**
 * 从百度网盘添加下载任务
 * 
 * @author peiyu
 * 
 */
public class BaiduPanDownload extends BrowserDownload {
	private static Logger logger = Logger.getLogger(BaiduPanDownload.class
			.getName());
	

	/*
	 * 从浏览器首页打开百度网盘
	 */
	public static void openBaiduPan(AppiumDriver driver)
			throws InterruptedException {
		WebElement mainView = driver.findElement(
				By.id("com.android.browser:id/scrollView")).findElement(
				By.className("android.widget.FrameLayout"));
		List<WebElement> iconList = mainView.findElements(By
				.className("android.widget.FrameLayout"));
		iconList.get(0).click();
		Thread.sleep(5000);
	}

	/*
	 * 从百度网盘下载media类型文件
	 */
	public static void downloadMediafile(int index) {
		try {
			// 调起browser进程
			driverBrowser = new AndroidDriver(new URL(Constant.URL), capBrowser);
			driverBrowser.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);

			// 打开新页面
			openNewPage(driverBrowser);
			// 从首页点击访问百度网盘
			openBaiduPan(driverBrowser);
			// 点击访问media文件夹
			driverBrowser.tap(1, 550, 820, 300);
			Thread.sleep(2000);
			// 点击列表中指定文件
			driverBrowser.tap(1, 550, MediaType.getByCode(index)
					.getCoordinate(), 300);
			Thread.sleep(3000);
			// 点击下载按钮
			driverBrowser.tap(1, 550, 1080, 300);
			driverBrowser.tap(1, 550, 1230, 300);
			Thread.sleep(2000);
			// 点击确定按钮
			driverBrowser.findElement(By.id("android:id/button1")).click();
			logger.info("百度网盘添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("百度网盘添加下载任务失败!");
		} finally {
			// 退出进程
			driverBrowser.quit();
		}
	}

	/*
	 * 从百度网盘下载image类型文件
	 */
	public static void downloadImagefile(int index) {
		try {
			// 调起browser进程
			driverBrowser = new AndroidDriver(new URL(Constant.URL), capBrowser);
			driverBrowser.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);

			// 打开新页面
			openNewPage(driverBrowser);
			// 从首页点击访问百度网盘
			openBaiduPan(driverBrowser);
			// 点击访问image文件夹
			driverBrowser.tap(1, 550, 680, 300);
			Thread.sleep(2000);
			// 点击列表中指定文件
			driverBrowser.tap(1, 550, ImageType.getByCode(index)
					.getCoordinate(), 300);
			Thread.sleep(3000);
			// 点击下载按钮
			driverBrowser.tap(1, 550, 1080, 300);
			driverBrowser.tap(1, 550, 1230, 300);
			Thread.sleep(2000);
			// 点击确定按钮
			driverBrowser.findElement(By.id("android:id/button1")).click();
			logger.info("百度网盘添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("百度网盘添加下载任务失败!");
		} finally {
			// 退出进程
			driverBrowser.quit();
		}
	}

	/*
	 * 从百度网盘下载doc类型文件
	 */
	public static void downloadDocfile(int index) {
		try {
			// 调起browser进程
			driverBrowser = new AndroidDriver(new URL(Constant.URL), capBrowser);
			driverBrowser.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);

			// 打开新页面
			openNewPage(driverBrowser);
			// 从首页点击访问百度网盘
			openBaiduPan(driverBrowser);
			// 点击访问media文件夹
			driverBrowser.tap(1, 550, 400, 300);
			Thread.sleep(2000);
			// 点击列表中指定文件
			driverBrowser.tap(1, 550, DocType.getByCode(index).getCoordinate(),
					300);
			Thread.sleep(3000);
			// 点击下载按钮
			driverBrowser.tap(1, 550, 1080, 300);
			driverBrowser.tap(1, 550, 1230, 300);
			Thread.sleep(2000);
			// 点击确定按钮
			driverBrowser.findElement(By.id("android:id/button1")).click();
			logger.info("百度网盘添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("百度网盘添加下载任务失败!");
		} finally {
			// 退出进程
			driverBrowser.quit();
		}
	}

	/*
	 * 从百度网盘下载其余类型文件
	 */
	public static void downloadOtherfile(int index) {
		try {
			// 调起browser进程
			driverBrowser = new AndroidDriver(new URL(Constant.URL), capBrowser);
			driverBrowser.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);

			// 打开新页面
			openNewPage(driverBrowser);
			// 从首页点击访问百度网盘
			openBaiduPan(driverBrowser);
			// 点击访问media文件夹
			driverBrowser.tap(1, 550, 540, 300);
			Thread.sleep(2000);
			// 点击列表中指定文件
			driverBrowser.tap(1, 550,
					FileType.getByCode(index).getCoordinate(), 300);
			Thread.sleep(3000);
			// 点击下载按钮
			driverBrowser.tap(1, 550, 1080, 300);
			driverBrowser.tap(1, 550, 1230, 300);
			Thread.sleep(2000);
			// 点击确定按钮
			driverBrowser.findElement(By.id("android:id/button1")).click();
			logger.info("百度网盘添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("百度网盘添加下载任务失败!");
		} finally {
			// 退出进程
			driverBrowser.quit();
		}
	}

	/*
	 * 从百度网盘下载超大文件（2G）
	 */
	public static void downloadBigfile() {
		try {
			// 调起browser进程
			driverBrowser = new AndroidDriver(new URL(Constant.URL), capBrowser);
			driverBrowser.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);

			// 打开新页面
			openNewPage(driverBrowser);
			// 从首页点击访问百度网盘
			openBaiduPan(driverBrowser);
			// 点击列表中指定文件
			driverBrowser.tap(1, 550, 960, 300);
			Thread.sleep(3000);
			// 点击下载按钮
			driverBrowser.tap(1, 550, 1450, 300);
			Thread.sleep(2000);
			// 点击确定按钮
			driverBrowser.findElement(By.id("android:id/button1")).click();
			logger.info("百度网盘添加下载任务成功!");
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("百度网盘添加下载任务失败!");
		} finally {
			// 退出进程
			driverBrowser.quit();
		}
	}
}
