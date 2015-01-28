package com.xunlei.test.utils;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DownloadList {
	/**
	 * 获取下载列表中指定一个下载任务
	 * 
	 * @param driver
	 * @return
	 */
	public static WebElement getDownloadTask(AppiumDriver driver, int i) {
		WebElement mainList = driver.findElementById("android:id/list");
		List<WebElement> downloadList = mainList.findElements(By
				.className("android.widget.LinearLayout"));
		WebElement downloadItem = downloadList.get(i);
		return downloadItem;
	}

	/**
	 * 获取下载任务的暂停/开始按钮
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement getPauseButton(WebElement element) {
		WebElement actionBtn = element.findElement(By
				.className("android.widget.LinearLayout"));
		WebElement pauseBtn = actionBtn.findElement(By
				.className("android.widget.ProgressBar"));
		return pauseBtn;
	}

	/**
	 * 获取下载任务的速度
	 * 
	 * @param element
	 * @return
	 */
	public static String getDownloadSpeed(WebElement element) {
		WebElement dateStatus = element.findElement(By
				.id("com.android.providers.downloads.ui:id/date_status_info_new"));
		return dateStatus.getText();
	}
	
	/**
	 * 获取下载任务的暂停状态
	 * 
	 * @param element
	 * @return
	 */
	public static String getPauseStatus(WebElement element) {
		WebElement pauseStatus = element.findElement(By
				.id("com.android.providers.downloads.ui:id/date_status_info"));
		return pauseStatus.getText();
	}
	
	
	/**
	 * 获取下载任务的名称
	 * 
	 * @param element
	 * @return
	 */
	public static String getTaskName(WebElement element) {
		WebElement taskName = element.findElement(By
				.id("com.android.providers.downloads.ui:id/download_title"));
		return taskName.getText();
	}

	/**
	 * 清空下载列表
	 * 
	 * @param driver
	 * @param element
	 */
	public static void clearDownloadList(AppiumDriver driver) {
		WebElement element = getDownloadTask(driver, 0);
		TouchAction touch = new TouchAction(driver);
		touch.longPress(element).perform();
		WebElement allSelect = driver.findElementById("android:id/button2");
		if (allSelect.getText().equals("全选")) {
			allSelect.click();
		}
		WebElement deleteBtn = driver.findElementByName("删除");
		deleteBtn.click();
		driver.findElementById("android:id/button1").click();
	}
}
