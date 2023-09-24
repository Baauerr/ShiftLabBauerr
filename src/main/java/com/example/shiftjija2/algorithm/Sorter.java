package com.example.shiftjija2.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {
    public static ArrayList<ArrayList<String>> sortByFirstElements(ArrayList<ArrayList<String>> arrayList) {

        Comparator<ArrayList<String>> comparator = new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> list1, ArrayList<String> list2) {
                if (!list1.isEmpty() && !list2.isEmpty()) {
                    return list1.get(0).compareTo(list2.get(0));
                }
                return 0;
            }
        };

        Collections.sort(arrayList, comparator);

        return arrayList;
    }
}
