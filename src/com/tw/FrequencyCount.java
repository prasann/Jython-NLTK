package com.tw;

import java.util.List;
import java.util.Map;

public interface FrequencyCount {

    public Map<String, Integer> buildFreqMap(String text);
    public Map<String,List<String>> groupBySynSet(String text);

}