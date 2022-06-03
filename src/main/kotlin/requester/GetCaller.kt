package requester

import com.squareup.okhttp.HttpUrl
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request

object GetCaller {
    private val client = OkHttpClient()

    fun get(httpUrl: HttpUrl): String {
        val request = Request.Builder().url(httpUrl).build()
        val response = client.newCall(request).execute()
        if (!response.isSuccessful) {
            throw IllegalStateException("Error for url: $httpUrl")
        }
        val jsonResponse = response.body().string()
        return jsonResponse
    }
}
