/* Write a Program to Flatten a given n-dimensional array */

const flatten = (input) => {
	// Write your code here
	if (!Array.isArray(input)) {
		return null;
	}
	let arr = input;
	let flag = true;
	while (flag) {
		let myNewArray = arr.flat();

		arr = myNewArray;
		//	console.log(arr);
		//	console.log(arr[1][0]);
		if (arr.every(entry => !Array.isArray(entry))) {
			break;
		}
	}
	return arr;
};

/* For example,
INPUT - flatten([1, [2, 3], [[4], [5]])
OUTPUT - [ 1, 2, 3, 4, 5 ]

*/

module.exports = flatten;
