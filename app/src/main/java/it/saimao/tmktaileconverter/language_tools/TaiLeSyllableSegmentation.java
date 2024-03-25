package it.saimao.tmktaileconverter.language_tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaiLeSyllableSegmentation {

    public static String consonants = "\u1950-\u1962";
    public static final String enChar = "a-zA-Z0-9";
    // "!-/:-@[-`{-~\s"
    public static final String otherChar = "\u1040-\u1049\u104a\u104b!-/:-@\\[-`\\{-~\\s";
    public static final String endWordChar = "\u1970-\u1974";

    public static final String BREAK_PATTERN = "([" + consonants + "](?![" +endWordChar + "])|[" + enChar + otherChar + "])";
    public static synchronized String[] segment(String text) {
        if (text == null) {
            throw new NullPointerException();
        }
        return text.replaceAll(BREAK_PATTERN, "\uD835\uDD4A$1").split("\uD835\uDD4A");
    }

    public static synchronized String segmentAsStringWithDelimiter(String text, String delimiter)  {
        String[] outputs = segment(text);
        String segmentString = Arrays.stream(outputs)
                .map(s -> s.concat(delimiter))
                .collect(Collectors.joining())
                // In Tai Le, There's no single consonant standing
                .replaceAll("(" + delimiter + ")([" + consonants + "])(" + delimiter + ")", "$2$3")
                .replaceAll("(" + delimiter + ")+", "$1");
        return segmentString.trim();
    }

    public static String segmentAsString(String input) {
        return segmentAsStringWithDelimiter(input, " ");
    }
}
