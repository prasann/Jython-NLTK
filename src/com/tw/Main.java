package com.tw;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;

public class Main {

    public static void main(String[] args) throws IOException {

         // Obtain an instance of the object factory
        JythonObjectFactory factory = JythonObjectFactory.getInstance();

        // Call the createObject() method on the object factory by
        // passing the Java interface and the name of the Jython module
        // in String format. The returning object is casted to the the same
        // type as the Java interface and stored into a variable.

        FrequencyCount frequency = (FrequencyCount) factory.createObject(
                FrequencyCount.class, "FrequencyCount");
        long startedAt = System.currentTimeMillis();

        Map<String, Integer> integerMap = frequency.buildFreqMap(readFileToString(new File("data/source.txt")));
        /*
        for (String key : integerMap.keySet()) {
            Integer value = integerMap.get(key);
            System.out.println("Key: " + key + " Frequency: " + value.toString());
        }
        */
        System.out.println("Total no. of keys present: " + integerMap.size());
        long completedAt = System.currentTimeMillis();
        System.out.println("Total execution time : " + (completedAt - startedAt) + "ms");
    }
}