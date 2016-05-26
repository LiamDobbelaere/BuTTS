package paw.tts;

import java.util.HashMap;

/**
 * Created by Tom Dobbelaere on 26/05/2016.
 */
public class PhonemeBank
{
    private HashMap<String, String[]> phonemes;

    public PhonemeBank()
    {
        this.phonemes = new HashMap<>();
    }

    public void addWord(String word, String[] phonetics)
    {
        phonemes.put(word, phonetics);
    }

    public String[] getWord(String word)
    {
        return phonemes.get(word.toUpperCase());
    }

    public int size()
    {
        return phonemes.size();
    }
}
