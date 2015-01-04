package com.xunlei.test.utils.enums;

/**
 * media文件夹中各类型文件对应的坐标值
 * 
 * @author peiyu
 * 
 */
public enum MediaType {
	MP3(1, 540), M4A(2, 680), MP4(3, 820);

	private final int index;
	private final int coordinate;

	private MediaType(int index, int coordinate) {
		this.index = index;
		this.coordinate = coordinate;
	}

	public int getIndex() {
		return this.index;
	}

	public int getCoordinate() {
		return this.coordinate;
	}

	/*
	 * 通过序号获取对应文件类型
	 */
	public static MediaType getByCode(int index) {
		for (MediaType flag : values()) {
			if (flag.getIndex() == index) {
				return flag;
			}
		}
		return null;
	}
}
