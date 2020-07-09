package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * Simple brute force implementation
 *
 * @author Caroline, Lepetit Florian
 * @version 0.8.2
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Generate an ArrayList by reading each line in the file given by the filepath
     *
     * @return The ArrayList created by the method
     * @throws java.io.IOException is about all Input and Output exception like java.io.FileNotFoundException
     * @see #filepath
     */
    @Override
    public List<String> GetSymptoms() {
        ArrayList<String> result = new ArrayList<>();
        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
                System.out.println("Wrong filepath specified !");
            }
        }

        return result;
    }

	/**
	 * Create a hashMap and count the symptoms by reading each entry of result from the method GetSymptoms
	 *
	 * @return an unordered Map of the symptoms without duplicates
	 * @see #GetSymptoms()
	 * <p>it delete the duplicates and count the number of each symptoms</p>
	 */
	@Override
	public Map<String, Integer> GetMapSymptoms() {
		Map<String, Integer> uSymptoms = new HashMap<>();

		for (String key : GetSymptoms()) {

			if (uSymptoms.containsKey(key)) {
				uSymptoms.replace(key, uSymptoms.get(key) + 1);
			} else {
				uSymptoms.put(key, 1);
			}
		}
		return uSymptoms;
	}

	/**
	 * Create a TreeMap to sort the hashMap that is returned by MapSymptoms()
	 *
	 * @return an alphabetical sorted Map of the symptoms
	 * @see #GetMapSymptoms()
	 * <p>It copy both the key and the value and sort in alphabetical order</p>
	 */
	@Override
	public TreeMap<String, Integer> GetSortsMapSymptoms() {
		TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();
		for (Map.Entry<String, Integer> entry : GetMapSymptoms().entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			sortedSymptoms.put(key, value);
		}
		return sortedSymptoms;
	}

	/**
	 * Both write and print an output
	 * <ul>
	 *     <li>write the result in a file named "result.out"</li>
	 *     <li>print in the console the output</li>
	 * </ul>
	 *
	 * @throws java.io.IOException is about all Input and Output exception like java.io.FileNotFoundException
	 */
	@Override
	public void Output() {
		try {
			FileWriter writer = new FileWriter("result.out");
			for (String key : GetSortsMapSymptoms().keySet()) {
				System.out.println(key + ":" + GetSortsMapSymptoms().get(key));
				writer.write(key + ":" + GetSortsMapSymptoms().get(key) + "\n");
			}
			writer.close();
		} catch (java.io.IOException e) {
			e.printStackTrace();
			System.out.println("this file can't be created, edited or opened for any reasons.");
		}
	}
}
