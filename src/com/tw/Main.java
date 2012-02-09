package com.tw;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;

public class Main {

    public static void main(String[] args) throws IOException {

        JythonObjectFactory factory = JythonObjectFactory.getInstance();
        FrequencyCount frequency = (FrequencyCount) factory.createObject(
                FrequencyCount.class, "FrequencyCount");
        long startedAt = System.currentTimeMillis();

//        Map<String, Integer> integerMap = frequency.buildFreqMap(readFileToString(new File("data/source.txt")));
        Map<String, List<String>> stringListMap = frequency.groupBySynSet(readFileToString(new File("data/source.txt")));
        for (String key : stringListMap.keySet()) {
            System.out.println(key + ":");
            for (String listItem : stringListMap.get(key)) {
                System.out.println("    " + listItem);
            }
        }
        System.out.println("Total no. of keys present: " + stringListMap.size());
        long completedAt = System.currentTimeMillis();
        System.out.println("Total execution time : " + (completedAt - startedAt) + "ms");
    }
}