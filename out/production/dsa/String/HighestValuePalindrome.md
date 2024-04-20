# Highest Value Palindrome

Medium - but it is extremely challenging. There are too many conditions and coding if-else block will be a nightmare.

Fortunately in the discussion there is a fantastic code.

https://www.hackerrank.com/challenges/richie-rich/problem?isFullScreen=true

## My code based on Reference below

The logic of reference code is correct. However:

1. There seems to be syntax mistake. How can you use s[i] or s[j] or a String? So i used toCharArray();

2. I don't understand the code below for the 'fix to 9' part. So I read his instructions and coded to my own understanding for the second part.

3. The logic for reference code is fantastic.

```java
public static String highestValuePalindrome(String s, int n, int k) {
    // Write your code here
        System.out.println(String.format("S=%s , n=%s , k=%s",s,n,k));
        char[] sa = s.toCharArray();
        char[] visited=s.toCharArray();
        
        int i=0,j=s.length()-1,count =k;
        
        while (i<j){
            char left = sa[i];
            char right= sa[j];
            
            if(left!=right){
                if (left-'0'<right-'0'){
                    sa[i]=sa[j];
                    visited[i]='x';
                    count--;
                    //System.out.println(String.format("left=%s LOWER right=%s count=%s",left,right,count));
                }else if (left-'0'>right-'0'){
                    sa[j]=sa[i];
                    visited[j]='x';
                    count --;
                    //System.out.println(String.format("left=%s HIGHER right=%s count=%s",left,right,count));
                }
            }
                i++;
                j--;
        }
        //System.out.println(String.format("Fixed palindrome, s=%s, count=%s",new String(sa),count));
        if (count<0)return "-1";
        else if(count ==0)return new String(sa);
        i=0;
        j=s.length()-1;
            
            while (count>0 && i < j){
                 char left = sa[i];
                 char right= sa[j];
                if (left != '9' || right !='9'){
                    if (visited[i] != 'x' && visited[j]!='x'&& count>2){
                        sa[i]='9';
                        sa[j]='9';
                        count-=2;
                    }else if (visited[i]=='x' || visited[j]== 'x' || count>1){
                        sa[i]='9';
                        sa[j]='9';
                        count--;
                    }
                }
                i++;
                j--;
            }
        if (n%2 != 0 && count>=1)sa[n/2]='9';
        return new String(sa);
    }

}

```


## Reference - Mystic01

Just like everyone here in the discussion section, my first idea for solving this question was to count the no. of differences in the left and right portion of the string and change characters to '9' in pairs in accordance with whether one of the character is already '9' and whether changing a character makes the no. of our available changes less than the no. of current differences. But as soon as I started writing the pseudo-code for the same, I realised that this approach is gonna be a nightmare in terms of the numbes of if - else statements that would be required to make this work for all possible test cases. So, with the intent to reudce th code complexity, did a whole day of brainstorming but the final solution was smaller than even half of the incomplete pseudo code with the previous approach. So, here comes the clean and efficient approach:-

1. First, utilising the two pointer algorithm, instead of just checking the no. of differences between the left and right sub-strings in the first loop, whenever a difference occurs we make the smaller no. equal to the larger one.

2. Plus, we increment the value of a variable, say 'count', which holds the no. of changes we have made so far.

3. Also, simuntaneously, when a character is changed (and this is the crust of this approach) we mark the character as visited in a different data structure which will come in handy later on.

4. Now when first loop ends, we have successfully converted the string into a palindrome, the next bit is just to make it largest in accordance with the given value of 'k'.

5. If our 'count' excedes 'k', then it is not possible to convert the string into a palindrome with 'k' or lesser no. of changes, hence we return "-1".

6. Else if 'count' is found to be equal to 'k', then we return "s" - our palindromic string.

7. Else if count is less than 'k', then we need to utilize the z = (k - count) no. of changes to make our string the largest possible palindrome.

8. To do that, we again loop through the characters using two pointers(say, i = 0, j = length-1), but this time we loop until z > 0 and i < j.

9. Now, for every iteration if we have visited either s[i] or s[j], then we change both of them to '9' and reduce z by 1.

10. Else if we have not visited either s[i] or s[j], then if z >= 2, we change both the characters to '9' and reduce z by 2.

11. Else we continue until either z becomes zero or i becomes greater than or equal to j.

12. Lastly, if z is still greater than 0 and size of our string is odd, then we put the middle character, which would be s[size/2], equal to '9'.


```java

string highestValuePalindrome(string s, int n, int k){

    int i = 0, j = n - 1, count = 0;
    string visited = s;
    while (i < j) {
        if (s[i] < s[j]) {
            s[i] = s[j];
            visited[i] = 'x';
            count++;
        } else if (s[i] > s[j]) {
            s[j] = s[i];
            visited[j] = 'x';
            count++;
        }
        i++;
        j--;
    }
    int z = k - count;
    if (z <= 0) return z < 0 ? "-1" : s;
    
    i = 0; j = n - 1;
    while (z > 0 && i < j) {
        if (s[i] != '9') {
          if (visited[i] == 'x' || visited[j] == 'x' || z > 1) {
            s[i] = '9';
            s[j] = '9';
            z -= (visited[i] == 'x' || visited[j] == 'x') ? 1 : 2;
          }
        }
        i++;
        j--;
    }
    if(z > 0 && n % 2 != 0) s[n/2] = '9';
    return s;
}

```