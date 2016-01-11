package com.bandunion.item.basewidget;

import java.util.Stack;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bandunion.applist.R;

public class WebViewActivity extends Activity{
	private static String TAG = "WebViewActivity";
	private ProgressBar mPb;
	private WebView mWebView;
	private ImageView ivLogo;
	private ImageView ivBack;
	private TextView tvTitle;
	private ImageView ivClose;
	private Stack<String> stack;

	@SuppressLint("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_basewuse_webview_layout);
		stack = new Stack<String>();
		initViews();
		initListeners();
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setSupportZoom(true);
		mWebView.getSettings().setBuiltInZoomControls(true);
		mWebView.setWebViewClient(new DemoWebViewClient());
		mWebView.addJavascriptInterface(new DemoWebViewPlugin(), "demo");
		String urlString = "http://www.baidu.com";
		mWebView.loadUrl(urlString);
	}

	private void initListeners() {
		ivBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mWebView.canGoBack()){
					stack.pop();
					if(stack.size() == 1)
						isFirstPage();
					mWebView.goBack();
				}
			}
		});
	}

	private void isFirstPage() {
		ivLogo.setVisibility(View.VISIBLE);
		ivClose.setVisibility(View.VISIBLE);
		ivBack.setVisibility(View.GONE);
	}
	
	private void isOtherPage() {
		if(stack.size() ==1 ){
			ivLogo.setVisibility(View.GONE);
			ivClose.setVisibility(View.GONE);
			ivBack.setVisibility(View.VISIBLE);
		}
	}
	
	private void initViews() {
		mWebView = (WebView) findViewById(R.id.btn_basewidget_webview);
		mPb = (ProgressBar) findViewById(R.id.eg_new_center_progress);
		ivLogo = (ImageView) findViewById(R.id.eg_new_center_logo);
		ivBack = (ImageView) findViewById(R.id.eg_new_center_back);
		tvTitle = (TextView) findViewById(R.id.eg_new_center_title);
		ivClose = (ImageView) findViewById(R.id.eg_new_center_close);
	}
	
	class DemoWebViewClient extends WebViewClient{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			mPb.setVisibility(View.VISIBLE);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			isOtherPage();
			tvTitle.setText(view.getTitle());
			mPb.setVisibility(View.GONE);
			if(!stack.contains(url))
				stack.add(url);
		}

		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			super.onReceivedError(view, errorCode, description, failingUrl);
		}
		
	}
	
	class DemoWebViewPlugin{
		
		@JavascriptInterface
		public void run(){
			
		}
	}
}
