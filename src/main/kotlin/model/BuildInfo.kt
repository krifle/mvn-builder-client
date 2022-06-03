package model

import com.google.gson.Gson

data class BuildInfo(
    val id: String,
    val created: Long,
    val state: BuildState,
    val source: String,
    val buildOpt: String,
    val outputBuffer: String,
    val resultUrl: String
) {
    companion object {
        private val gson = Gson()

        fun from(json: String): BuildInfo {
            return gson.fromJson(json, BuildInfo::class.java)
        }
    }
}
