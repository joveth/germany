package com.jov.germany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testResource();
	}
	private void testResource(){
		new Thread(new Runnable(){
			@Override
			public void run() {
				getContentFromNetwork();
			}
		}).start();
	}
	private boolean getContentFromNetwork() {
		String path = "http://tie163.qiniudn.com/record.txt";
		URL url;
		String str = "";
		try {
			url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(6 * 1000);
			if (conn.getResponseCode() == 200) { 
				InputStream inStream = conn.getInputStream();
				str = readContent(inStream);
				System.out.println("test result="+str);
			}
			conn.disconnect();
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String readContent(InputStream inStream) {
		StringBuilder resultData = new StringBuilder("");
		try {
			InputStreamReader isr = new InputStreamReader(inStream);
			BufferedReader buffer = new BufferedReader(isr);
			String inputLine = null;
			while ((inputLine = buffer.readLine()) != null) {
				resultData.append(inputLine);
			}
			buffer.close();
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultData.toString();
	}
}
