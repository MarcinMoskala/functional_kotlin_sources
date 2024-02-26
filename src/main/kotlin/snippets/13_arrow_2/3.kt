package f_13_arrow_2.s_3

fun envOrNull(name: String): Result<String?> = runCatching {
    System.getenv(name)
}
