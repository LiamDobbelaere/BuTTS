package paw.tts;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Digaly on 26/05/2016.
 */
public class PhonemeFileReader
{
    private BufferedReader reader;
    private PhonemeSet[] phonemeBank;

    public PhonemeFileReader(File file) throws IOException
    {
        reader = new BufferedReader(Files.newBufferedReader(file.toPath()));

        build();
    }

    private PhonemeSet readNext()
    {
        PhonemeSet phonemeSet = null;

        try
        {
            String line = reader.readLine();

            if (line != null)
            {
                int wordEnd = line.indexOf("  ");

                String word = line.substring(0, wordEnd);

                String phonemeLine = line.substring(wordEnd + 2);
                String[] phonemes = phonemeLine.split(" ");

                phonemeSet = new PhonemeSet(word, phonemes);
            }
        }
        catch (IOException e)
        {

        }

        return phonemeSet;
    }

    private void build() {
        PhonemeSet currentSet = readNext();
        ArrayList<PhonemeSet> tempBank = new ArrayList<>();

        while (currentSet != null)
        {
            tempBank.add(currentSet);

            currentSet = readNext();
        }

        phonemeBank = tempBank.toArray(new PhonemeSet[tempBank.size()]);
    }

    public PhonemeSet[] getPhonemeBank()
    {
        return phonemeBank;
    }
}
