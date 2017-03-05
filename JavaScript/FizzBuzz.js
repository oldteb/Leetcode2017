/**
 * @param {number} n
 * @return {string[]}
 *
 */
 
/**
  * Takeaway:
  * 1. the if clause if VERY expensive (time-wise).
  *
  */

var fizzBuzz = function(n) {
    var list = []

    if(n < 1)
        return list

    let i = 1
    while(i <= n){
        list.push(i.toString())
        i++
    }
    i = 3
    while(i <= n){
        list[i-1] = 'Fizz'
        i = i + 3
    }

    i = 5
    while(i <= n){
        list[i-1] = 'Buzz'
        i = i + 5
    }

    i = 15
    while(i <= n){
        list[i-1] = 'FizzBuzz'
        i = i + 15
    }

    return list

};
