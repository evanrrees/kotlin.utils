package utils


/**
 * Rotate this list right ([n] > 0) or left ([n] < 0) by [n] places.
 *
 * Rotating by -[this]`.size`, `0`, or [this]`.size` will return a copy of the original list
 *
 * @throws IndexOutOfBoundsException if |[n]| is greater than [this.size].
 */
fun <T> List<T>.rotate(n: Int): List<T> {
    return if (n > this.size || n < -this.size)
        throw IndexOutOfBoundsException(n)
    else if (n == 0 || n == this.size || n == -this.size)
        this.toList()
    else if (n < 0)
        List(this.size) { this[(it - n) % this.size] }
    else
        List(this.size) { this[(it + this.size - n) % this.size] }
}

/**
 * Rotate [this] list until the first occurrence of [element] is at position 0.
 *
 * @throws NoSuchElementException If no such element is found.
 */
fun <T> List<T>.rotateUntil(element: T): List<T> {
    val index = indexOf(element)
    if (index == -1)
        throw NoSuchElementException("Collection contains no element matching the predicate.")
    return this.rotate(index)
}

/**
 * Rotate [this] list until the last occurrence of [element] is at position 0.
 *
 * @throws NoSuchElementException If no such element is found.
 */
fun <T> List<T>.rotateUntilLast(element: T): List<T> {
    val index = lastIndexOf(element)
    if (index == -1)
        throw NoSuchElementException("Collection contains no element matching the predicate.")
    return this.rotate(index)
}

/**
 * Rotate [this] list until the first element matching the [predicate] is at position 0.
 *
 * @throws NoSuchElementException If no such element is found.
 */
fun <T> List<T>.rotateUntilFirst(predicate: (T) -> Boolean): List<T> {
    val index = indexOfFirst(predicate)
    if (index == -1)
        throw NoSuchElementException("Collection contains no element matching the predicate.")
    return rotate(index)
}

/**
* Rotate [this] list until the last element matching the [predicate] is at position 0.
*
* @throws NoSuchElementException If no such element is found.
*/
fun <T> List<T>.rotateUntilLast(predicate: (T) -> Boolean): List<T> {
    val index = indexOfLast(predicate)
    if (index == -1)
        throw NoSuchElementException("Collection contains no element matching the predicate.")
    return rotate(index)
}

/**
 * Rotate this list right by [n] places.
 *
 * @throws IndexOutOfBoundsException if [n] is greater than [this.size].
 */
fun <T> List<T>.rotateLeft(n: Int): List<T> {
    return if (n < 0 || n > this.size)
        throw IndexOutOfBoundsException(n)
    else if (n > 0)
        List(this.size) { this[(it + n) % this.size] }
    else
        this.toList()
}

/**
* Rotate this list left by [n] places.
*
* @throws IndexOutOfBoundsException if [n] is greater than [this.size].
*/
fun <T> List<T>.rotateRight(n: Int): List<T> {
    return if (n < 0 || n > this.size)
        throw IndexOutOfBoundsException(n)
    else if (n > 0) {
        val offset = this.size - n
        List(this.size) { this[(it + offset) % this.size] }
    }
    else
        this.toList()
}