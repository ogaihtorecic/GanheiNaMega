package io.apiary.megasena.helpers;

import java.util.Calendar;

import io.apiary.megasena.receivers.AlarmReceiver;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmHelper {

	public static void configNextAlarm(Context context) {
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(AlarmReceiver.ALARM_ACTION);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
		
		long nextTrigger = calculateNextTrigger(Calendar.getInstance());
		
		alarmManager.set(AlarmManager.RTC, nextTrigger, pendingIntent);
	}

	public static long calculateNextTrigger(final Calendar c) {
		Calendar calendar = (Calendar) c.clone();
		
		int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(currentDayOfWeek < Calendar.WEDNESDAY) {
			calendar.add(Calendar.DATE, Calendar.WEDNESDAY - currentDayOfWeek);
		} else if(currentDayOfWeek < Calendar.SATURDAY) {
			calendar.add(Calendar.DATE, Calendar.SATURDAY - currentDayOfWeek);
		} else {
			final int FOUR_DAYS  = 4;
			calendar.add(Calendar.DATE, FOUR_DAYS);
		}
		
		calendar.set(Calendar.HOUR, 11);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.AM_PM, Calendar.PM);
		
		return calendar.getTimeInMillis();
	}
	
	private static long nextMinute(final Calendar c) {
		Calendar calendar = (Calendar) c.clone();
		calendar.add(Calendar.MINUTE, 1);
		
		return calendar.getTimeInMillis();
	}
	
}
