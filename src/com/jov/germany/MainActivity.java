package com.jov.germany;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TabHost;

public class MainActivity extends ActionBarActivity {
	private TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initTab();
	}

	private void initTab() {
		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup();
		// tabHost.setBackgroundResource(R.drawable.topbar_bg);
		tabHost.addTab(tabHost.newTabSpec("imageTab").setIndicator("ͼƬ")
				.setContent(R.id.image_tab));
		tabHost.addTab(tabHost.newTabSpec("textTab").setIndicator("�ճ�")
				.setContent(R.id.text_tab));
		tabHost.addTab(tabHost.newTabSpec("bothTab").setIndicator("�ϼ�")
				.setContent(R.id.both_tab));
		tabHost.setCurrentTab(0);
	}
}
