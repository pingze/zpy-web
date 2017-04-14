package com.zpy.util;

public class DynamicDataSourceHolder {

	private final static ThreadLocal<String> dataSource = new ThreadLocal<>();
	
	public static void setDataSource(String name) {
		dataSource.set(name);
	}

	public static String getDataSource() {
		return dataSource.get();
	}

}
