package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Caroline, Lepetit Florian
 * @version 1.0
 * Interface that read a file to transform it into a Map sorted in alphabetical and write the result in result.out
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> GetSymptoms();

	/**
	 * if no data is available, return an empty map
	 * Get a map thanks to the ArrayList in GetSymptoms
	 *
	 * @return an unordered map of all symptoms, delete the duplicates by counting them
	 */
	Map<String, Integer> GetMapSymptoms();

	/**
	 * if no data is available, return an empty sorted map (TreeMap)
	 * Get a sorted map (TreeMap) of all symptoms thanks to MapSymptoms
	 *
	 * @return a sorted map (TreeMap) containing both the symptoms and their counts
	 */
	TreeMap<String, Integer> GetSortsMapSymptoms();

	/**
	 * If no data available, print nothing
	 * Read the sorted map, both print it and writing in result.out
	 */
	void Output();
}
