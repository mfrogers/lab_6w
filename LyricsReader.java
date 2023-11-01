package Lab6;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.TreeMap;

public class LyricsReader {

    // TreeMap of Song Name as the key with Lyrics as values
    TreeMap<String, String> songLyricsMap;
    
    /**
     * @param directoryPath the directory where the lyrics are
     * @throws IOException
     */
    public LyricsReader(String directoryPath) throws IOException
    {
        songLyricsMap = new TreeMap<String, String>();
        File path = new File(directoryPath);

        File [] files = path.listFiles();
        // iterating through the file on the source input directory
        for (int i = 0; i < files.length; i++){
            if (files[i].isFile()){ 
                String content = Files.readString(files[i].toPath(), StandardCharsets.UTF_8);
                String songName = files[i].getName().split(".txt")[0];
                songLyricsMap.put(songName, content);
            }
        }
    }
    
    /**
     * @return A treemap with key as the song title and its lyric as the keys
     */
    public TreeMap<String, String> getSongLyricsMap()
    {
        return this.songLyricsMap;
    }
}
