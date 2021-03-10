def call(init = true) {
    copyJsFileIntoWorkspace()
    try {
        def npmInit

        if (init) {
            npmInit = 'npm i'
        }

        sh '''
            cd dodCheck
            echo '''+npmInit+'''

            node dod/qTest.dod.js
        '''

        def someMap = [
            'key1': 'value',
            'key2': 142.1
        ]

        def json = new groovy.json.JsonBuilder()

        json rootKey: someMap

        println(json.toString())
    } catch (e) {
        println('ERRORRRR.......................')
        println(e)
    }
}
