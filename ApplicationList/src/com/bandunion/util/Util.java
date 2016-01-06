package com.bandunion.util;

import android.content.Context;
import android.os.Handler;

import com.bandunion.app.BandUnionApplication;

public class Util {
	public static Context getContext(){
		return BandUnionApplication.getContext();
	}
	
	public static Handler getHandler(){
		return BandUnionApplication.getHandler();
	}
	
	public static int getMainThreadId(){
		return BandUnionApplication.getMainThreadId();
	}
	
	public static Thread getMainThread(){
		return BandUnionApplication.getMainThread();
	}
	
	public static boolean isMainThread(){
		return getMainThreadId() == android.os.Process.myTid();
	}
	
	public static void runInMainThread(Runnable runnable){
		if(isMainThread()){
			runnable.run();
		}else{
			getHandler().post(runnable);
		}
	}
}
