def call() {
    script {
        sh '''
        rm -rf package-lock.json
        npm install
        npm run build
                '''
    }
}
