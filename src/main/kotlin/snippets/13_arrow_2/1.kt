package f_13_arrow_2.s_1

/** read value from environment,
 * or null if failed or not present */
fun envOrNull(name: String): String? =
    runCatching { System.getenv(name) }.getOrNull()
