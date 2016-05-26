import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Tom Dobbelaere on 26/05/2016.
 */
public class Main
{
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException
    {
        Clip clip = AudioSystem.getClip();
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

    }
}
