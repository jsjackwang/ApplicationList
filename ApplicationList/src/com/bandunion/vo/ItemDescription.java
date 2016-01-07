package com.bandunion.vo;


public class ItemDescription {
	private String appName;
	private String className;
	
	public ItemDescription(){}
	
	public ItemDescription(String appName, String className){
		this.appName = appName;
		this.className = ("com.bandunion.applist." + className).trim();
	}

	public String getAppName() {
		return appName;
	}

	public String getClassName() {
		return className;
	}
	
	
}

