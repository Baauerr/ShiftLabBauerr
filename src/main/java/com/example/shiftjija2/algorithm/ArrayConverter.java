package com.example.shiftjija2.algorithm;

import java.util.ArrayList;

public class ArrayConverter {
    public static ArrayList<ArrayList<Integer>> convertToIntegerArrays(ArrayList<ArrayList<?>> intervalData) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<?> subList : intervalData) {
            ArrayList<Integer> intList = new ArrayList<>();
            for (Object element : subList) {
                if (element instanceof Integer) {
                    intList.add((Integer) element);
                } else if (element instanceof String) {
                    try {
                        intList.add(Integer.parseInt((String) element));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Ошибка при преобразовании String в Integer");
                    }
                }
            }
            result.add(intList);
        }
        return result;
    }

    public static ArrayList<ArrayList<String>> convertToStringArrays(ArrayList<ArrayList<?>> intervalData) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (ArrayList<?> subList : intervalData) {
            ArrayList<String> stringList = new ArrayList<>();
            for (Object element : subList) {
                if (element instanceof String) {
                    stringList.add((String) element);
                } else if (element instanceof Integer) {
                    throw new IllegalArgumentException("Ошибка при преобразовании Integer в String");
                }
            }
            result.add(stringList);
        }
        return result;
    }
}
