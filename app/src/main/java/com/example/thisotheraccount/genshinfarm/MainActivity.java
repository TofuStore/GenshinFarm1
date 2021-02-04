package com.example.thisotheraccount.genshinfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.app.AlarmManager.RTC_WAKEUP;

public class MainActivity extends AppCompatActivity {

    public static void SetToNextDayOfWeek(int dayOfWeekToSet, Calendar c){
        c.add(Calendar.DAY_OF_YEAR, 1);
        int currentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        Log.d("currentDay", String.valueOf(currentDayOfWeek));
        Log.d("setDay", String.valueOf(dayOfWeekToSet));
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Log.d("addDay", sdf.format(c.getTime()));
        //add 1 day to the current day until we get to the day we want
        while(currentDayOfWeek != dayOfWeekToSet){
            c.add(Calendar.DAY_OF_YEAR, 1);
            currentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        //Diligence Talent
        ToggleButton diligenceToggle = (ToggleButton) findViewById(R.id.Diligence);
        boolean DiligenceButton  = sharedPreferences.getBoolean("DiligenceButton", false);
        if(DiligenceButton == true){
            diligenceToggle.setChecked(true);
        }else{
            diligenceToggle.setChecked(false);
        }

        diligenceToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, DiligenceReceiver.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager am = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.TUESDAY, calendar);
                calendar.set(Calendar.HOUR, 1);
                calendar.set(Calendar.MINUTE, 0);

                Calendar calendar2 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.FRIDAY, calendar2);
                calendar2.set(Calendar.HOUR, 1);
                calendar2.set(Calendar.MINUTE, 0);

