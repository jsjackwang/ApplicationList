package com.bandunion.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	private static String TAG = "HttpUtil";
	public static String doGet(String dataUrl){
		Util.log(TAG,"doGet dataUrl ----->" + dataUrl);
		StringBuffer sb = new StringBuffer();
		try{
			URL url = new URL(dataUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			if (conn.getResponseCode() == 200){
				InputStream is = conn.getInputStream();
				int len = 0;
				byte[] buf = new byte[1024];
				while ((len = is.read(buf)) != -1){
					sb.append(new String(buf, 0, len, "UTF-8"));
				}
			} else{
				Util.log(TAG, "requestCode ------> " + conn.getResponseCode());
				throw new IOException("ÍøÂçÒì³£");
			}
		} catch (Exception e){
			Util.log(TAG, "doGet Exception------>" + e.getMessage());
			return null;
		}
		return sb.toString();
	}
}
