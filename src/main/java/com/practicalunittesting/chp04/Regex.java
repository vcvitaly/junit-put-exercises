package com.practicalunittesting.chp04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        Regex r = new Regex();
        System.out.println(
                Arrays.toString( r.parseStringToNumbers("cdefg 345 12bb2344") )
        );
    }

    public Integer[] parseStringToNumbers(String s) {
        List<Integer> allMatches = new ArrayList<>();
        Matcher matcher = Pattern.compile("[0-9]{3,}").matcher(s);

        while (matcher.find()) {
            allMatches.add(Integer.parseInt(matcher.group()));
        }

        Integer[] numbers = new Integer[allMatches.size()];
        allMatches.toArray(numbers);

        return numbers;
    }
}
