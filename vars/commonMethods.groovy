def checkMain(message) {
    sh '''
        rm -rf package-lock.json
        npm install shelljs
        node npmRun.js
                '''
}

def warning(message) {
    echo "WARNING: ${message}"
}
