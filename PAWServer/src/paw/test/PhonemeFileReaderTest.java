package paw.test;

import org.junit.Before;
import org.junit.Test;
import paw.tts.PhonemeFileReader;
import paw.tts.PhonemeSet;

import java.io.File;

/**
 * Created by Digaly on 26/05/2016.
 */
public class PhonemeFileReaderTest
{
    private PhonemeFileReader fileReader;

    @Before
    public void setUp() throws Exception
    {
        File file = new File(getClass().getResource("/cmudict-test.dict").toURI());

        fileReader = new PhonemeFileReader(file);
    }

    @Test
    public void readNext() throws Exception
    {
        PhonemeSet[] bank = fileReader.getPhonemeBank();

        assert(bank[120].getWord().equals("ABDUCT"));
    }
}