package paw.tts;

/**
 * Created by Digaly on 26/05/2016.
 */
public class PhonemeSet
{
    private String word;
    private String[] phonemes;

    public PhonemeSet(String word, String[] phonemes)
    {
        this.word = word;
        this.phonemes = phonemes;
    }

    public String getWord()
    {
        return word;
    }

    public String[] getPhonemes()
    {
        return phonemes;
    }
}
