def call() {
    copyJsFileIntoWorkspace()
    try {
        sh '''pwd'''
    } catch (e) {
        println('ERRORRRR.......................')
        println(e)
    }
}

