package com.example.thisotheraccount.genshinfarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

public class ResistanceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent forResistance = PendingIntent.getActivity(context, 0, intent,0);
        NotificationCompat.Builder Resistance = new NotificationCompat.Builder(context, "My Notification")
                .setSmallIcon(R.mipmap.paimon_icon_round)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.paimon_icon_round))
                .setContentTitle("Talent Level Up Material")
                .setContentText("Farm for Teachings of Resistance");
        Resistance.setContentIntent(forResistance);
        Resistance.setDefaults(Notification.DEFAULT_SOUND);
        Resistance.setAutoCancel(true);
        NotificationManager diligenceNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        diligenceNotification.notify(4, Resistance.build());

    }
}
