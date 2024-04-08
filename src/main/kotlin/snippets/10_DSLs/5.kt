package f_10_DSLs.s_5

inline fun <T> T.apply(block: T.() -> Unit): T {
    this.block() // same as block.invoke(this)
    return this
}
