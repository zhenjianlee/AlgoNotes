# 49-Group Anagrams

Convert string to charArray then sort it to keep it as hashmap key. if key is the same (it consist of the same letters), group the words together.

## The question

Medium
Topics
Companies
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

## My Code 2nd Attempt- 6ms ,96.64%

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>>res = new ArrayList<>();

        for (int i=0; i<strs.length;i++){
            String value = strs[i];
            char[] toSort = value.toCharArray();
            Arrays.sort(toSort);
            String key = new String(toSort);
            //System.out.println("key="+key+" value="+value);

            if (!map.containsKey(key)){
                List<String> newList = new ArrayList<>();
                newList.add(value);
                map.put(key, newList);
            }else{
                List<String> getList = map.get(key);
                getList.add(value);
            }
        }

         for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

}


```

## My Code 1st Attempt - 19ms , 16.2%


```java


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>>res = new ArrayList<>();

        for (int i=0; i<strs.length;i++){
            String value = strs[i];
            char[] toSort = value.toCharArray();
            Arrays.sort(toSort);
            String key = tostring(toSort); //-----> DONT NEED TO DO THIS. USE STRING CONSTRUCTOR TO INSERT CHAR ARRAY IN!!! +13MS
            //System.out.println("key="+key+" value="+value);

            if (!map.containsKey(key)){
                List<String> newList = new ArrayList<>();
                newList.add(value);
                map.put(key, newList);
            }else{
                List<String> getList = map.get(key);
                getList.add(value);
            }

        }

         for(Map.Entry<String,List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

    private static String tostring(char[] chars){
        String res = "";
        for (char ch : chars){
            res+=ch;
        }
        return res;
    }
}


```