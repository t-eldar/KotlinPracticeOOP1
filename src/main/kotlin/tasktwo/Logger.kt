package tasktwo

enum class LogLevel {
    WARN, ERROR, INFO
}

class Logger private constructor() {
    fun log(message: String, level: LogLevel = LogLevel.INFO) {
        println("-------${level.name}-------")
        println(message)
    }

    companion object {
        private val _lock = Any()
        private var _instance: Logger? = null

        fun getInstance(): Logger {
            if (_instance == null) {
                synchronized(_lock) {
                    if (_instance == null) {
                        _instance = Logger()
                    }
                }
            }

            return _instance
                ?: throw Error("Error occurred! Could not instantiate Logger object!")
        }
    }
}

