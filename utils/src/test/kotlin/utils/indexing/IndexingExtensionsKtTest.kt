package utils.indexing

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IndexingExtensionsKtTest {

    @Test
    fun listGetNegative() {
        val list = List(3) { it + 1 }
        assertEquals(1, list.getNegative(-3))
        assertEquals(2, list.getNegative(-2))
        assertEquals(3, list.getNegative(-1))
    }

    @Test
    fun arrayGetNegative() {
        val array = Array(3) { it + 1 }
        assertEquals(1, array.getNegative(-3))
        assertEquals(2, array.getNegative(-2))
        assertEquals(3, array.getNegative(-1))
    }

}