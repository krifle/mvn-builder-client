import model.BuildState
import requester.BuildRequester
import requester.CheckRequester

class MavenBuilder(
    private val url: String,
    private val source: String,
    private val branch: String,
    private val buildOpt: String,
    private val targetPath: String
) {
    private var downloadUrl = ""

    fun build() {
        printHeader()

        val buildInfo = BuildRequester(url, source, branch, buildOpt, targetPath).get()

        while (true) {
            Thread.sleep(1000L)

            val checkInfo = CheckRequester(url, buildInfo).check()
            val msg = checkInfo.outputBuffer.trim()

            if (msg.isNotEmpty()) {
                println(msg)
            }

            val state = checkInfo.state

            if (state == BuildState.DONE) {
                downloadUrl = checkInfo.resultUrl
                break
            }

            if (state == BuildState.STOPPED || state == BuildState.ERROR) {
                break
            }
        }

        // downloader TODO
        println(downloadUrl)
    }

    private fun printHeader() {
        println("url: $url")
        println("source: $source")
        println("branch: $branch")
        println("buildOpt: $buildOpt")
        println("targetPath: $targetPath")
    }
}
