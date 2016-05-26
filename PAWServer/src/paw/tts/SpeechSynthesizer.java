package paw.tts;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

/**
 * Created by Tom Dobbelaere on 26/05/2016.
 */
public class SpeechSynthesizer
{
    private SpeechBank speechBank;
    private PhonemeBank phonemeBank;

    public SpeechSynthesizer(SpeechBank speechBank, PhonemeBank phonemeBank)
    {
        this.speechBank = speechBank;
        this.phonemeBank = phonemeBank;
    }

    public void speak(String sentence)
    {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++)
        {
            speakWord(words[i]);
            try
            {
                Thread.sleep(35);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void speakWord(String word)
    {
        if (phonemeBank.getWord(word) != null)
        {
            speakPhonemes(phonemeBank.getWord(word));
        }
    }

    public void speakPhonemes(String[] phonemes)
    {
        int length = 0;

        for (int i = 0; i < phonemes.length; i++)
        {
            byte[] data = speechBank.getSpeechData().get(phonemes[i]);

            length += data.length;
        }

        byte[] soundClip = new byte[length];

        int pos = 0;
        int phonemeNumber = 0;

        while (phonemeNumber != phonemes.length)
        {
            byte[] data = speechBank.getSpeechData().get(phonemes[phonemeNumber]);
            System.arraycopy(data, 0, soundClip, pos, data.length);

            pos += data.length;

            phonemeNumber++;
        }

        try
        {
            playback(soundClip);
        }
        catch (LineUnavailableException e)
        {
            e.printStackTrace();
        }
    }

    private void playback(byte[] samples) throws LineUnavailableException
    {
        AudioFormat playbackFormat = new AudioFormat(44100.0f, 16, 2, false, false);

        Clip clip = AudioSystem.getClip();

        clip.open(playbackFormat, samples, 0, samples.length);
        clip.start();

        while(clip.getFramePosition() != clip.getFrameLength())
        {
        }
    }
}
