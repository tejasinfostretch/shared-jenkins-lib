def call() {
    copyJsFileIntoWorkspace()

    sh '''
        rm -rf package-lock.json
        npm install
        npm install shelljs
        node scanFile.js
                '''
}
