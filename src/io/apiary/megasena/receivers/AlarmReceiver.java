package io.apiary.megasena.receivers;

import io.apiary.megasena.helpers.AlarmHelper;
import io.apiary.megasena.services.ResultService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

	public static final String ALARM_ACTION = "io.apiary.megasena.action.WAKEUP";

	@Override
	public void onReceive(Context context, Intent intent) {
		context.startService(new Intent(context, ResultService.class));
		AlarmHelper.configNextAlarm(context);
	}

}
