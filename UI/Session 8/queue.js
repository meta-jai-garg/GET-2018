/**
 * Queue Representation
 */
function Queue() {
    this._front = 0;
    this._rear = 0;
    this._storage = {};
}

/**
 * function to insert element into queue
 * @param {number} data The element to be insert 
 */
Queue.prototype.enqueue = function (data) {
    this._storage[this._rear] = data;
    this._rear++;
};

/**
 * function to delete an element from queue
 */
Queue.prototype.dequeue = function () {
    var front = this._front,
        rear = this._rear,
        deletedData;

    if (front !== rear) {
        deletedData = this._storage[front];
        delete this._storage[front];
        this._front++;

        return deletedData;
    }
};