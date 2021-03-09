def call() {

    sh '''
    mkdir dodCheck
    cd dodCheck
    mkdir bin
    mkdir database
    mkdir helper
    cd database
    mkdir models
    '''
    def packageJson = libraryResource 'dodCheck/package.json'
    writeFile file: 'dodCheck/package.json', text: packageJson
    def packageLockJson = libraryResource 'dodCheck/package-lock.json'
    writeFile file: 'dodCheck/package-lock.json', text: packageLockJson
}
