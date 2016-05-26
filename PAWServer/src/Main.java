import paw.tts.PhonemeFileReader;
import paw.tts.SpeechBank;
import paw.tts.SpeechSynthesizer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by Tom Dobbelaere on 26/05/2016.
 */
public class Main
{
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException, URISyntaxException, InterruptedException
    {
        PhonemeFileReader reader = new PhonemeFileReader("/cmudict-test.dict");
        SpeechBank speechBank = new SpeechBank("digaly");
        SpeechSynthesizer synthesizer = new SpeechSynthesizer(speechBank, reader.getPhonemeBank());

        /*synthesizer.speak("well behold");
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
        synthesizer.speak("digaly out");*/

        System.out.print("Enter your sentence: ");
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s1 = sc.next();
            synthesizer.speak(s1);
        }


        //synthesizer.speakWord("great");
    }
}
