/**
 * Stack representation
 */
function stack() {
    this._size = 0;
    this._storage = {};
}

/**
 * 
 * @param {number} data The element to be insert 
 */
stack.prototype.push = function (data) {
    this._storage[++this._size] = data;
};

stack.prototype.pop = function () {
    var size = this._size,
        deletedData;

    if (size) {
        deletedData = this._storage[size];

        delete this._storage[size];
        this._size--;
        return deletedData;
    }
};