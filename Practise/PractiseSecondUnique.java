package Practise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PractiseSecondUnique {

    public static void main(String[] args) {

        System.out.println(findSecUnique("Zhen Jian Lee"));
        System.out.println(findSecUnique("sssuuuuccccksssssst"));

    }

    public static Character findSecUnique(String str){
        Map<Character,Integer> count = new LinkedHashMap<>();
        Stream<String> stream= Stream.of(str);
        str.chars().mapToObj(s-> (char) s)
                .forEach(c-> count.put(c, count.getOrDefault(c,0)+1));
        int unique=0;
        for(Map.Entry<Character,Integer> e : count.entrySet()){
            if(e.getValue()==1)unique++;
            if (unique==2){
                return e.getKey();
            }
        }
        return '!';
    }

}