                Calendar calendar3 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.SUNDAY, calendar3);
                calendar3.set(Calendar.HOUR, 1);
                calendar3.set(Calendar.MINUTE, 0);

                DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
                Log.d("Diligence day 1", sdf.format(calendar.getTime()));
                Log.d("Diligence day 2", sdf.format(calendar2.getTime()));
                Log.d("Diligence day 3", sdf.format(calendar3.getTime()));

                if (isChecked) {
                    editor.putBoolean("DiligenceButton", true);
                    editor.apply();
                    am.setInexactRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent);
                    am2.setInexactRepeating(RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent2);
                    am3.setInexactRepeating(RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    editor.putBoolean("DiligenceButton", false);
                    editor.apply();
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });


        //Prosperity Talent
        ToggleButton prosperityToggle = (ToggleButton) findViewById(R.id.Prosperity);
        boolean ProsperityButton  = sharedPreferences.getBoolean("ProsperityButton", false);
        if(ProsperityButton == true){
            prosperityToggle.setChecked(true);
        }else{
            prosperityToggle.setChecked(false);
        }

        prosperityToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, ProsperityReceiver.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager am = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.MONDAY, calendar);
                calendar.set(Calendar.HOUR, 1);
                calendar.set(Calendar.MINUTE, 0);

                Calendar calendar2 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.THURSDAY, calendar2);
                calendar2.set(Calendar.HOUR, 1);
                calendar2.set(Calendar.MINUTE, 0);

                Calendar calendar3 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.SUNDAY, calendar3);
                calendar3.set(Calendar.HOUR, 1);
                calendar3.set(Calendar.MINUTE, 0);

                DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
                Log.d("Prosperity day 1", sdf.format(calendar.getTime()));
                Log.d("Prosperity day 2", sdf.format(calendar2.getTime()));
                Log.d("Prosperity day 3", sdf.format(calendar3.getTime()));

                if (isChecked) {
                    editor.putBoolean("ProsperityButton", true);
                    editor.apply();
                    am.setInexactRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent);
                    am2.setInexactRepeating(RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent2);
                    am3.setInexactRepeating(RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    editor.putBoolean("ProsperityButton", false);
                    editor.apply();
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });


        //Gold Talent
        ToggleButton goldToggle = (ToggleButton) findViewById(R.id.Gold);
        boolean GoldButton  = sharedPreferences.getBoolean("GoldButton", false);
        if(GoldButton == true){
            goldToggle.setChecked(true);
        }else{
            goldToggle.setChecked(false);
        }

        goldToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, GoldReceiver.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager am = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.WEDNESDAY, calendar);
                calendar.set(Calendar.HOUR, 1);
                calendar.set(Calendar.MINUTE, 0);

                Calendar calendar2 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.SATURDAY, calendar2);
                calendar2.set(Calendar.HOUR, 1);
                calendar2.set(Calendar.MINUTE, 0);

                Calendar calendar3 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.SUNDAY, calendar3);
                calendar3.set(Calendar.HOUR, 1);
                calendar3.set(Calendar.MINUTE, 0);

                DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
                Log.d("Wednesday", sdf.format(calendar.getTime()));
                Log.d("Saturday", sdf.format(calendar2.getTime()));
                Log.d("Sunday", sdf.format(calendar3.getTime()));

                if (isChecked) {
                    editor.putBoolean("GoldButton", true);
                    editor.apply();
                    am.setInexactRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent);
                    am2.setInexactRepeating(RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent2);
                    am3.setInexactRepeating(RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    editor.putBoolean("GoldButton", false);
                    editor.apply();
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });


        //Freedom Talent
        ToggleButton freedomToggle = (ToggleButton) findViewById(R.id.Freedom);
        boolean FreedomButton  = sharedPreferences.getBoolean("FreedomButton", false);
        if(FreedomButton == true){
            freedomToggle.setChecked(true);
        }else{
            freedomToggle.setChecked(false);
        }

        freedomToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, FreedomReceiver.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager am = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.MONDAY, calendar);
                calendar.set(Calendar.HOUR, 1);
                calendar.set(Calendar.MINUTE, 0);

                Calendar calendar2 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.THURSDAY, calendar2);
                calendar2.set(Calendar.HOUR, 1);
                calendar2.set(Calendar.MINUTE, 0);

                Calendar calendar3 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.SUNDAY, calendar3);
                calendar3.set(Calendar.HOUR, 1);
                calendar3.set(Calendar.MINUTE, 0);

                DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
                Log.d("Freedom day 1", sdf.format(calendar.getTime()));
                Log.d("Freedom day 2", sdf.format(calendar2.getTime()));
                Log.d("Freedom day 3", sdf.format(calendar3.getTime()));

                if (isChecked) {
                    editor.putBoolean("FreedomButton", true);
                    editor.apply();
                    am.setInexactRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent);
                    am2.setInexactRepeating(RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent2);
                    am3.setInexactRepeating(RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    editor.putBoolean("FreedomButton", false);
                    editor.apply();
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });


        //Resistance Talent
        ToggleButton resistanceToggle = (ToggleButton) findViewById(R.id.Resistance);
        boolean ResistanceButton  = sharedPreferences.getBoolean("ResistanceButton", false);
        if(ResistanceButton == true){
            resistanceToggle.setChecked(true);
        }else{
            resistanceToggle.setChecked(false);
        }

        resistanceToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, ResistanceReceiver.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager am = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.TUESDAY, calendar);
                calendar.set(Calendar.HOUR, 1);
                calendar.set(Calendar.MINUTE, 0);

                Calendar calendar2 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.FRIDAY, calendar2);
                calendar2.set(Calendar.HOUR, 1);
                calendar2.set(Calendar.MINUTE, 0);

                Calendar calendar3 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.SUNDAY, calendar3);
                calendar3.set(Calendar.HOUR, 1);
                calendar3.set(Calendar.MINUTE, 0);

                DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
                Log.d("Resistance day 1", sdf.format(calendar.getTime()));
                Log.d("Resistance day 2", sdf.format(calendar2.getTime()));
                Log.d("Resistance day 3", sdf.format(calendar3.getTime()));

                if (isChecked) {
                    editor.putBoolean("ResistanceButton", true);
                    editor.apply();
                    am.setInexactRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent);
                    am2.setInexactRepeating(RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent2);
                    am3.setInexactRepeating(RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    editor.putBoolean("ResistanceButton", false);
                    editor.apply();
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });


        //Ballad Talent
        ToggleButton balladToggle = (ToggleButton) findViewById(R.id.Ballad);
        boolean BalladButton  = sharedPreferences.getBoolean("BalladButton", false);
        if(BalladButton == true){
            balladToggle.setChecked(true);
        }else{
            balladToggle.setChecked(false);
        }

        balladToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, BalladReceiver.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(MainActivity.this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager am = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am2 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                AlarmManager am3 = (AlarmManager)MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);

                Calendar calendar = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.WEDNESDAY, calendar);
                calendar.set(Calendar.HOUR, 1);
                calendar.set(Calendar.MINUTE, 0);

                Calendar calendar2 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.SATURDAY, calendar2);
                calendar2.set(Calendar.HOUR, 1);
                calendar2.set(Calendar.MINUTE, 0);

                Calendar calendar3 = Calendar.getInstance();
                SetToNextDayOfWeek(Calendar.SUNDAY, calendar3);
                calendar3.set(Calendar.HOUR, 1);
                calendar3.set(Calendar.MINUTE, 0);

                DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
                Log.d("Ballad day 1", sdf.format(calendar.getTime()));
                Log.d("Ballad day 2", sdf.format(calendar2.getTime()));
                Log.d("Ballad day 3", sdf.format(calendar3.getTime()));

                if (isChecked) {
                    editor.putBoolean("BalladButton", true);
                    editor.apply();
                    am.setInexactRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent);
                    am2.setInexactRepeating(RTC_WAKEUP, calendar2.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent2);
                    am3.setInexactRepeating(RTC_WAKEUP, calendar3.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pendingIntent3);
                } else {
                    editor.putBoolean("BalladButton", false);
                    editor.apply();
                    am.cancel(pendingIntent);
                    am2.cancel(pendingIntent2);
                    am3.cancel(pendingIntent3);
                }
            }
        });

    }
}