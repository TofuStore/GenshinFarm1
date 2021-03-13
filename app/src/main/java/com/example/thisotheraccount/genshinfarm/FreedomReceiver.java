package com.example.thisotheraccount.genshinfarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

public class FreedomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent forFreedom = PendingIntent.getActivity(context, 0, intent,0);
        NotificationCompat.Builder Freedom = new NotificationCompat.Builder(context, "My Notification")
                .setSmallIcon(R.mipmap.paimon_icon_round)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.paimon_icon_round))
                .setContentTitle("Talent Level Up Material")
                .setContentText("Farm for Teachings of Freedom");
        Freedom.setContentIntent(forFreedom);
        Freedom.setDefaults(Notification.DEFAULT_SOUND);
        Freedom.setAutoCancel(true);
        NotificationManager freedomNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        freedomNotification.notify(2, Freedom.build());

    }
}
