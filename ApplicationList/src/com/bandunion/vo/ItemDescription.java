package com.bandunion.vo;

public class ItemDescription {
	private String appName;
	private String cls;
	
	public ItemDescription(){}
	
	public ItemDescription(String appName, String cls){
		this.appName = appName;
		this.cls = cls;
	}

	public String getAppName() {
		return appName;
	}

	public String getCls() {
		return cls;
	}
}

