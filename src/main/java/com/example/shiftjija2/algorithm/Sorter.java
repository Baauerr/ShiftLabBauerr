package com.example.shiftjija2.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sorter {
    public static ArrayList<ArrayList<String>> sortByFirstElements(ArrayList<ArrayList<String>> arrayList) {
        ArrayList<String>[] array = arrayList.toArray(new ArrayList[0]);

        Arrays.sort(array, Comparator.comparingInt(a -> Integer.parseInt(a.get(0))));

        ArrayList<ArrayList<String>> sortedArrayList = new ArrayList<>(Arrays.asList(array));

        return sortedArrayList;
    }
}
