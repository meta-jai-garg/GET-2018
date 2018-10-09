/**
 * function to remove consecutive repeating string.
 * 
 * @param {String} _inputString The input string
 */

function removeConsicutiveChar(_inputString) {
    var resultString = [], array = _inputString.split(''), i = 0;
    while (i < array.length) {
        if (resultString.length > 0 && array[i] == resultString[resultString.length - 1]) {
            i++;
            while (i < array.length && array[i] == resultString[resultString.length - 1]) {
                i++;
            }
            resultString.pop();
        } else {
            resultString.push(array[i]);
            i++;
        }
    }
    return resultString.join('');
}