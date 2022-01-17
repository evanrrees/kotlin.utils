package utils

import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith
import kotlin.test.asserter
import org.junit.jupiter.api.Assertions.*

internal class RotateKtTest {

    class BasicRotate {

        @Test
        fun positiveIndex() {
            val expect = listOf(3, 4, 1, 2)
            assertEquals(expect, listOf(1, 2, 3, 4).rotate(2))
        }

        @Test
        fun negativeIndex() {
            val expect = listOf(3, 4, 1, 2)
            assertEquals(expect, listOf(1, 2, 3, 4).rotate(-2))
        }

        @Test
        fun positiveIndexOutOfBounds() {
            assertFailsWith(IndexOutOfBoundsException::class) { listOf(1, 2, 3, 4).rotate(5) }
        }

        @Test
        fun negativeIndexOutOfBounds() {
            assertFailsWith(IndexOutOfBoundsException::class) { listOf(1, 2, 3, 4).rotate(-5) }
        }

        @Test
        fun rotateByZeroIsSame() {
            val expect = listOf(1, 2, 3, 4)
            assertEquals(expect, listOf(1, 2, 3, 4).rotate(0))
        }

        @Test
        fun rotateByZeroIsCopy() {
            val expect = listOf(1, 2, 3, 4)
            assertNotReferentiallyEqual(expect, expect.rotate(0))
        }

        @Test
        fun rotateByFourIsCopy() {
            val expect = listOf(1, 2, 3, 4)
            assertNotReferentiallyEqual(expect, expect.rotate(4))
        }

        @Test
        fun rotateByNegativeFourIsCopy() {
            val expect = listOf(1, 2, 3, 4)
            assertNotReferentiallyEqual(expect, expect.rotate(-4))
        }

        @Test
        fun rotatePositiveBySizeIsSame() {
            val expect = listOf(1, 2, 3, 4)
            assertEquals(expect, listOf(1, 2, 3, 4).rotate(4))
        }

        @Test
        fun rotateNegativeBySizeIsSame() {
            val expect = listOf(1, 2, 3, 4)
            assertEquals(expect, listOf(1, 2, 3, 4).rotate(-4))
        }

    }

    class RotateUntil {
        @Test
        fun rotateUntil() {
            val expect = listOf('b', 'c', 'd', 'a')
            assertEquals(expect, listOf('a', 'b', 'c', 'd').rotateUntil('b'))
        }

        @Test
        fun rotateUntilFirst() {
            val expect = listOf('b', 'c', 'b', 'a')
            assertEquals(expect, listOf('a', 'b', 'c', 'b').rotateUntilFirst { it == 'b' })
        }

        @Test
        fun rotateUntilLastPredicate() {
            val expect = listOf('b', 'a', 'b', 'c')
            assertEquals(expect, listOf('a', 'b', 'c', 'b').rotateUntilLast { it == 'b' })
        }

        @Test
        fun rotateUntilLastElement() {
            val expect = listOf('b', 'a', 'b', 'c')
            assertEquals(expect, listOf('a', 'b', 'c', 'b').rotateUntilLast('b'))
        }
    }

    class RotateLeft {

        @Test
        fun rotateLeftByOne() {
            val expect = listOf(2, 3, 4, 1)
            assertEquals(expect, listOf(1, 2, 3, 4).rotateLeft(1))
        }

        @Test
        fun rotateLeftByFourIsSame() {
            val expect = listOf(1, 2, 3, 4)
            assertEquals(expect, listOf(1, 2, 3, 4).rotateLeft(4))
        }

        @Test
        fun rotateLeftByNegativeThrows() {
            assertFailsWith(IndexOutOfBoundsException::class) { listOf(1, 2, 3, 4).rotateLeft(-1) }
        }
        @Test
        fun rotateLeftByGTSizeThrows() {
            assertFailsWith(IndexOutOfBoundsException::class) { listOf(1, 2, 3, 4).rotateLeft(5) }
        }
    }

    class RotateRight {
        @Test
        fun rotateRightByOne() {
            val expect = listOf(4, 1, 2, 3)
            assertEquals(expect, listOf(1, 2, 3, 4).rotateRight(1))
        }

        @Test
        fun rotateRightByFourIsSame() {
            val expect = listOf(1, 2, 3, 4)
            assertEquals(expect, listOf(1, 2, 3, 4).rotateRight(4))
        }

        @Test
        fun rotateRightByNegativeThrows() {
            assertFailsWith(IndexOutOfBoundsException::class) { listOf(1, 2, 3, 4).rotateRight(-1) }
        }

        @Test
        fun rotateRightByGTSizeThrows() {
            assertFailsWith(IndexOutOfBoundsException::class) { listOf(1, 2, 3, 4).rotateRight(5) }
        }
    }

}

private fun messagePrefix(message: String?) = if (message == null) "" else "$message. "

fun <T> assertReferentiallyEqual(expected: T, actual: T, message: String? = null) {
    asserter.assertTrue({ messagePrefix(message) +
            "Expected <${System.identityHashCode(expected)}>, actual <${System.identityHashCode(actual)}>." },
        actual === expected)
}

fun <T> assertNotReferentiallyEqual(expected: T, actual: T, message: String? = null) {
    asserter.assertTrue({ messagePrefix(message) +
            "Expected <${System.identityHashCode(expected)}>, actual <${System.identityHashCode(actual)}>." },
        actual !== expected)
}