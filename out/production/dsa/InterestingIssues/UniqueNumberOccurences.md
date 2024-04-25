# 1207. Unique Number of Occurrences

Be careful when using Integer objects vs Primitive int

```java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : arr) {
            map1.putIfAbsent(num, 0);
            map1.put(num, map1.get(num) + 1);
        }
        List<Integer> list = new ArrayList<>(map1.values());

        Collections.sort(list);
        if (list.size() == 1)
            return true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                return false;
            }

            // SEE NOTE A
            // ============
            // if(list.get(i) ==list.get(i+1)){
            // return false;
            // }
        }
        return true;
    }
}

/*
 * It is because i am using Integer instead of int in my hash map?
 * 
 * Yes, that's correct! In Java, when you use HashMap<Integer, Integer>, you're
 * storing objects of type Integer as both keys and values. When you retrieve
 * values from the map using map.get(), it returns Integer objects, not
 * primitive int values.
 * 
 * When comparing Integer objects using ==, you're comparing their references,
 * not their actual values. This can lead to unexpected behavior, especially for
 * larger integer values where Java caches Integer objects for values between
 * -128 to 127, but not necessarily for larger values.
 * 
 * Using .equals() ensures that you're comparing the actual values of the
 * Integer objects rather than their references, which is the correct way to
 * compare objects for equality in Java.
 * 
 * So, changing your comparison from == to .equals() addresses this issue and
 * ensures correct behavior when comparing occurrences in your list.
 * 
 * 
 * 
 * 
 * 
 * 
 */


```