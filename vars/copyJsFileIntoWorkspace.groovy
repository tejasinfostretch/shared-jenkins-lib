def call() {
    def commonjs = libraryResource 'dod/common.js'
    writeFile file: 'common.js', text: commonjs
    def scanFile = libraryResource 'dod/scanFile.js'
    writeFile file: 'scanFile.js', text: scanFile
}
