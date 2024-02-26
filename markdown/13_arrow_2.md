```
/** read value from environment,
 * or null if failed or not present */
fun envOrNull(name: String): String? =
    runCatching { System.getenv(name) }.getOrNull()
```


```
fun configOrNull(): Config? {
    val envOrNull = envOrNull("port")
    return if (envOrNull != null) {
        val portOrNull = envOrNull.toIntOrNull()
        if (portOrNull != null) Config(portOrNull) else null
    } else null
}
```


```
fun config2(): MyConfig? =
    envOrNull("port")?.toIntOrNull()?.let(::Config)
```


```
import arrow.core.continuations.nullable

fun config3(): Config? = nullable.eager {
    val env = envOrNull("port").bind()
    val port = env.toIntOrNull().bind()
    Config(port)
}
```


```
fun add(a: String, b: String): Int? {
    val x = a.toIntOrNull() ?: return null
    val y = b.toIntOrNull() ?: return null
    return x + y
}
```


```
fun envOrNull(name: String): Result<String?> = runCatching {
    System.getenv(name)
}
```


```
import arrow.core.continuations.result

fun config4(): Result<Config> = result.eager {
    val envOrNull = envOrNull("port").bind()
    ensureNotNull(envOrNull) {
        IllegalStateException("Required port value was null")
    }
    val port = runCatching { envOrNull.toInt() }.bind()
    Config(port)
}
```


```
sealed class Either<out E, out A> {
    data class Left<E>(val value: E) : Either<E, Nothing>()
    data class Right<A>(val value: A) : Either<Nothing, A>()
}
```


```
sealed interface ConfigError
data class SystemError(val underlying: Throwable)
object PortNotAvailable : ConfigError
data class InvalidPort(val port: String) : ConfigError
```


```
import arrow.core.continuations.either

fun config5(): Either<ConfigError, Config> = either.eager {
    val envOrNull = Either.catch { System.getenv("port") }
        .mapLeft(::SecurityError)
        .bind()
    ensureNotNull(envOrNull) { PortNotAvailable }
    val port = ensureNotNull(envOrNull.toIntOrNull()) {
        InvalidPort(env)
    }
    Config(port)
}
```


```
import arrow.core.continuations.either

private val VALID_PORT = 0..65536

fun config5(): Either<ConfigError, Config> = either.eager {
    val envOrNull = Either.catch { System.getenv("port") }
        .mapLeft(::SecurityError)
        .bind()
    val env = ensureNotNull(envOrNull) { PortNotAvailable }
    val port = ensureNotNull(env.toIntOrNull()) {
        InvalidPort(env)
    }
    ensure(port in VALID_PORT) { InvalidPort(env) }
    Config(port)
}
```