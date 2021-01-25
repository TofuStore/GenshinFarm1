package com.example.thisotheraccount.genshinfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        ToggleButton diligenceToggle = (ToggleButton) findViewById(R.id.Diligence);

        diligenceToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, DiligenceReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 2, intent, PendingIntent.FLAG_ONE_SHOT);

                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)getSystemService(ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK,2);
                calendar.set(Calendar.HOUR,01);

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(Calendar.DAY_OF_WEEK,5);
                calendar2.set(Calendar.HOUR,01);

                Calendar calendar3 = Calendar.getInstance();
                calendar3.set(Calendar.DAY_OF_WEEK,7);
                calendar3.set(Calendar.HOUR,01);


                if (isChecked) {
                    am.setRepeating(am.RTC_WAKEUP, calendar.getTimeInMillis(), am.INTERVAL_DAY*7, pendingIntent);
                    am2.setRepeating(am.RTC_WAKEUP, calendar2.getTimeInMillis(), am2.INTERVAL_DAY*7, pendingIntent2);
                    am3.setRepeating(am.RTC_WAKEUP, calendar3.getTimeInMillis(), am3.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });



        ToggleButton prosperityToggle = (ToggleButton) findViewById(R.id.Prosperity);

        prosperityToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, ProsperityReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 3, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 4, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 5, intent, PendingIntent.FLAG_ONE_SHOT);

                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)getSystemService(ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK,1);
                calendar.set(Calendar.HOUR,01);

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(Calendar.DAY_OF_WEEK,4);
                calendar2.set(Calendar.HOUR,01);

                Calendar calendar3 = Calendar.getInstance();
                calendar3.set(Calendar.DAY_OF_WEEK,7);
                calendar3.set(Calendar.HOUR,01);


                if (isChecked) {
                    am.setRepeating(am.RTC_WAKEUP, calendar.getTimeInMillis(), am.INTERVAL_DAY*7, pendingIntent);
                    am2.setRepeating(am.RTC_WAKEUP, calendar2.getTimeInMillis(), am2.INTERVAL_DAY*7, pendingIntent2);
                    am3.setRepeating(am.RTC_WAKEUP, calendar3.getTimeInMillis(), am3.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });

        ToggleButton goldToggle = (ToggleButton) findViewById(R.id.Gold);

        goldToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, GoldReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 6, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 7, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 8, intent, PendingIntent.FLAG_ONE_SHOT);

                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)getSystemService(ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK,3);
                calendar.set(Calendar.HOUR,01);

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(Calendar.DAY_OF_WEEK,6);
                calendar2.set(Calendar.HOUR,01);

                Calendar calendar3 = Calendar.getInstance();
                calendar3.set(Calendar.DAY_OF_WEEK,7);
                calendar3.set(Calendar.HOUR,01);

                if (isChecked) {
                    am.setRepeating(am.RTC_WAKEUP, calendar.getTimeInMillis(), am.INTERVAL_DAY*7, pendingIntent);
                    am2.setRepeating(am.RTC_WAKEUP, calendar2.getTimeInMillis(), am2.INTERVAL_DAY*7, pendingIntent2);
                    am3.setRepeating(am.RTC_WAKEUP, calendar3.getTimeInMillis(), am3.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });

        ToggleButton freedomToggle = (ToggleButton) findViewById(R.id.Freedom);

        freedomToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, FreedomReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 9, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 10, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 11, intent, PendingIntent.FLAG_ONE_SHOT);

                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)getSystemService(ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK,1);
                calendar.set(Calendar.HOUR,01);

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(Calendar.DAY_OF_WEEK,4);
                calendar2.set(Calendar.HOUR,01);

                Calendar calendar3 = Calendar.getInstance();
                calendar3.set(Calendar.DAY_OF_WEEK,7);
                calendar3.set(Calendar.HOUR,01);

                if (isChecked) {
                    am.setRepeating(am.RTC_WAKEUP, calendar.getTimeInMillis(), am.INTERVAL_DAY*7, pendingIntent);
                    am2.setRepeating(am.RTC_WAKEUP, calendar2.getTimeInMillis(), am2.INTERVAL_DAY*7, pendingIntent2);
                    am3.setRepeating(am.RTC_WAKEUP, calendar3.getTimeInMillis(), am3.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });

        ToggleButton resistanceToggle = (ToggleButton) findViewById(R.id.Resistance);

        resistanceToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, ResistanceReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 12, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 13, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 14, intent, PendingIntent.FLAG_ONE_SHOT);

                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)getSystemService(ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK,2);
                calendar.set(Calendar.HOUR,01);

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(Calendar.DAY_OF_WEEK,5);
                calendar2.set(Calendar.HOUR,01);

                Calendar calendar3 = Calendar.getInstance();
                calendar3.set(Calendar.DAY_OF_WEEK,7);
                calendar3.set(Calendar.HOUR,01);

                if (isChecked) {
                    am.setRepeating(am.RTC_WAKEUP, calendar.getTimeInMillis(), am.INTERVAL_DAY*7, pendingIntent);
                    am2.setRepeating(am.RTC_WAKEUP, calendar2.getTimeInMillis(), am2.INTERVAL_DAY*7, pendingIntent2);
                    am3.setRepeating(am.RTC_WAKEUP, calendar3.getTimeInMillis(), am3.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });

        ToggleButton balladToggle = (ToggleButton) findViewById(R.id.Ballad);

        balladToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, BalladReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 15, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 16, intent, PendingIntent.FLAG_ONE_SHOT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 17, intent, PendingIntent.FLAG_ONE_SHOT);

                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)getSystemService(ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)getSystemService(ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK,3);
                calendar.set(Calendar.HOUR,01);

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(Calendar.DAY_OF_WEEK,6);
                calendar2.set(Calendar.HOUR,01);

                Calendar calendar3 = Calendar.getInstance();
                calendar3.set(Calendar.DAY_OF_WEEK,7);
                calendar3.set(Calendar.HOUR,01);

                if (isChecked) {
                    am.setRepeating(am.RTC_WAKEUP, calendar.getTimeInMillis(), am.INTERVAL_DAY*7, pendingIntent);
                    am2.setRepeating(am.RTC_WAKEUP, calendar2.getTimeInMillis(), am2.INTERVAL_DAY*7, pendingIntent2);
                    am3.setRepeating(am.RTC_WAKEUP, calendar3.getTimeInMillis(), am3.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });

    }
}