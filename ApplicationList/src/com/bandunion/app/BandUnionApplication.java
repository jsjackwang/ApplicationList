package com.bandunion.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class BandUnionApplication extends Application {
	private static Handler handler;
	private static Thread mainThread;
	private static Context context;
	private static int mainThreadId;
	
	@Override
	public void onCreate() {
		super.onCreate();
		handler = new Handler();
		mainThread = Thread.currentThread();
		context = getApplicationContext();
		mainThreadId = android.os.Process.myTid();
	}

	public static Handler getHandler() {
		return handler;
	}

	public static Thread getMainThread() {
		return mainThread;
	}

	public static Context getContext() {
		return context;
	}

	public static int getMainThreadId() {
		return mainThreadId;
	}
}
