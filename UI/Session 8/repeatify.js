/**
 * method to repeat a string by given number 
 * 
 * @param {number} _number The number for string to be repeated
 */

String.prototype.repeatify = function (_number) {
    var str = '';
    while (_number > 0) {
        str += this;
        _number--;
    }
    return str;
};