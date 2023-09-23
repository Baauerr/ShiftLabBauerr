package com.example.shiftjija2.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ArrayConverter {
    public static ArrayList<ArrayList<String>> convertIntArrayToStringArray(ArrayList<ArrayList<Integer>> intArray) {
        ArrayList<ArrayList<String>> stringArray = new ArrayList<>();

        for (ArrayList<Integer> innerList : intArray) {
            ArrayList<String> stringInnerList = new ArrayList<>();
            for (Integer value : innerList) {
                stringInnerList.add(value.toString());
            }
            stringArray.add(stringInnerList);
        }
        return stringArray;
    }
}
