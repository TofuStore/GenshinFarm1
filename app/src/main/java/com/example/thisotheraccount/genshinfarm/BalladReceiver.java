package com.example.thisotheraccount.genshinfarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class BalladReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent forBallad = PendingIntent.getActivity(context, 0, intent,0);
        NotificationCompat.Builder Ballad = new NotificationCompat.Builder(context, "My Notification")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Talent Level Up Material")
                .setContentText("Farm for Teachings of Ballad");
        Ballad.setContentIntent(forBallad);
        Ballad.setDefaults(Notification.DEFAULT_SOUND);
        Ballad.setAutoCancel(true);
        NotificationManager balladNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        balladNotification.notify(0, Ballad.build());

    }
}
