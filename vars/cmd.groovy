def call(String command) {
    return bat(returnStdout: true, script: "${command}").trim()
}
