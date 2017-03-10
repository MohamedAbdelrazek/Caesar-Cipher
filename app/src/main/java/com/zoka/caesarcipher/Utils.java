package com.zoka.caesarcipher;

import java.util.ArrayList;

/**
 * Created by Mohamed AbdelraZek on 3/10/2017.
 */

public class Utils {
    final private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static ArrayList<Integer> getAlphabetIndex(String alphabet) {
        char[] ch = alphabet.toLowerCase().toCharArray();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (char c : ch) {
            int temp = (int) c;
            int temp_integer = 97; //for lower case
            if (temp <= 122 & temp >= 97) {
                int index = temp - temp_integer;
                integerArrayList.add(index);
            }

        }
        return integerArrayList;


    }

    public static String getAlphabeText(ArrayList<Integer> integerArrayList) {
        String cipherText = "";
        for (Integer i : integerArrayList) {
            cipherText = cipherText + alphabet.charAt(i);
        }
        return cipherText;
    }

    public static ArrayList<Integer> encodeText(ArrayList<Integer> integerArrayList, int shiftAmount) {
        ArrayList<Integer> encodedArrayList = new ArrayList<>();
        for (Integer i : integerArrayList) {
            encodedArrayList.add((i + shiftAmount) % 26);
        }
        return encodedArrayList;
    }

    public static ArrayList<Integer> decodeText(ArrayList<Integer> integerArrayList, int shiftAmount) {

        ArrayList<Integer> encodedArrayList = new ArrayList<>();
        for (Integer c : integerArrayList) {

            encodedArrayList.add((c - shiftAmount + 26) % 26);
        }
        return encodedArrayList;
    }
}

