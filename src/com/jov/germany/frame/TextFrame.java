package com.jov.germany.frame;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jov.germany.R;

@SuppressLint("NewApi")
public class TextFrame extends Fragment{
	 @Override  
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) {  
	        return inflater.inflate(R.layout.text_frame, container, false);  
	    }  
}
