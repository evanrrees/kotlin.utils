package utils.views

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ViewsKtTest {

    @Test
    fun subArray() {
        val array = Array(4) { it }
        val subArray = array.subArray(0, 2)
        val list = listOf(1)
        subArray[0]++
        assertEquals(array[0], 1)
        assertThrows(IndexOutOfBoundsException::class.java) { subArray[2] }
        assertThrows(NotImplementedError::class.java) { subArray.add(123) }
        assertThrows(NotImplementedError::class.java) { subArray.removeAt(0) }
        assertThrows(NotImplementedError::class.java) { subArray.addAll(0, list) }
        assertThrows(NotImplementedError::class.java) { subArray.addAll(list) }
        assertThrows(NotImplementedError::class.java) { subArray.addAll(list.asSequence()) }
        assertThrows(NotImplementedError::class.java) { subArray.addAll(list.toTypedArray()) }
    }
}