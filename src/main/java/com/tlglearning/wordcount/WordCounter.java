package com.tlglearning.wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class WordCounter {

  private final Map<String, Integer> counts;

  public WordCounter(String text) {
    String[] words = splitWords(text);
    counts = Collections.unmodifiableMap(countWords(Arrays.toString(words)));
    for (String word : words) {
      //DONE Check if word is already present as a key in counts;
      //  If its not present, add it to counts with a value of 1;
      //  Otherwise, get the current value, add 1 to it, and update the map with the new value;
      countWords(word);
    }
  }

  public Set<String> words() {
    return counts.keySet();
  }

  public int getCount(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return counts;
  }

  @Override
  public String toString() {
    return counts.toString();
  }

  String[] splitWords(String text) {
    return text
        .toLowerCase()
        .split("[\\W_]+");
  }

  Map<String, Integer> countWords(String word) {
    Map<String, Integer> counts = new HashMap<>();
    if (!counts.containsKey(word)) {
      counts.put(word, 1);
    } else {
      int previousCount = counts.get(word);
      counts.put(word, previousCount + 1);
    }
    return counts;
  }
}
