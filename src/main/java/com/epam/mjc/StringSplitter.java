package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> results = new ArrayList<>();
        results.add(source);
        for (String currDelimiter : delimiters) {
            List<String> currList = new ArrayList<>();
            for (String result : results) {
                String[] newListStrings = result.split(currDelimiter);
                for (String newListString : newListStrings) {
                    if (newListString.isEmpty()) {

                    } else {
                        currList.add(newListString);
                    }
                }
            }
            results = currList;
        }
        return results;
    }
}

