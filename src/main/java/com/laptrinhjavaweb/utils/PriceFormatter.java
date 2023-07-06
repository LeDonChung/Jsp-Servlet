package com.laptrinhjavaweb.utils;

import java.text.DecimalFormat;

public class PriceFormatter {
	public static String getPrice(Double price) {
		DecimalFormat df = new DecimalFormat("#,###VND");
		return df.format(price);
	}

}
