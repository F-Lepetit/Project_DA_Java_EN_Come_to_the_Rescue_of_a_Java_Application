package com.hemebiotech.analytics;

/**
 * @author Lepetit Florian
 * @version 1.0
 *
 * Main
 */
public class AnalyticsCounter {

	public static void main(String[] args){
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		reader.GetSymptoms();
		reader.GetMapSymptoms();
		reader.GetSortsMapSymptoms();
		reader.Output();
	}
}