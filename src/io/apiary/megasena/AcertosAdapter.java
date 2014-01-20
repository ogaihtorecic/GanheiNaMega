package io.apiary.megasena;

import io.apiary.megasena.helpers.GenericHelper;
import io.apiary.megasena.model.Aposta;
import io.apiary.megasena.model.Resultado;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AcertosAdapter extends BaseAdapter {

	private List<Aposta> apostas;
	private Resultado resultado;
	private Context context;

	public AcertosAdapter(List<Aposta> apostas, Resultado resultado,
			Context context) {
		this.apostas = apostas;
		this.resultado = resultado;
		this.context = context;
	}

	@Override
	public int getCount() {
		return apostas.size();
	}

	@Override
	public Object getItem(int position) {
		return apostas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Aposta aposta = this.apostas.get(position);
		ViewHolder viewHolder;
		LayoutInflater layoutInflater = (LayoutInflater) this.context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView != null) {
			viewHolder = (ViewHolder) convertView.getTag();

		} else {

			convertView = layoutInflater.inflate(R.layout.activity_result_item, null);

			viewHolder = new ViewHolder();

			viewHolder.tvAcertos = (TextView) convertView.findViewById(R.id.tv_acertos);
			viewHolder.tvAcertos.setText(aposta.getAcertos().toString());

			inicializarTextoDezenas(convertView, viewHolder);

			destacarDezenasSorteadas(aposta, viewHolder);

			camuflarDezenasDesnecessarias(viewHolder);

			convertView.setTag(viewHolder);
		}

		return convertView;
	}
	
	private void inicializarTextoDezenas(View convertView, ViewHolder viewHolder) {
		for (int i = 0; i < viewHolder.ids.length; i++) {
			viewHolder.tvArray[i] = (TextView) convertView.findViewById(viewHolder.ids[i]);
			viewHolder.tvArray[i].setText("");
		}
	}

	private void destacarDezenasSorteadas(Aposta aposta, ViewHolder viewHolder) {
		Set<Integer> setDezenas = aposta.getDezenas();
		int i = 0;
		for (Integer dezena : setDezenas) {
			viewHolder.tvArray[i].setText(GenericHelper.fillWithZeros(
					dezena.toString(), "0", 2));
			if (isAcerto(dezena, resultado)) {
				viewHolder.tvArray[i].setTypeface(null, Typeface.BOLD);
			}
			i++;
		}
	}
	
	private void camuflarDezenasDesnecessarias(ViewHolder viewHolder) {
		for (int j = 0; j < viewHolder.tvArray.length; j++) {
			if ("".equals(viewHolder.tvArray[j].getText())) {
				viewHolder.tvArray[j].setVisibility(View.INVISIBLE);
			}
		}
	}

	private boolean isAcerto(Integer dezena, Resultado r) {
		return Arrays.binarySearch(
				new Integer[] { r.getDezena1(), r.getDezena2(), r.getDezena3(),
						r.getDezena4(), r.getDezena5(), r.getDezena6() },
				dezena) > -1;
	}

	static class ViewHolder {

		private TextView tvAcertos, tvDez1, tvDez2, tvDez3, tvDez4, tvDez5,
				tvDez6, tvDez7, tvDez8, tvDez9, tvDez10, tvDez11, tvDez12,
				tvDez13, tvDez14, tvDez15;

		private int[] ids = new int[] { R.id.textView1, R.id.textView2,
				R.id.textView3, R.id.textView4, R.id.textView5, R.id.textView6,
				R.id.textView7, R.id.textView8, R.id.textView9,
				R.id.textView10, R.id.textView11, R.id.textView12,
				R.id.textView13, R.id.textView14, R.id.textView15 };

		private TextView[] tvArray = new TextView[] { tvDez1, tvDez2, tvDez3,
				tvDez4, tvDez5, tvDez6, tvDez7, tvDez8, tvDez9, tvDez10,
				tvDez11, tvDez12, tvDez13, tvDez14, tvDez15 };
	}

}
