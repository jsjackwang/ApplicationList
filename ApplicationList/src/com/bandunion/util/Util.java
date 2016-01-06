package com.bandunion.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.bandunion.app.BandUnionApplication;

public class Util {
	
	private static boolean isLog = true;
	
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
	
	public static View Inflate(int layoutId){
		return View.inflate(getContext(), layoutId, null);
	}
	
	public static void startActivity(Activity context, Class<?> cls){
		Intent intent = new Intent(context, cls);
		context.startActivity(intent);
	}
	
	public static void log(String TAG, String info){
		if (isLog) {
			Log.i(TAG, info);
		}
	}
}
