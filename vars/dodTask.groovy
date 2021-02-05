def copyJsFileIntoWorkspace() {
    def common = libraryResource 'dod/common.js'
    writeFile file: 'common.js', text: common
    def scanFile = libraryResource 'dod/scanFile.js'
    writeFile file: 'scanFile.js', text: scanFile
}

def runCommand() {
    sh '''
        rm -rf package-lock.json
        npm install shelljs
        node scanFile.js
                '''
}
