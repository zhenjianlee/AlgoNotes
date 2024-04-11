# Arrow Function

https://www.hackerrank.com/challenges/js10-arrows/problem?isFullScreen=true

# THe Code

```javascript
/*
 * Modify and return the array so that all even elements are doubled and all odd elements are tripled.
 * 
 * Parameter(s):
 * nums: An array of numbers.
 */
function modifyArray(nums) {
    
    nums = nums.map((n)=>{
        if (n%2==0){
            n*=2;
        }else{
            n*=3;
        }
        return n; //----> Dont forget to return N!
    })
    
    return nums;
}

```