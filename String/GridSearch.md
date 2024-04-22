# The Grid Search

Medium - Find the pattern . Manipulate the substring within the arraylist to find a match with pattern.

Basically search if arraylist pattern is contained within Grid arraylist.

Very difficult for me!

https://www.hackerrank.com/challenges/the-grid-search/problem?isFullScreen=true

## My Code after studying reference below

```java
public static String gridSearch(List<String> G, List<String> P) {
    // Write your code here
        
        for (int i=0; i<G.size(); i++){
            String gridRow = G.get(i);
            int idx = gridRow.indexOf(P.get(0));
            while (idx!= -1){
                int count=1;
                int startCol = idx;
                int endCol = idx + P.get(0).length();
                for (int nextRow = i+1 , pointer=1; nextRow<G.size() && pointer < P.size(); nextRow++,pointer++ ){
                    String toCheck=G.get(nextRow).substring(startCol,endCol);
                    String pattern= P.get(pointer);
                    //System.out.println(String.format("A toCheck=%s, pattern=%s, row=%s, count=%s",toCheck,pattern, nextRow,count));
                    if (toCheck.equals(pattern)){
                        count++;
                        //System.out.println(String.format("B toCheck=%s, pattern=%s, row=%s, count=%s",toCheck,pattern, nextRow,count));
                        if (count == P.size( ))return "YES";
                    }else{
                        break;
                    }
                }            
                idx=gridRow.indexOf(P.get(0),startCol+1);
            }           
        }
        return "NO";
    }
```

## Reference Code

```java

public static String gridSearch(List<String> G, List<String> P) {
    int counter = 1;
        
    for (int i = 0; i < G.size(); i++) {
        String row = G.get(i);
            
        // Finding the occurence of the first pattern row       
        int startCol = row.indexOf(P.get(0));
        int endCol = startCol + P.get(0).length() - 1;
                
        // Finding all occurence of pattern in the same row
        while (startCol != -1) {
            counter = 1;
                    
            // Looping over the next pattern rows & next grid rows
            // j== pattern rows , k= next grid row
            for (int j = 1, k = i + 1; j < P.size() && k < G.size(); j++, k++) {           
                if (G.get(k).substring(startCol, endCol + 1).equals(P.get(j))) {                        
                    if (++counter == P.size()) {
                        return "YES";        
                    }
                } else {
                    break;
                }
            }
                   
            // Updating
            startCol = row.indexOf(P.get(0), startCol + 1);
            endCol = startCol + P.get(0).length() - 1;
        }
    }
    return "NO";
}


```

## My First Failed Attempt

This algorithm issues the first instance found is the correct sequence. Therefore it cannot pass all test cases.

```java

public static String gridSearch(List<String> G, List<String> P) {
    // Write your code here
        
        int pointer = 0;
        int [] res = new int[P.size()];
        
        int patternCol=0;
        int patternRow=0;
        boolean notFound=true; 
    
        for(int i=0; i<G.size(); i++){
            String str= G.get(i);
            String check =P.get(pointer);
            int idx = str.indexOf(check);
            if (notFound && idx ==-1){
                continue;
            }
            else if (notFound && idx != -1){
                res[pointer]=1;
                patternCol=idx;
                patternRow=i;
                notFound=false;
                pointer++;
                System.out.println(String.format("a Str=%s, Check=%s, idx=%s, pointer=%s",
                    str,check,idx, pointer));
            }else if (!notFound && idx == patternCol && i == patternRow+1){
                res[pointer]=1;
                patternCol=idx;
                patternRow=i;
                if (pointer==P.size()-1)break;
                pointer++;
                 System.out.println(String.format("b Str=%s, Check=%s, idx=%s, pointer=%s",
                    str,check,idx, pointer));
            } else if (!notFound && idx != patternCol || !notFound && i != patternRow+1){
                System.out.println(String.format("c Str=%s, Check=%s, idx=%s, pointer=%s",
                    str,check,idx, pointer));
                return "NO";
            }
        }
        
        boolean found = Arrays.stream(res)
            .allMatch(s-> s ==1);
            
        if (found){
            return "YES";
        }
        
        return "NO";

    }


```