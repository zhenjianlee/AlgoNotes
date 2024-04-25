# JS Classes

https://www.hackerrank.com/challenges/js10-class/problem?isFullScreen=true

## The Question

Objective

In this challenge, we practice using JavaScript classes. Check the attached tutorial for more details.

Task

Create a Polygon class that has the following properties:

A constructor that takes an array of integer values describing the lengths of the polygon's sides.
A perimeter() method that returns the polygon's perimeter.
Locked code in the editor tests the Polygon constructor and the perimeter method.

Note: The perimeter method must be lowercase and spelled correctly.

Input Format

There is no input for this challenge.

Output Format

The perimeter method must return the polygon's perimeter using the side length array passed to the constructor.

Explanation

Consider the following code:

// Create a polygon with side lengths 3, 4, and 5
let triangle = new Polygon([3, 4, 5]);

// Print the perimeter
console.log(triangle.perimeter());
When executed with a properly implemented Polygon class, this code should print the result of .


## The Code

```javascript

class Polygon{
    constructor(array){
        this.array=array;
    }
    
     perimeter(){
        let sum=0;
        for(let i=0; i<this.array.length;i++){
            sum+=this.array[i];
        }
        return sum;
    }
}

```