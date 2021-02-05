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
        printl('ERRORRRR.......................')
        printl(e)
    }
}
