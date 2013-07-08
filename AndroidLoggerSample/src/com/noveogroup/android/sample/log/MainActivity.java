package com.noveogroup.android.sample.log;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.noveogroup.android.log.LOG;
import com.noveogroup.android.log.Logger;
import com.noveogroup.android.log.LoggerManager;
import com.noveogroup.android.sample.log.downloader.Downloader;

public class MainActivity extends Activity {

    private static final Logger LOGGER = LoggerManager.getLogger(MainActivity.class, "@@@@@@");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onSampleSimple(View view) {
        LOG.i("sample message");
        LOG.e("sample error message");
    }

    public void onSampleDownload(View view) {
        Downloader.download();
    }

    public void onSampleDynamic(View view) {
        LOGGER.i("This message's tag is not from the configuration");
    }

    public void onSampleDynamicClass(View view) {
        LoggerManager.getLogger(MainActivity.class).i(
                "This is the class name dynamically configured (SimpleName or CanonicalName)");
    }
}
