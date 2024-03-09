package com.example.thuongky;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONParser {
	public static List<Patient> getListOfPatients(String jsonFilePath) {
		List<Patient> patients = new ArrayList<>();
		try (JsonReader reader = Json.createReader(new FileInputStream(jsonFilePath))) {
			JsonArray patientsArray = reader.readArray();
			for (int i = 0; i < patientsArray.size(); i++) {
				JsonObject patientObject = patientsArray.getJsonObject(i);
				Patient patient = new Patient();
				patient.set_id(patientObject.getString("_id"));
				patient.setFirst_name(patientObject.getString("first_name"));
				patient.setLast_name(patientObject.getString("last_name"));
				patient.setBlood_type(patientObject.getString("blood_type"));
				patient.setGender(patientObject.getString("gender"));

				JsonObject addressObject = patientObject.getJsonObject("address");
				Address address = new Address();
				address.setCity(addressObject.getString("city"));
				address.setDistrict(addressObject.getString("district"));
				address.setStreet(addressObject.getString("street"));
				address.setWard(addressObject.getString("ward"));
				patient.setAddress(address);

				JsonArray telephonesArray = patientObject.getJsonArray("telephones");
				List<String> telephones = new ArrayList<>();
				for (int k = 0; k < telephonesArray.size(); k++) {
					telephones.add(telephonesArray.getString(k));
				}
				patient.setTelephones(telephones);

				JsonArray testsArray = patientObject.getJsonArray("tests");
				List<Test> tests = new ArrayList<>();
				for (int j = 0; j < testsArray.size(); j++) {
					JsonObject testObject = testsArray.getJsonObject(j);
					Test test = new Test();
					JsonObject dateObject = testObject.getJsonObject("date");
					Date date = new Date(dateObject.getInt("year"), dateObject.getInt("month"),
							dateObject.getInt("day"));
					test.setDate(date);
					test.setResult(testObject.getString("result"));
					test.setTest_id(testObject.getInt("test_id"));
					test.setTest_type(testObject.getString("test_type"));
					test.setCost(testObject.getJsonNumber("cost").doubleValue());
					tests.add(test);
				}
				patient.setTests(tests);

				patient.setYear_of_birth(patientObject.getInt("year_of_birth"));

				patients.add(patient);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return patients;
	}
}
