package com.tw;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;

public class Main {

    public static void main(String[] args) throws IOException {

        JythonObjectFactory factory = JythonObjectFactory.getInstance();
        FrequencyCount frequency = (FrequencyCount) factory.createObject(
                FrequencyCount.class, "FrequencyCount");
        long startedAt = System.currentTimeMillis();

        Map<String, Integer> integerMap = frequency.buildFreqMap(readFileToString(new File("data/source.txt")));
        System.out.println("Total no. of keys present: " + integerMap.size());
        long completedAt = System.currentTimeMillis();
        /*for (String key : integerMap.keySet()) {
            System.out.println("Key: " + key + " Value: "+ integerMap.get(key));
        }*/
        System.out.println("Total execution time : " + (completedAt - startedAt) + "ms");
    }
}