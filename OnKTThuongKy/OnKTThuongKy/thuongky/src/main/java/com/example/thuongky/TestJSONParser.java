package com.example.thuongky;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestJSONParser {
	public static void main(String[] args) {
		String jsonFilePath = "D:\\Learn\\LTPT\\OnKTThuongKy\\thuongky\\src\\main\\java\\com\\example\\thuongky\\patients.json"; // Thay
																																	// đổi
																																	// đường
																																	// dẫn
																																	// tới
																																	// file
																																	// JSON
		List<Patient> patients = JSONParser.getListOfPatients(jsonFilePath);
		writeResultsToFile(patients,
				"D:\\Learn\\LTPT\\OnKTThuongKy\\thuongky\\src\\main\\java\\com\\example\\thuongky\\result.txt"); // Ghi
																													// kết
																													// quả
																													// vào
																													// file
																													// result.txt
	}

	private static void writeResultsToFile(List<Patient> patients, String fileName) {
		try (FileWriter writer = new FileWriter(fileName)) {
			for (Patient patient : patients) {
				writer.write("Patient ID: " + patient.get_id() + "\n");
				writer.write("Patient Name: " + patient.getFirst_name() + " " + patient.getLast_name() + "\n");
				writer.write("Blood Type: " + patient.getBlood_type() + "\n"); // Thêm blood type
				writer.write("Gender: " + patient.getGender() + "\n"); // Thêm gender
				Address address = patient.getAddress();
				writer.write("Address: " + address.getStreet() + ", " + address.getWard() + ", " + address.getDistrict()
						+ ", " + address.getCity() + "\n");

				writer.write("Telephones:\n");
				for (String telephone : patient.getTelephones()) {
					writer.write(telephone + "\n");
				}
				writer.write("Tests:\n");

				for (Test test : patient.getTests()) {
					writer.write("Test ID: " + test.getTest_id() + "\n"); // Thêm test ID
					writer.write("Date: " + test.getDate().toString() + "\n");
					writer.write("Result: " + test.getResult() + "\n");
					writer.write("Test Type: " + test.getTest_type() + "\n");
					writer.write("Cost: $" + test.getCost() + "\n");
				}
				writer.write("Year of Birth: " + patient.getYear_of_birth() + "\n"); // Thêm year of birth
				writer.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
