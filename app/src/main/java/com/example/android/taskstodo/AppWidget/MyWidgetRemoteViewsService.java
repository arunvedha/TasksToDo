package com.example.android.taskstodo.AppWidget;

import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViewsService;

public class MyWidgetRemoteViewsService extends RemoteViewsService {
    private static final String TAG = "WidgetService";

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.d(TAG, "onGetViewFactory: " + "Service called");
        return new AdapterForWidget(this.getApplicationContext(), intent);
    }
}
