package com.example.Cornacase.Service;

import com.example.Cornacase.Model.DATA;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CornaCaseDataService {

	public static String URlvar = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";


	public List<DATA> getData()  {
		List<DATA> inputList = new ArrayList<DATA>();
		try {
			URL oracle = new URL(URlvar);
			URLConnection yc = oracle.openConnection();


			BufferedReader br = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			// skip the header of the csv

			CSVReader reader = new CSVReader(br);
			List<String[]> allRows = reader.readAll().stream().skip(1).collect(Collectors.toList());

			// inputList = br.lines().skip(n).collect(Collectors.toList());

			for (String[] row : allRows) {
				DATA d = new DATA();
				d.setProvince(row[0]);
				d.setCountry(row[1]);
				d.setLat(row[2]);
				d.setLong(row[3]);
				d.setDate(Integer.parseInt(row[row.length - 1]));
				inputList.add(d);
				d = null;


			}
			System.out.println(inputList);
		}catch ( Exception e)
		{
			System.err.println(e.getStackTrace());
		}
		return inputList;

	}
}
