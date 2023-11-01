package Lab6;

import java.util.TreeMap;

public interface IInverseFreq {
    /**
     * @param songLyrics TreeMap of Song titles as the key, with their lyrics as values
     * @return TreeMap with words as key, their inverse document frequency as values 
     */
    TreeMap<String, Double> getInverseDocumentFrequency(TreeMap<String, String> songLyrics);
}
