package f_10_DSLs.s_5

// Simplified apply implementation
inline fun <T> T.apply(block: T.() -> Unit): T {
    this.block() // same as block.invoke(this)
    return this
}
