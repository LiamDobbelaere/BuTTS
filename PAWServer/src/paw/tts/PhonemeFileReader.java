package paw.tts;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Digaly on 26/05/2016.
 */
public class PhonemeFileReader
{
    private BufferedReader reader;
    private PhonemeBank phonemeBank;

    public PhonemeFileReader(String location) throws IOException, URISyntaxException
    {
        File file = new File(getClass().getResource(location).toURI());

        FileInputStream input = new FileInputStream(file);
        CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
        decoder.onMalformedInput(CodingErrorAction.IGNORE);
        InputStreamReader inputStreamReader = new InputStreamReader(input, decoder);

        reader = new BufferedReader(inputStreamReader);
        phonemeBank = new PhonemeBank();

        build();
    }

    private void build()
    {
        try
        {
            String line = reader.readLine();

            while (line != null)
            {
                int wordEnd = line.indexOf("  ");

                String word = line.substring(0, wordEnd);

                String phonemeLine = line.substring(wordEnd + 2);
                String[] phonemes = phonemeLine.split(" ");

                phonemeBank.addWord(word, phonemes);

                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public PhonemeBank getPhonemeBank()
    {
        return phonemeBank;
    }
}
