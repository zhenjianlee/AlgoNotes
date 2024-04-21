# Encryption

Encrypt a string by putting it into 2d array ,rows and columns. Then create another string.

## The Question

https://www.hackerrank.com/challenges/encryption/problem?isFullScreen=true

Example

After removing spaces, the string is  characters long.  is between  and , so it is written in the form of a grid with 7 rows and 8 columns.
```dtd

ifmanwas  
meanttos          
tayonthe  
groundgo  
dwouldha  
vegivenu  
sroots

```

Ensure that
If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. .
The encoded message is obtained by displaying the characters of each column, with a space between column texts. The encoded message for the grid above is:

```imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau```
Create a function to encode a message.

Function Description

Complete the encryption function in the editor below.

encryption has the following parameter(s):

string s: a string to encrypt
Returns

string: the encrypted string
Input Format

One line of text, the string

Constraints


contains characters in the range ascii[a-z] and space, ascii(32).

Sample Input

```haveaniceday```
Sample Output 0

hae and via ecy
Explanation 0

,  is between  and .
Rewritten with  rows and  columns:
```dtd
have
anic
eday
```

Sample Input 1

```feedthedog```    
Sample Output 1

```fto ehg ee dd```

Explanation 1

,  is between  and .
Rewritten with  rows and  columns:

## My Code - Naive solution

```java
public static String encryption(String s) {
    // Write your code here
        s = s.replaceAll(" ","");
        int len = s.length();
        int rows = (int) Math.floor(Math.sqrt(len));
        int columns = (int) Math.ceil(Math.sqrt(len));
        if (rows*columns <len)rows++;
        //System.out.println(String.format("len=%s , rows=%s, cols=%s",len,rows,columns));
        List<String> list = new ArrayList<>();
        /*
            have 
            anic 
            eday
            
            hae and via ecy => correct (3 rows ,4 cols)
            heid aaca vney => wrong    (4 rows, 3 cols)
        */
        for (int i=0 ; i<len ; i+=columns){
            try{
                String cur = s.substring(i,i+columns);
                list.add(cur);
            }catch (Exception e){
                String cur = s.substring(i, s.length());
                list.add(cur);
            }
        }
        
        for(String str: list){
            System.out.println(str);
        }
        
        String res="";
        for (int i= 0; i<columns; i++){
            for (int j=0 ; j<rows; j++){
                try{
                    char ch= list.get(j).charAt(i);
                    res+=ch;
                }catch(Exception e){
                    break;
                }
                
            }
            res+=" ";
        }
        
        return res;
    }


```