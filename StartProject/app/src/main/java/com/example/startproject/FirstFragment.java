package com.example.startproject;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private WebView webview;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        WebView webview = (WebView)rootView.findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);//웹 페이지에서 자바스크립트를 사용 가능하도록 해주는 명령어
        webview.loadUrl("https://eruri.kangwon.ac.kr/");//대상 주소
        webview.setWebViewClient(new WebViewClient());//클릭시 새창이 뜨지 않도록 해줌


        return rootView;
                //inflater.inflate(R.layout.fragment_first, container, false);
    }

}
