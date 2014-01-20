package io.apiary.megasena.helpers;

public class GenericHelper {

	public static String fillWithZeros(final String s, final String zeros,
			final Integer stringSize) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(zeros);
		stringBuilder.append(s);

		return stringBuilder.substring(stringBuilder.length() - stringSize);
	}

}
