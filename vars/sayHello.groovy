#!/usr/bin/env groovy

def call(String name = 'human') {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    echo "Hello, ${name}."
    stage ('Call eslint check') {
        steps {
            script {
                sh '''
                rm -rf package-lock.json
                npm install
                npm run build
                '''
            }
        }
    }
}
