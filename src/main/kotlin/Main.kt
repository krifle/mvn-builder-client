fun main(args: Array<String>) {
    val url = args[0]
    val source = args[1]
    val branch = args[2]
    val buildOpt = args[3]
    val targetPath = args[4]

    val mavenBuilder = MavenBuilder(url, source, branch, buildOpt, targetPath)
    mavenBuilder.build()
}
