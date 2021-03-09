def call() {

    sh '''
    mkdir -p dodCheck
    cd dodCheck
    mkdir -p bin
    mkdir -p database
    mkdir -p helper
    cd database
    mkdir -p models
    '''
    def packageJson = libraryResource 'dodCheck/package.json'
    writeFile file: 'dodCheck/package.json', text: packageJson
    def packageLockJson = libraryResource 'dodCheck/package-lock.json'
    writeFile file: 'dodCheck/package-lock.json', text: packageLockJson
}
