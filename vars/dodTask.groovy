def call() {
    copyJsFileIntoWorkspace()
    try {

        sh '''
            rm -rf package-lock.json
            npm install
            npm install shelljs
            node scanFile.js
                    '''
    } catch(e) {
        println('ERRORRRR.......................')
        println(e)
    }
}
