def call(init = true) {
    copyJsFileIntoWorkspace()
    try {
        sh '''
            cd dodCheck
        '''
        if (init) {
            sh '''
                npm i
            '''
        }
        sh '''
            node dod/qTest.dod.js
        '''
    } catch (e) {
        println('ERRORRRR.......................')
        println(e)
    }
    removeDodCheck()
}

