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
    String[] listFiles = [
        'dodCheck/package.json',
        'dodCheck/package-lock.json',
        'dodCheck/main.js',
        'dodCheck/.env',
        'dodCheck/helper/dodLog.helper.js',
        'dodCheck/helper/splunk.helper.js',
        'dodCheck/database/db.js',
        'dodCheck/database/index.js',
        'dodCheck/database/models/dodTypes.model.js',
        'dodCheck/database/models/logs.model.js',
    ]

    for (element in listFiles) {
        def packageJson = libraryResource element
        writeFile file: element, text: packageJson
    }
}
