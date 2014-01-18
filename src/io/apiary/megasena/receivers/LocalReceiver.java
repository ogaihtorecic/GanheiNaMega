package io.apiary.megasena.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public abstract class LocalReceiver extends BroadcastReceiver {

	@Override
	public abstract void onReceive(Context context, Intent intent);
	
	public abstract IntentFilter getFilters();

}
