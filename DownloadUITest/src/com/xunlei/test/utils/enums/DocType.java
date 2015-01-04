package com.xunlei.test.utils.enums;

/**
 * doc文件夹中各类型文件对应的坐标值
 * 
 * @author peiyu
 * 
 */
public enum DocType {
	TXT(1, 540), DOC(2, 680), XLS(3, 820), PPTX(4, 960), PDF(5, 1100);

	private final int index;
	private final int coordinate;

	private DocType(int index, int coordinate) {
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
	public static DocType getByCode(int index) {
		for (DocType flag : values()) {
			if (flag.getIndex() == index) {
				return flag;
			}
		}
		return null;
	}
}
