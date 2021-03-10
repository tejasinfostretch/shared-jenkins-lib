def call(init = true) {
    copyJsFileIntoWorkspace()
    try {
        def npmInit

        if (init) {
            npmInit = 'npm i'
        }

        def data = getData()

        sh '''
            cd dodCheck
            echo '''+npmInit+'''

            node dod/qTest.dod.js '${data}'
        '''
    } catch (e) {
        println('ERRORRRR.......................')
        println(e)
    }
}

def getData() {
    def test = 'this is string'

    def someMap = [
            'key1': 'value',
            'key2': 142.1,
            'key3': test
        ]

    def json = new groovy.json.JsonBuilder()

    json rootKey: someMap

    def data = json.toString()
    return data
}
