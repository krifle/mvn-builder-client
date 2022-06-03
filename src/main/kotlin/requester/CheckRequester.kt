package requester

import com.squareup.okhttp.HttpUrl
import model.BuildInfo

class CheckRequester(
    private val url: String,
    private val buildInfo: BuildInfo
) {
    fun check(): BuildInfo {
        val httpUrl = HttpUrl.parse(url).newBuilder()
            .addPathSegment("check")
            .addEncodedQueryParameter("id", buildInfo.id)
            .build()

        val jsonResponse = GetCaller.get(httpUrl)

        return BuildInfo.from(jsonResponse)
    }
}
