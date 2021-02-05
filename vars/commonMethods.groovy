def call() {
    sh '''
        rm -rf package-lock.json
        npm install shelljs
        node npmRun.js
                '''
}
