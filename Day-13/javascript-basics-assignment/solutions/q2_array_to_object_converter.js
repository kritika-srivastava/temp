/* Write a Program to convert an array of objects to an object
	based on a given key*/

const convert = (input) => {
	// Write your code here
	if (!Array.isArray(input)) {
		return null;
	}
	const obj = {};
	input.forEach((elem) => {
		obj[`${elem.role}`] = elem;
	});

	//	console.log(obj);
	return obj;
};

/* For example,
INPUT - convert([{id: 1, value: 'abc'}, {id: 2, value: 'xyz'}], 'id')
OUTPUT - {
			'1': {id: 1, value: 'abc'},
			'2': {id: 2, value: 'xyz'}
		 }


*/

module.exports = convert;
