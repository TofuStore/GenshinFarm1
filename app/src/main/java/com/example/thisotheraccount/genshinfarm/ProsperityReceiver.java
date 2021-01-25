package com.example.thisotheraccount.genshinfarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class ProsperityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent forProsperity = PendingIntent.getActivity(context, 1, intent, 0);
        NotificationCompat.Builder Prosperity = new NotificationCompat.Builder(context, "My Notification")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Talent Level Up Material")
                .setContentText("Farm for Teachings of Prosperity");
        Prosperity.setContentIntent(forProsperity);
        Prosperity.setDefaults(Notification.DEFAULT_SOUND);
        Prosperity.setAutoCancel(true);
        NotificationManager prosperityNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        prosperityNotification.notify(1, Prosperity.build());

    }
}
