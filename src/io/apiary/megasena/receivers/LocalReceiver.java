package io.apiary.megasena.receivers;

import io.apiary.megasena.R;
import io.apiary.megasena.services.ServiceActions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		final String action = intent.getAction();
		if (action.equals(ServiceActions.SUCCESS.getAction())) {
			setupNotification(context);
		} else if (action.equals(ServiceActions.CONNECTION_FAIL.getAction())) {
			Toast.makeText(context, context.getText(R.string.falha_conexao), Toast.LENGTH_SHORT).show();
		} else if (action.equals(ServiceActions.SERVICE_FAIL.getAction())) {
			Toast.makeText(context, context.getText(R.string.falha_servico), Toast.LENGTH_SHORT).show();
		}
	}

	private void setupNotification(Context context) {
		NotificationCompat.Builder mBuilder =
			    new NotificationCompat.Builder(context)
			    .setSmallIcon(R.drawable.ic_launcher)
			    .setContentTitle("My notification")
			    .setContentText("Hello World!");
		//TODO: Continuar implementação...
	}

	public IntentFilter getFilters() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(ServiceActions.SUCCESS.getAction());
		intentFilter.addAction(ServiceActions.CONNECTION_FAIL.getAction());
		intentFilter.addAction(ServiceActions.SERVICE_FAIL.getAction());
		
		return intentFilter;
	}
	
}
