package com.xunlei.test.utils.enums;

/**
 * image文件夹中各类型文件对应的坐标值
 * 
 * @author peiyu
 * 
 */
public enum ImageType {
	JPG(1, 540), JPEG(2, 680), PNG(3, 820), BMP(4, 960), GIF(5, 1100);

	private final int index;
	private final int coordinate;

	private ImageType(int index, int coordinate) {
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
	public static ImageType getByCode(int index) {
		for (ImageType flag : values()) {
			if (flag.getIndex() == index) {
				return flag;
			}
		}
		return null;
	}
}
