package com.xunlei.test.utils.enums;

/**
 * file文件夹中各类型文件对应的坐标值
 * 
 * @author peiyu
 * 
 */
public enum FileType {
	APK(1, 540), ZIP(2, 680), RAR(3, 820), IMG(4, 960), TGZ(5, 1100);

	private final int index;
	private final int coordinate;

	private FileType(int index, int coordinate) {
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
	public static FileType getByCode(int index) {
		for (FileType flag : values()) {
			if (flag.getIndex() == index) {
				return flag;
			}
		}
		return null;
	}
}
