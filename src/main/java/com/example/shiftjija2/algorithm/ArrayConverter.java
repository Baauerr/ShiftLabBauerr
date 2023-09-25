package com.example.shiftjija2.algorithm;

import java.util.ArrayList;

public class ArrayConverter {
    public static ArrayList<ArrayList<String>> convertToStringArray(ArrayList<ArrayList<?>> intArray) {
        ArrayList<ArrayList<String>> stringArray = new ArrayList<>();

        for (ArrayList<?> innerList : intArray) {
            ArrayList<String> stringInnerList = new ArrayList<>();
            for (Object value : innerList) {
                stringInnerList.add(value.toString());
            }
            stringArray.add(stringInnerList);
        }
        return stringArray;
    }
}
