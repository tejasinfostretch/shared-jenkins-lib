def call() {
    copyJsFileIntoWorkspace()
    try {
        sh '''
        cd dodCheck
        npm i
        node main.js
        '''
    } catch (e) {
        println('ERRORRRR.......................')
        println(e)
    }
}

