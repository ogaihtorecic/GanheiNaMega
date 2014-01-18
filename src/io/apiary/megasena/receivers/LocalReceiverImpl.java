package io.apiary.megasena.receivers;

import io.apiary.megasena.R;
import io.apiary.megasena.ResultActivity;
import io.apiary.megasena.model.Resultado;
import io.apiary.megasena.services.ServiceActions;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class LocalReceiverImpl extends LocalReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		final String action = intent.getAction();
		if (action.equals(ServiceActions.SUCCESS.getAction())) {
			issueNotification(context,
					intent.getExtras().get(Resultado.INTENT_KEY));
		} else if (action.equals(ServiceActions.CONNECTION_FAIL.getAction())) {
			Toast.makeText(context, context.getText(R.string.falha_conexao),
					Toast.LENGTH_SHORT).show();
		} else if (action.equals(ServiceActions.SERVICE_FAIL.getAction())) {
			Toast.makeText(context, context.getText(R.string.falha_servico),
					Toast.LENGTH_SHORT).show();
		}
	}

	private void issueNotification(Context context, Object resultao) {
		Intent resultIntent = new Intent(context, ResultActivity.class);
		PendingIntent resultPendingIntent = PendingIntent.getActivity(context,
				0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setSmallIcon(R.drawable.ic_stat_result)
				.setContentTitle(context.getText(R.string.notification_title))
				.setContentText(context.getText(R.string.notification_text))
				.setContentIntent(resultPendingIntent).setAutoCancel(true);

		int mNotificationId = 001;
		NotificationManager mNotifyMgr = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotifyMgr.notify(mNotificationId, mBuilder.build());

	}

	@Override
	public IntentFilter getFilters() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(ServiceActions.SUCCESS.getAction());
		intentFilter.addAction(ServiceActions.CONNECTION_FAIL.getAction());
		intentFilter.addAction(ServiceActions.SERVICE_FAIL.getAction());

		return intentFilter;
	}

}
