package utils.views

class SubArray<T>(private val array: Array<T>, private val fromIndex: Int, toIndex: Int) : AbstractMutableList<T>() {
    override val size: Int

    init {
        checkRangeIndexes(fromIndex, toIndex, array.size)
        this.size = toIndex - fromIndex
    }

    override fun get(index: Int): T {
        checkElementIndex(index, size)
        return array[fromIndex + index]
    }

    override fun set(index: Int, element: T): T {
        checkElementIndex(index, size)
        val prev = array[fromIndex + index]
        array[fromIndex + index] = element
        return prev
    }

    companion object {
        internal fun checkRangeIndexes(fromIndex: Int, toIndex: Int, size: Int) {
            if (fromIndex < 0 || toIndex >= size) {
                throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex, size: $size")
            }
            if (fromIndex > toIndex) {
                throw IllegalArgumentException("fromIndex: $fromIndex > toIndex: $toIndex")
            }
        }
        internal fun checkElementIndex(index: Int, size: Int) {
            if (index < 0 || index >= size) {
                throw IndexOutOfBoundsException("index: $index, size: $size")
            }
        }

    }

    override fun add(index: Int, element: T) {
        throw NotImplementedError()
    }

    override fun removeAt(index: Int): T {
        throw NotImplementedError()
    }

}

fun <T> Array<T>.subArray(fromIndex: Int, toIndex: Int): SubArray<T> = SubArray(this, fromIndex, toIndex)