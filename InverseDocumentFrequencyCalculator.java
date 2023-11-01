package Lab6;


import java.util.TreeMap;

public class InverseDocumentFrequencyCalculator implements IInverseFreq {

	@Override
    public TreeMap<String, Double> getInverseDocumentFrequency(TreeMap<String, String> songLyrics) {
        TreeMap<String, Double> result = new TreeMap<String, Double> ();
        
        for(String s: songLyrics.keySet()) {
            // current lyrics
            String lyric = songLyrics.get(s);
            String[] words = lyric.split(" ");
            
            // Calculate the Inverse Document Frequency (IDF) Values here
            // You might need to introduce other methods and additional variables
            
            // IDF for term X is calculated as ln of (N-n(X)+0.5)/(n(X)+0.5) plus 
            // where N is total number of songs
            // and n(X) is the number of songs having term X

            for(String w : words) {
            	Double currentIDF = calcIDF(w, songLyrics, words);
            	if(result.get(w)==null)
            		result.put(w, currentIDF);
            	else
            		result.put(w + result.get(result), currentIDF);
            }
        }
        
        return result;
    }
    
    public Double calcIDF(String w, TreeMap<String, String> songLyrics, String[] words) {
    	int N = songLyrics.keySet().size();
    	double nX = 0;
    	for(String word : words) {
    		if (word.equalsIgnoreCase(w))
    			nX = 1;
    	}
    	nX = Math.log((N-nX+.05)/(nX+.05)+1);
    	return nX;
    }

}
