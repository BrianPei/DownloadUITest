package com.xunlei.test.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.AppiumDriver;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * 用例运行失败时重试
 * 
 * @author peiyu
 * 
 */
public class RetryOnFailure implements TestRule {
	private int retryCount;
	private AppiumDriver driver;

	private static Logger logger = Logger.getLogger(RetryOnFailure.class
			.getName());

	public RetryOnFailure(int retryCount) {
		this.retryCount = retryCount;
	}

	public void set(AppiumDriver driver) {
		this.driver = driver;
	}

	@Override
	public Statement apply(Statement base, Description desc) {
		// TODO Auto-generated method stub
		return statement(base, desc);
	}

	private Statement statement(final Statement base, final Description desc) {
		return new Statement() {
			private String caseName = desc.getMethodName();

			@Override
			public void evaluate() throws Throwable {
				// TODO Auto-generated method stub
				Throwable caughtThrowable = null;

				logger.info("**********" + caseName + " START**********");
				for (int i = 0; i < retryCount; i++) {
					try {
						base.evaluate();
						// 删除所有下载任务
						DownloadList.clearDownloadList(driver);

						logger.info(caseName + " 测试通过!");
						logger.info("**********" + caseName + " END**********");
						return;
					} catch (Throwable e) {
						caughtThrowable = e;
						logger.info(caseName + " 第" + (i + 1) + "次运行失败!");
						logger.error("失败原因:\n" + e.getMessage());

						if (driver != null) {
							// 截图
							takeScreenShot(driver);
							logger.info("已截图! 文件名为" + getCurrentDateTime()
									+ "!");
							// 删除所有下载任务
							DownloadList.clearDownloadList(driver);
						}
					} finally {
						if (driver != null) {
							// 关闭测试进程
							driver.quit();
						}
					}
				}
				logger.info(caseName + " 运行失败" + retryCount + "次! 测试不通过!");
				logger.info("**********" + caseName + " END**********");
				throw caughtThrowable;
			}
		};
	}

	/*
	 * 当前屏幕截图
	 */
	public static void takeScreenShot(AppiumDriver driver) {
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(
					"D:/appium-ScreenShot/"
							+ getCurrentDateTime() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 获取当前时间
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");// 设置日期格式
		return df.format(new Date());
	}

}
