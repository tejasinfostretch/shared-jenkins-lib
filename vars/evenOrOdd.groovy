def call(int buildNumber) {
    if (buildNumber % 2 == 0) {
        stage('First Stage') {
            steps {
                echo 'The build number is even'
            }
        }
  } else {
        stage('Odd Stage') {
            steps {
                echo 'The build number is odd'
            }
        }
    }
}
