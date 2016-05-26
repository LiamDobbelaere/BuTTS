package paw.tts;

import javax.naming.spi.DirectoryManager;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Created by Digaly on 26/05/2016.
 */
public class SpeechBank
{
    private String bankLocation;
    private HashMap<String, byte[]> speechData;

    public SpeechBank(String voiceBank) throws URISyntaxException
    {
        this.bankLocation ="/voicebanks/" + voiceBank + "/";
        this.speechData = new HashMap<>();

        try
        {
            build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void build() throws IOException, UnsupportedAudioFileException, URISyntaxException
    {
        File bankFolder = new File(getClass().getResource(bankLocation).toURI());
        File files[] = bankFolder.listFiles();

        for (File currentFile : files)
        {
            String phonemeName = currentFile.getName().substring(0, currentFile.getName().lastIndexOf('.'));
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(currentFile);

            byte[] soundData = new byte[inputStream.available()];
            inputStream.read(soundData, 0, soundData.length);

            speechData.put(phonemeName, soundData);
        }
    }

    public HashMap<String, byte[]> getSpeechData()
    {
        return speechData;
    }
}
