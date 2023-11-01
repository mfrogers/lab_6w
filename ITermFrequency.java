package Lab6;

import java.util.TreeMap;

public interface ITermFrequency {
    /**
     * @param songLyrics TreeMap of Song titles as the key, with their lyrics as values
     * @return TreeMap with song title as the key, and value representing a TreeMap. In the inner TreeMap
     * each key is a word, with term frequency saved as a double
     */
    TreeMap<String, TreeMap<String, Double>> getTermFrequency(TreeMap<String, String> songLyrics);
}
