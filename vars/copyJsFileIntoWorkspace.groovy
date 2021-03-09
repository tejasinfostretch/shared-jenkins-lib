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
        'helper/dodLog.helper.js',
        'helper/splunk.helper.js',
        'database/db.js',
        'database/index.js',
        'database/models/dodTypes.model.js',
        'database/models/logs.model.js',
    ]

    for (element in listFiles) {
        def packageJson = libraryResource element
        writeFile file: element, text: packageJson
    }
}
