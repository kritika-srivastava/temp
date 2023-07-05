/* Write a program to build a `Pyramid of stars` of given height
*/
const buildPyramid = (input) => {
     // Write your code here
     let ret = '';

     let n = input;
     let k = 2 * n - 2;
     let i;
     let j;

     for (i = 0; i < n; i = i + 1) {
          let str = '';
          for (j = 0; j < k; j = j + 1) {
               str = str + ' ';
          }
          k = k - 1;
          for (j = 0; j <= i; j = j + 1) {
               str = str + '* ';
          }
          //   console.log(k, str.length);
          str = str.substring(n - 2, str.length - 1);
          ret = ret + str + '  \n';
          //   console.log(str.length);
          //   console.log(str);
          //   str = "";
     }

     return ret;
};

/* For example,
INPUT - buildPyramid(6)
OUTPUT -
     *
    * *
   * * *
  * * * *
 * * * * *
* * * * * *
*/

module.exports = buildPyramid;
