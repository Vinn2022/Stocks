package com.rbc.stocks.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.stocks.entity.StockPerformance;

public class CSVHelper {

	public static String TYPE = "text/csv";
	static String[] HEADERs = { "quarter", "stock", "date", "open", "high", "low", "close", "volume",
			"percent_change_price", "percent_change_volume_over_last_wk", "previous_weeks_volume", "next_weeks_open",
			"next_weeks_close", "percent_change_next_weeks_price", "days_to_next_dividend",
			"percent_return_next_dividend" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<StockPerformance> csvToEntity(InputStream is) throws NumberFormatException, ParseException {
		Scanner sc = new Scanner(is);
		List<StockPerformance> stockPerformances = new ArrayList<>();
		int i = 0;
		while (sc.hasNext()) {
			if (i == 0) {
				i++;
				sc.next();
				continue;
			}
			String[] data = sc.next().split(",");
			String[] dateArray = data[2].split("/");
			StockPerformance stockPerformance = new StockPerformance(
					Integer.parseInt(data[0]), 
					data[1],
					new Date(new SimpleDateFormat("MM/dd/yyyy").parse(data[2]).getTime()),
					Float.parseFloat(data[3].length() != 0 ? data[3].substring(1) : "0.00"),
					Float.parseFloat(data[4].length() != 0 ? data[4].substring(1) : "0.00"),
					Float.parseFloat(data[5].length() != 0 ? data[5].substring(1) : "0.00"),
					Float.parseFloat(data[6].length() != 0 ? data[6].substring(1) : "0.00"),
					new BigInteger(data[7].length() != 0 ? data[7] : "0"),
					Float.parseFloat(data[8].length() != 0 ? data[8] : "0.00"),
					Float.parseFloat(data[9].length() != 0 ? data[9] : "0.00"),
					new BigInteger(data[10].length() != 0 ? data[10] : "0"),
					Float.parseFloat(data[11].length() != 0 ? data[11].substring(1) : "0.00"),
					Float.parseFloat(data[12].length() != 0 ? data[12].substring(1) : "0.00"),
					Float.parseFloat(data[13].length() != 0 ? data[13] : "0.00"),
					Integer.parseInt(data[14].length() != 0 ? data[14] : "0"),
					Float.parseFloat(data[15].length() != 0 ? data[15] : "0.00"));
			stockPerformances.add(stockPerformance);
			i++;
		}
		return stockPerformances;

	}
}
