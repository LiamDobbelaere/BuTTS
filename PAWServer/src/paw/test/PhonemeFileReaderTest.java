package paw.test;

import org.junit.Before;
import org.junit.Test;
import paw.tts.PhonemeBank;
import paw.tts.PhonemeFileReader;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Digaly on 26/05/2016.
 */
public class PhonemeFileReaderTest
{
    private PhonemeFileReader fileReader;

    @Before
    public void setUp() throws Exception
    {
        String location = "/cmudict-test.dict";

        fileReader = new PhonemeFileReader(location);
    }

    @Test
    public void readNext() throws Exception
    {
        PhonemeBank bank = fileReader.getPhonemeBank();

        assert(Arrays.equals(bank.getWord("ABORT"), new String[] {"AH0", "B" ,"AO1", "R", "T"}));
    }
}