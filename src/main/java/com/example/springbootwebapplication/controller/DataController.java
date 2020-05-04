package com.example.springbootwebapplication.controller;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class DataController {

	static Logger logger = Logger.getLogger(DataController.class);

	@RequestMapping(value = "/servicecheck", method = RequestMethod.GET)
	public String servicecheck() {
		return "This is the First Message From Remote common-data-service!";
	}

	@RequestMapping(value = "/testData", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> testData() {
		String results = "";
		try {
			JSONArray array = new JSONArray();
			
			JSONObject json = new JSONObject();
			json.accumulate("cityname", "London");
			json.accumulate("statecode", "");
			json.accumulate("countrycode", "GB");
			json.accumulate("vendorcitycode", "20142");
			json.accumulate("countryname", "United Kingdom");
			
			array.add(json);
			
			json = new JSONObject();
			json.accumulate("cityname", "Lancaster");
			json.accumulate("statecode", "");
			json.accumulate("countrycode", "GB");
			json.accumulate("vendorcitycode", "23711");
			json.accumulate("countryname", "United Kingdom");
			
			array.add(json);

			results = array.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok(results);
	}

}
