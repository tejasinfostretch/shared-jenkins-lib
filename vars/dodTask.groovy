def call(init = true) {
    copyJsFileIntoWorkspace()
    try {
        def pipeline
        if (init) {
            pipeline = 'cd dodCheck \n npm i'
        }
        sh '''
            echo '''+pipeline+'''
            cd dodCheck
            node dod/qTest.dod.js
        '''
    } catch (e) {
        println('ERRORRRR.......................')
        println(e)
    }
}

