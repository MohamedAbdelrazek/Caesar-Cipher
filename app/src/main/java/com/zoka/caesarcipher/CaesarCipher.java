package com.zoka.caesarcipher;

import android.util.Log;

/**
 * Created by Mohamed AbdelraZek on 3/10/2017.
 */

public class CaesarCipher {
    // Rotate a character k-positions
    public static char cipher(char c, int k) {
        // declare some helping constants
        final int alphaLength = 26;
        final char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
        final int cipherShift = k % alphaLength;

        // shift down to 0..25 for a..z
        char shifted = (char) (c - asciiShift);
        // rotate the letter and handle "wrap-around" for negatives and value >= 26
        shifted = (char) ((shifted + cipherShift + alphaLength) % alphaLength);
        // shift back up to english characters
        Log.i("ZOKA","(char) (shifted + asciiShift)"+(char) (shifted + asciiShift));
        return (char) (shifted + asciiShift);
    }

    // Rotate a string k-positions
    public static String cipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(cipher(s.charAt(i), k));
        }
        Log.i("ZOKA","sb = "+sb.toString());
        return sb.toString();
    }
}
