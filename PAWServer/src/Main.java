import paw.tts.PhonemeFileReader;
import paw.tts.SpeechBank;
import paw.tts.SpeechSynthesizer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Tom Dobbelaere on 26/05/2016.
 */
public class Main
{
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException, URISyntaxException, InterruptedException
    {
        /*Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("C:\\test\\a.wav"));

        byte[] ayy = new byte[inputStream.available() * 2];
        int n = inputStream.read(ayy);
        inputStream = AudioSystem.getAudioInputStream(new File("C:\\test\\b.wav"));
        inputStream.read(ayy, n, inputStream.available());

        clip.open(inputStream.getFormat(), ayy, 0, ayy.length);
        clip.start();

        while(clip.getFramePosition() != clip.getFrameLength())
        {
        }

        System.out.println(inputStream.getFormat().getSampleRate());
        System.out.println(inputStream.getFormat().getSampleSizeInBits());
        System.out.println(inputStream.getFormat().getChannels());
        System.out.println(inputStream.getFormat().isBigEndian());
        System.out.println(inputStream.getFormat().properties());*/


        PhonemeFileReader reader = new PhonemeFileReader("/cmudict-test.dict");
        SpeechBank speechBank = new SpeechBank("digaly");
        SpeechSynthesizer synthesizer = new SpeechSynthesizer(speechBank, reader.getPhonemeBank());

        synthesizer.speak("well behold");
        Thread.sleep(500);
        synthesizer.speak("this is my artificial voice");
        Thread.sleep(500);
        synthesizer.speak("you probably cannot understand it well");
        Thread.sleep(500);
        synthesizer.speak("y d t i love you");
        Thread.sleep(500);
        synthesizer.speak("it sounds so bad holy shit");
        Thread.sleep(500);
        synthesizer.speak("but i kind of like it at the same time");
        Thread.sleep(500);
        synthesizer.speak("because it is my voice and it is my synthesizer written from scratch");
        Thread.sleep(500);
        synthesizer.speak("thank you for listening");
        Thread.sleep(500);
        synthesizer.speak("digaly out");

        //synthesizer.speakWord("great");
    }
}
