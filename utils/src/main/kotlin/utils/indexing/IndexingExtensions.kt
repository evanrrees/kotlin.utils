package utils.indexing

fun <T> Collection<T>.getNegative(index: Int): T {
    return if (index > 0) elementAt(index) else elementAt(size + index)
}

fun <T> Array<T>.getNegative(index: Int): T {
    return if (index > 0) get(index) else get(size + index)
}

operator fun <T> List<T>.get(indices: IntRange): List<T> {
    return this.slice(indices)
}

operator fun <T> List<T>.get(indices: Iterable<Int>): List<T> {
    return this.slice(indices)
}

operator fun <T> Array<T>.get(indices: IntRange): Array<T> {
    return this.sliceArray(indices)
}

operator fun <T> Array<T>.get(indices: Collection<Int>): Array<T> {
    return this.sliceArray(indices)
}

@JvmName("getFromArrayOfArrays")
inline operator fun <reified T> Array<Array<T>>.get(i: Int, j: Int): T {
    return this.elementAt(i).elementAt(j)
}

@JvmName("getFromCollectionOfCollections")
inline operator fun <reified T> Collection<Collection<T>>.get(i: Int, j: Int): T {
    return this.elementAt(i).elementAt(j)
}

@JvmName("getFromCollectionOfArrays")
inline operator fun <reified T> Collection<Array<T>>.get(i: Int, j: Int): T {
    return this.elementAt(i).elementAt(j)
}

@JvmName("getFromArrayOfCollections")
inline operator fun <reified T> Array<Collection<T>>.get(i: Int, j: Int): T {
    return this.elementAt(i).elementAt(j)
}