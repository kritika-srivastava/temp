// Create a list of fruits with their properties (name, color, pricePerKg)
// and convert it into a format so that for a given fruit name
// retrieval of its color and pricePerKg value is fast


// Write your code here
const fruit = [{ name: 'apple', color: 'red', price: 80 },
{ name: 'mango', color: 'yellow', price: 100 },
{ name: 'orange', color: 'orange', price: 85 },
{ name: 'guava', color: 'green', price: 70 },
{ name: 'banana', color: 'yellow', price: 60 }
];

const objectCreation = (arr, key) => {
    const obj = {};
    arr.forEach((elem) => {
        obj[elem[key]] = elem;
    });

    //  console.log(obj);
    return obj;
};
const objectOfFruit = objectCreation(fruit, 'name');
/* eslint-disable */
console.log(objectOfFruit.guava);
/* eslint-enable */
