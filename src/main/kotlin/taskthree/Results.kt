package taskthree

sealed class Result<TData>(
    val isSuccess: Boolean,
    val data: TData? = null
) {
    val isFailure = !isSuccess

    class Success<TData>(data: TData?)
        : Result<TData>(true, data)

    class Error<TData>(val details: String)
        : Result<TData>(false)
}


fun <TData>processResult(result: Result<TData>) {
    when(result){
        is Result.Error -> {
            println("Error occurred: ${result.details}")
        }
        is Result.Success -> {
            println("Result is successful! Data: ${result.data}")
        }
    }
}