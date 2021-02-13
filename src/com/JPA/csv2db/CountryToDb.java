package com.JPA.csv2db;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.JPA.dataModel.Country;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CountryToDb {

	public List<Country> CountrycsvToclass() {

		// subnetmask,IPaddress,countrycode,country
		// create a hashmap of colmn header to class attribute

		Map<String, String> mapper = new HashMap<String, String>();

		mapper.put("subnetmask", "SubnetMask");
		mapper.put("IPaddress", "IPaddress");
		mapper.put("countrycode", "CountryCode");
		mapper.put("country", "country");

		// HeaderColumnNameTranslateMappingStrategy
		// for Country class
		HeaderColumnNameTranslateMappingStrategy<Country> strategy = new HeaderColumnNameTranslateMappingStrategy<Country>();
		strategy.setType(Country.class);
		strategy.setColumnMapping(mapper);

		// csvReader
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(
					new FileReader("D:\\Workspace\\TopicsOfjava\\src\\main\\java\\com\\corejava\\csv\\Country.csv"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// csv to bean
		CsvToBean csvBean = new CsvToBean();

		// call the parse method
		List<Country> countrylist = csvBean.parse(strategy, csvReader);
		for (Country country : countrylist) {
			System.out.println(country);

		}

		return countrylist;
	}

	@Test
	public void Countrydetails() {
		List<Country> countrylist1 = CountrycsvToclass();
	}

}
