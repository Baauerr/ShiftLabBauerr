package com.example.shiftjija2.algorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter<T extends Comparable<T>> {
    public ArrayList<ArrayList<T>> sortByFirstElements(ArrayList<ArrayList<T>> arrayList) {

        Comparator<ArrayList<T>> comparator = new Comparator<ArrayList<T>>() {
            @Override
            public int compare(ArrayList<T> list1, ArrayList<T> list2) {
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
