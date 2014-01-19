package io.apiary.megasena.receivers;

import io.apiary.megasena.R;
import io.apiary.megasena.ResultActivity;
import io.apiary.megasena.helpers.ApostaHelper;
import io.apiary.megasena.model.Aposta;
import io.apiary.megasena.model.Resultado;
import io.apiary.megasena.persistence.ApostaDAO;
import io.apiary.megasena.services.ServiceActions;

import java.util.ArrayList;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class ResultReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		final String action = intent.getAction();
		if (action.equals(ServiceActions.SUCCESS.getAction())) {

			issueNotification(context,
					(Resultado) intent.getExtras().get(Resultado.INTENT_KEY),
					(String) context.getText(R.string.notification_text));

		} else if (action.equals(ServiceActions.CONNECTION_FAIL.getAction())) {

			issueNotification(context,
					(Resultado) intent.getExtras().get(Resultado.INTENT_KEY),
					(String) context.getText(R.string.falha_conexao));

		} else if (action.equals(ServiceActions.SERVICE_FAIL.getAction())) {

			issueNotification(context,
					(Resultado) intent.getExtras().get(Resultado.INTENT_KEY),
					(String) context.getText(R.string.falha_servico));
		}
	}

	private void issueNotification(Context context, Resultado resultado,
			String notificationText) {

		Intent resultIntent = new Intent(context, ResultActivity.class);
		resultIntent.putExtra(Resultado.INTENT_KEY, resultado);
		resultIntent.putExtra(Aposta.INTENT_KEY,
				(ArrayList<Aposta>) ApostaHelper.extractWinners(resultado,
						new ApostaDAO().list()));

		PendingIntent resultPendingIntent = PendingIntent.getActivity(context,
				0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setSmallIcon(R.drawable.ic_stat_result)
				.setContentTitle(context.getText(R.string.notification_title))
				.setContentText(notificationText)
				.setContentIntent(resultPendingIntent).setAutoCancel(true);

		int mNotificationId = 001;
		NotificationManager mNotifyMgr = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		mNotifyMgr.notify(mNotificationId, mBuilder.build());

	}

}
