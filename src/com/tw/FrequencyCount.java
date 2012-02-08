package com.tw;

import java.util.Map;

/**
 * Java interface defining getters and setters
 */

public interface FrequencyCount {

    public Map<String, Integer> buildFreqMap(String text);

}