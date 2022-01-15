package utils.views

fun <T> List<T>.windows(size: Int, step: Int = 1, partialWindows: Boolean = true): List<List<T>> {
    return indices.windowed(size, step, partialWindows) { subList(it.first(), it.last() + 1) }
}

fun <T, R> List<T>.windows(
    size: Int,
    step: Int = 1,
    partialWindows: Boolean = true,
    transform: (List<T>) -> R
): List<R> {
    return indices.windowed(size, step, partialWindows) { transform(subList(it.first(), it.last() + 1)) }
}

fun <T> Array<T>.windows(size: Int, step: Int = 1, partialWindows: Boolean = true): List<SubArray<T>> {
    return indices.windowed(size, step, partialWindows) { subArray(it.first(), it.last() + 1) }
}

fun <T, R> Array<T>.windows(
    size: Int,
    step: Int = 1,
    partialWindows: Boolean = true,
    transform: (SubArray<T>) -> R
): List<R> {
    return indices.windowed(size, step, partialWindows) { transform(subArray(it.first(), it.last() + 1)) }
}

