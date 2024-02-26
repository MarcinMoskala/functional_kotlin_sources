package f_10_DSLs.s_7

fun <T> buildList(init: MutableList<T>.() -> Unit): List<T>{
    val list = mutableListOf<T>()
    list.init()
    return list
    // or just
    // return mutableListOf<T>().apply(init)
}
