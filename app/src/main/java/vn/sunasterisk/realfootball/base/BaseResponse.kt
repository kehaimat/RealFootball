package vn.sunasterisk.realfootball.base

data class BaseResponse<T>(
    var result: T? = null,
    var error: Exception? = null,
    val status: Status
) {
    companion object {
        fun <T> success(data: T) = BaseResponse(data, null, Status.SUCCESS)

        fun <T> error(error: Exception, data: T?) = BaseResponse(data, error, Status.ERROR)

        fun <T> loading(data: T?) = BaseResponse(data, null, Status.LOADING)
    }
}
