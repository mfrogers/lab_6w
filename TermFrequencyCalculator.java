package Lab6;

import java.util.TreeMap;

public class TermFrequencyCalculator implements ITermFrequency {

	/*
	 * Ethan Gilles
	 * This calculator will return a treeMap that has song titles as a key and another treemap as a value
	 * the submap will contain a word in the song as a value and a Term Frequency number for the value.
	 */
	
	
    @Override
    public TreeMap<String, TreeMap<String, Double>> getTermFrequency(TreeMap<String, String> songLyrics) {
        
    	TreeMap<String, TreeMap<String, Double>> result = new TreeMap<String, TreeMap<String, Double>> ();
        
        int numSongs = 0;
        int numWords = 0;
        for(String songTitle: songLyrics.keySet()) {
       	 	String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
            numWords = words.length;
            numSongs++;
        }
        
        public double songWordAvg = numWords / numSongs; //AvgS
        
        for(String songTitle: songLyrics.keySet())
        {
            // For each song you have to create TF values
            TreeMap<String, Double> tempMap = new TreeMap<String, Double>();

            // current lyrics
            String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
           
            
            // Calculate the Term Frequency (TF) Values here and save them in tempMap
            
            // You might need to introduce other methods and additional variables
            
            // TF for Term (word) X in Song S is calculated as 
            // f(X,S) . (2.2) / (f(X,S) + 1.2 . (0.25+0.75 .|S|/AvgS)
            // where f(X,S) is the frequency of term X in song S
            // |S| is the length of song in terms of number of words
            // AvgS is the average length of songs based on number of words
            
            
            // Go through all of the words
            for(String word: words) { 
            	if(!tempMap.containsKey(word)) { // if we havent seen this word before
            		int frequency = frequency(word, words); // find frequency
            		double termFrequency = (frequency * 2.2) / (frequency) + (1.2 * (0.25+ (0.75*(words.length/songWordAvg)))); // use frequency and AvgS to calculate TF
            		tempMap.put(word, termFrequency); //put the word and its number in the map
            	}
            }
            
            // After Calculaion
            result.put(songTitle, tempMap); //put sub-maps in the main map.
        }
        
        return result;
    } 
    
    //will calculate the amount of times a certain string appears in an array of strings - F(X,S)
    public int frequency(String a, String[] words) {
    	int sum = 0;
    	for(String s: words) {
    		if(s.equals(a));
    			sum+=1;
    	}
    	return sum;
    }

}

