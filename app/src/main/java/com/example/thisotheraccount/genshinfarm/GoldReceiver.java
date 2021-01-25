package com.example.thisotheraccount.genshinfarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class GoldReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent forGold= PendingIntent.getActivity(context, 3, intent,0);
        NotificationCompat.Builder Gold = new NotificationCompat.Builder(context, "My Notification")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Talent Level Up Material")
                .setContentText("Farm for Teachings of Gold");
        Gold.setContentIntent(forGold);
        Gold.setDefaults(Notification.DEFAULT_SOUND);
        Gold.setAutoCancel(true);
        NotificationManager goldNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        goldNotification.notify(3, Gold.build());

    }
}
