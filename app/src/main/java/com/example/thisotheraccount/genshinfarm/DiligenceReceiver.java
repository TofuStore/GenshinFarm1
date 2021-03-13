package com.example.thisotheraccount.genshinfarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

public class DiligenceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent forDiligence = PendingIntent.getActivity(context, 0, intent,0);
        NotificationCompat.Builder Diligence = new NotificationCompat.Builder(context, "My Notification")
                .setSmallIcon(R.mipmap.paimon)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.paimon_icon_round))
                .setContentTitle("Talent Level Up Material")
                .setContentText("Farm for Teachings of Diligence");
        Diligence.setContentIntent(forDiligence);
        Diligence.setDefaults(Notification.DEFAULT_SOUND);
        Diligence.setAutoCancel(true);
        NotificationManager diligenceNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        diligenceNotification.notify(0, Diligence.build());

    }
}