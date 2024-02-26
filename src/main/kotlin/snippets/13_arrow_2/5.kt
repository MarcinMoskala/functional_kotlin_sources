package f_13_arrow_2.s_5

sealed interface ConfigError
data class SystemError(val underlying: Throwable)
object PortNotAvailable : ConfigError
data class InvalidPort(val port: String) : ConfigError
