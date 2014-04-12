package org.euler.util;

import org.junit.Test;

import static org.euler.util.Alphabet.wordSum;
import static org.fest.assertions.api.Assertions.assertThat;

public class AlphabetTest {
    @Test
    public void testWordSum() throws Exception {

        assertThat(wordSum("abc")).isEqualTo(1+2+3);
        assertThat(wordSum("egg")).isEqualTo(5+7+7);
        assertThat(wordSum("COLIN")).isEqualTo(53);
        assertThat(wordSum("COLIN -")).isEqualTo(53);

    }
}
