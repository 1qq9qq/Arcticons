package com.donnnno.arcticons.services;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.widget.RemoteViews;

import com.donnnno.arcticons.R;

public class ClockWidgetTwo extends AppWidgetProvider {
    public void onReceive(Context context, Intent intent) {
        String act = intent.getAction();
        int flags;

        if (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(act)) {
            RemoteViews clockView = new RemoteViews(context.getPackageName(), R.layout.analog_clock_2);

            Intent clockIntent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            clockIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                flags = PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE;
            }
            else {
                flags = 0;
            }
            clockView.setOnClickPendingIntent(R.id.analog_clock_2, PendingIntent.getActivity(context, 0, clockIntent, flags));

            AppWidgetManager.getInstance(context).updateAppWidget(intent.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS), clockView);
        }
    }
}