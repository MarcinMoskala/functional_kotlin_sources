package f_13_arrow_2.s_4

sealed class Either<out E, out A> {
    data class Left<E>(val value: E) : Either<E, Nothing>()
    data class Right<A>(val value: A) : Either<Nothing, A>()
}
