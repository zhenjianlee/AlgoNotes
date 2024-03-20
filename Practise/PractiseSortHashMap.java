package Practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class PractiseSortHashMap {

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("David", 95);
        scores.put("Jane", 80);
        scores.put("Mary", 97);
        scores.put("Lisa", 78);
        scores.put("Dino", 65);
        System.out.println("Digital Ocean result =" + sortByValueDigitalOcean(scores));
        ;
        System.out.println("Jian result = " + sortByValueJian(scores));
        ;

    }

    private static Map<String, Integer> sortByValueJian(Map<String, Integer> map) {

        Set<Entry<String, Integer>> set = map.entrySet(); // See Note A Below:
        ArrayList<Entry<String, Integer>> list = new ArrayList<>(set);
        mergeSort(list);
        // System.out.println("List =" +list);
        Map<String, Integer> sortedmap = new LinkedHashMap<>();
        for (Entry<String, Integer> e : list) {
            sortedmap.put(e.getKey(), e.getValue());
        }

        return sortedmap;
    }

    private static void mergeSort(ArrayList<Entry<String, Integer>> al) {

        if (al.size() < 2)
            return;

        int mid = al.size() / 2;
        ArrayList<Map.Entry<String, Integer>> left = new ArrayList<>();
        ArrayList<Map.Entry<String, Integer>> right = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            left.add(al.get(i));
        }

        for (int j = mid; j < al.size(); j++) {
            right.add(al.get(j));
        }

        mergeSort(left);
        mergeSort(right);
        merge(al, left, right);

    }

    private static void merge(ArrayList<Entry<String, Integer>> al, ArrayList<Entry<String, Integer>> l,
            ArrayList<Entry<String, Integer>> r) {

        int i = 0, j = 0, k = 0;
        while (i < l.size() && j < r.size()) {
            if (l.get(i).getValue() <= r.get(j).getValue()) {
                al.set(k, l.get(i));
                k++;
                i++;
            } else {
                al.set(k, r.get(j));
                k++;
                j++;
            }
        }

        while (i < l.size()) {
            al.set(k, l.get(i));
            k++;
            i++;
        }

        while (j < r.size()) {
            al.set(k, r.get(j));
            k++;
            j++;
        }
    }

    private static Map<String, Integer> sortByValueDigitalOcean(Map<String, Integer> scores) {
        Map<String, Integer> sortedByValue = new LinkedHashMap<>();

        // get the entry set
        Set<Entry<String, Integer>> entrySet = scores.entrySet();
        // System.out.println(entrySet);

        // create a list since the set is unordered
        List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
        // System.out.println(entryList);

        // sort the list by value
        entryList.sort((x, y) -> x.getValue().compareTo(y.getValue()));
        // System.out.println(entryList);

        // populate the new hash map
        for (Entry<String, Integer> e : entryList)
            sortedByValue.put(e.getKey(), e.getValue());

        return sortedByValue;
    }

}

/*
 * Note A:
 * 
 * Please explain more about this data type Set<Entry<String,Integer>> set =
 * map.entrySet();
 * Why set works but this doesnt work Map.Entry<String,Integer> mapEntry =
 * map.entrySet();
 * 
 * 
 * In Java, Map.entrySet() returns a Set view of the mappings contained in this
 * map. The Set is a collection that contains unique elements. Each element in
 * the set is a Map.Entry object, which represents a key-value pair in the map.
 * 
 * Let's break down the statement Set<Entry<String,Integer>> set =
 * map.entrySet();:
 * 
 * map.entrySet() returns a Set of Map.Entry objects.
 * Set<Entry<String,Integer>> declares a set containing entries where the key is
 * of type String and the value is of type Integer.
 * set is assigned the reference to this set containing the key-value pairs of
 * the map.
 * Now, let's analyze why Map.Entry<String,Integer> mapEntry = map.entrySet();
 * doesn't work:
 * 
 * map.entrySet() returns a Set of Map.Entry objects, not a single Map.Entry.
 * Map.Entry<String,Integer> declares a single entry where the key is of type
 * String and the value is of type Integer.
 * You cannot assign a Set of entries to a single entry variable. This is why
 * the statement Map.Entry<String,Integer> mapEntry = map.entrySet(); would
 * result in a compilation error.
 * To retrieve a single Map.Entry, you typically need to iterate over the set of
 * entries and extract the specific entry you're interested in. For example:
 * 
 * Map<String, Integer> map = new HashMap<>();
 * // Add some key-value pairs to the map
 * 
 * // Iterate over the set of entries
 * for (Map.Entry<String, Integer> entry : map.entrySet()) {
 * // Do something with each entry
 * }
 * 
 * 
 * In this loop, entry represents each individual Map.Entry object within the
 * set obtained from map.entrySet().
 * 
 * 
 * 
 * Note B
 * 
 * will this work for (Entry<String, Integer> entry : map.entrySet()) {
 * // Do something with each entry
 * } why doesnt this have Map.Entry Set<Entry<String, Integer>> set =
 * map.entrySet();
 * ChatGPT
 * Yes, the statement for (Map.Entry<String, Integer> entry : map.entrySet())
 * will work perfectly fine. This is because map.entrySet() returns a Set of
 * Map.Entry objects, and the enhanced for loop in Java can iterate over any
 * collection that implements the Iterable interface, which includes Set.
 * Therefore, in each iteration, entry will represent a single Map.Entry object
 * from the set.
 * 
 * Regarding your second question about why you don't explicitly declare the
 * type of Map.Entry when using map.entrySet(), the reason is that Java has type
 * inference. When you use the enhanced for loop, the compiler infers the type
 * of the elements in the collection you are iterating over. In this case, since
 * map.entrySet() returns a Set<Map.Entry<String, Integer>>, the compiler
 * automatically knows that entry should be of type Map.Entry<String, Integer>.
 * 
 * So, you don't need to explicitly mention Map.Entry when using the enhanced
 * for loop; the compiler handles the type inference for you. This is a feature
 * introduced in Java 5 to simplify the syntax and make code more readable.
 * 
 */