package com.bandunion.vo;

public class ItemDescription {
	private String appName;
	private Class<?> cls;
	
	public ItemDescription(){}
	
	public ItemDescription(String appName, Class<?> cls){
		this.appName = appName;
		this.cls = cls;
	}

	public String getAppName() {
		return appName;
	}

	public Class<?> getCls() {
		return cls;
	}
}

