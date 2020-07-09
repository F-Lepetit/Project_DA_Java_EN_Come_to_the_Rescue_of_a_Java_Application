package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 * @author Caroline, Lepetit Florian
 * @version 0.2
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

    @Override
    public Map<String, Integer> GetMapSymptoms() {
        return null;
    }

    @Override
    public TreeMap<String, Integer> GetSortsMapSymptoms() {
        return null;
    }

    @Override
    public void Output() {

    }

}
