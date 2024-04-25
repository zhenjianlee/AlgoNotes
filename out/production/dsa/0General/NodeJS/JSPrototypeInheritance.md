# JavaScript Node.Js - Prototype Inheritance

Prototype inheritance is not the same as class inheritance. Prototype inheritance is a function type. That is why it is declared as a function, not a class. Cannot use extends. Need to call the function and add .prototype.

See the hackerrank tutorial below.

Came accross this while doing HackerRank TikTok Technical Assesment for Internship

Tutorial here :- https://www.hackerrank.com/challenges/js10-inheritance/topics

## Theory

https://www.digitalocean.com/community/tutorials/understanding-prototypes-and-inheritance-in-javascript

## Correct code

```javascript
'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding("ascii");
let inputString = "";
let currentLine = 0;

process.stdin.on("data", function (chunk) {
    inputString += chunk;
});
process.stdin.on("end", function () {
    inputString = inputString.split('\n');
    main();
});

function readLine() {
  return inputString[currentLine++];
}
//THE REST IS DRIVER CODE
// ------------------------------------------------------------- ASSESMENT START
function Activity(amount) {
    this.amount = amount;
    
}

Activity.prototype.setAmount=function(value){
    if (value<=0)return false;
    else{
        this.amount=value;
        return true;
    }
}

Activity.prototype.getAmount=function(){
    return this.amount;
}

function Payment(amount, receiver) {
    Activity.call(this,amount);
    this.receiver=receiver;
}

Object.setPrototypeOf(Payment.prototype,Activity.prototype);

Payment.prototype.setReceiver= function(receiver){
    this.receiver=receiver;
}

Payment.prototype.getReceiver= function(){
    return this.receiver;
}

function Refund(amount, sender) {
    Activity.call(this,amount);
    this.sender=sender;

}

Object.setPrototypeOf(Refund.prototype,Activity.prototype);

Refund.prototype.setSender=function(sender){
    this.sender=sender;
}

Refund.prototype.getSender=function(){
    return this.sender;
}


// ------------------------------------------------------------- ASSESMENT END
//THE REST IS DRIVER CODE
function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
    
    const objectType = readLine().trim();
    
    const inputsForObjectCreation = readLine().trim().split(' ');
    const updatedAmount = parseInt(readLine().trim());
    const updatedSenderReceiver = readLine().trim();
    switch(objectType) {
        case 'Payment':
            const paymentObj = new Payment(parseInt(inputsForObjectCreation[0]), inputsForObjectCreation[1]);
            ws.write(`Payment object created with amount ${paymentObj.getAmount()} and receiver ${paymentObj.getReceiver()}\n`);
            if(paymentObj.setAmount(updatedAmount)) {
                ws.write(`Amount updated to ${updatedAmount}\n`);
            } else {
                ws.write(`Amount not updated\n`);
            }
            paymentObj.setReceiver(updatedSenderReceiver);
            ws.write(`Receiver updated to ${updatedSenderReceiver}\n`);
            ws.write(`Payment object details - amount is ${paymentObj.getAmount()} and receiver is ${paymentObj.getReceiver()}\n`);
            ws.write(`Payment.prototype has property setAmount: ${Payment.prototype.hasOwnProperty('setAmount')}\n`);
            ws.write(`Payment.prototype has property getAmount: ${Payment.prototype.hasOwnProperty('getAmount')}\n`);
            ws.write(`Payment.prototype has property setReceiver: ${Payment.prototype.hasOwnProperty('setReceiver')}\n`);
            ws.write(`Payment.prototype has property getReceiver: ${Payment.prototype.hasOwnProperty('getReceiver')}\n`);
            break;
        case 'Refund':
            const refundObj = new Refund(parseInt(inputsForObjectCreation[0]), inputsForObjectCreation[1]);
            ws.write(`Refund object created with amount ${refundObj.getAmount()} and sender ${refundObj.getSender()}\n`);
            if(refundObj.setAmount(updatedAmount)) {
                ws.write(`Amount updated to ${updatedAmount}\n`);
            } else {
                ws.write(`Amount not updated\n`);
            }
            refundObj.setSender(updatedSenderReceiver);
            ws.write(`Sender updated to ${updatedSenderReceiver}\n`);
            ws.write(`Refund object details - amount is ${refundObj.getAmount()} and sender is ${refundObj.getSender()}\n`);
            ws.write(`Refund.prototype has property setAmount: ${Refund.prototype.hasOwnProperty('setAmount')}\n`);
            ws.write(`Refund.prototype has property getAmount: ${Refund.prototype.hasOwnProperty('getAmount')}\n`);
            ws.write(`Refund.prototype has property setSender: ${Refund.prototype.hasOwnProperty('setSender')}\n`);
            ws.write(`Refund.prototype has property getSender: ${Refund.prototype.hasOwnProperty('getSender')}\n`);
            break;
        default:
            break;
    }
}

```

## Professor GPT Explanation

Explanation:

We define the Activity function as the parent class, which includes functionalities related to an activity, such as setting and getting the amount.

We define the Payment function as a child class that inherits from Activity. It includes an additional member variable receiver and functionalities specific to a payment.

We use Object.create(Activity.prototype) to inherit from the Activity prototype.

We define the setReceiver and getReceiver functions on the Payment prototype to manipulate the receiver member variable.

Example usage demonstrates creating an instance of Payment, accessing its inherited functionalities, and using the new functionalities specific to Payment.

```javascript
// Define the Activity function (parent)
function Activity(amount) {
    if (typeof amount !== 'number') {
        throw new Error('Amount must be a number');
    }
    this.amount = amount;
}

Activity.prototype.setAmount = function(amount) {
    if (amount <= 0) {
        return false;
    }
    this.amount = amount;
    return true;
};

Activity.prototype.getAmount = function() {
    return this.amount;
};

// Define the Payment function (child) inheriting from Activity
function Payment(amount, receiver) {
    Activity.call(this, amount); // Call parent constructor
    this.receiver = receiver;
}

// Inherit from Activity
Payment.prototype = Object.create(Activity.prototype);
Payment.prototype.constructor = Payment;

// Additional functions for Payment prototype
Payment.prototype.setReceiver = function(receiver) {
    this.receiver = receiver;
};

Payment.prototype.getReceiver = function() {
    return this.receiver;
};

// Example usage
const myPayment = new Payment(50, 'John Doe');
console.log(myPayment.getAmount()); // Output: 50
console.log(myPayment.getReceiver()); // Output: John Doe

// Set a new receiver
myPayment.setReceiver('Jane Smith');
console.log(myPayment.getReceiver()); // Output: Jane Smith

```