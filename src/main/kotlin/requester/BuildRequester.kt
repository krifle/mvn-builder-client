package requester

import com.squareup.okhttp.HttpUrl
import model.BuildInfo

class BuildRequester(
    private val url: String,
    private val source: String,
    private val branch: String,
    private val buildOpt: String,
    private val targetPath: String
) {
    fun get(): BuildInfo {
        val httpUrl = HttpUrl.parse(url).newBuilder()
            .addPathSegment("start")
            .addEncodedQueryParameter("source", source)
            .addEncodedQueryParameter("branch", branch)
            .addEncodedQueryParameter("buildOpt", buildOpt)
            .addEncodedQueryParameter("targetPath", targetPath)
            .build()

        val jsonResponse = GetCaller.get(httpUrl)

        return BuildInfo.from(jsonResponse)
    }
}
