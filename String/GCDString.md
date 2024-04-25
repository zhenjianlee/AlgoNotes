# 1071 -GCD of String

"Easy" https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75


## The Question

To come back and revise.

## Failed Attempt 1

Did not fully understand question

```java
class Solution {

    class Pair{
        public int len;
        public int count;
        public Pair(int len, int count){
            this.len=len;
            this.count=count;
        }

        public String printOut(){
            return String.format("Len=%s , Count=%s",this.len,this.count);
        }
    }

    public String gcdOfStrings(String str1, String str2) {
        Map<String,Pair> map = new HashMap<>();
        int allmaxCount=0;
        int allmaxLen=0;
        
        for(int i=1;i<=str2.length();i++){
            String x = str2.substring(0,i);
            int idx = str1.indexOf(x);
            int count=0;
            while(idx != -1){
                count++;
                idx=str1.indexOf(x,idx+x.length());
            }
            if(count>1){
                map.put(x,new Pair(x.length(),count));
                allmaxLen=Math.max(allmaxLen, x.length());
            };
            allmaxCount=Math.max(allmaxCount,count);
            
        }

        System.out.println(String.format("allmaxCount=%s, allMaxLen=%s",allmaxCount,allmaxLen));

        if (allmaxCount<1)return "";

        printMap(map, "map");

        Map<String,Pair> mapLen = new HashMap<>();
        for (Map.Entry<String,Pair> e : map.entrySet()){
            if (e.getValue().len == allmaxLen){
                mapLen.put(e.getKey(),e.getValue());
            }
        } 
        int curcount=0;
        String res="";
        for(Map.Entry<String,Pair> e : mapLen.entrySet()){
            if(e.getValue().count > curcount){
                curcount=e.getValue().count;
                res= e.getKey();
            }
        }
        printMap(mapLen, "mapLen");
        return res;
    }

    public static void printMap(Map<String,Pair> map, String s){
        for(Map.Entry<String,Pair> e : map.entrySet()){
            System.out.println(s+" "+e.getKey()+" "+ e.getValue().printOut());
        }
    }
}



```