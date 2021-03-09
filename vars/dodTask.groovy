def call(init = true) {
    copyJsFileIntoWorkspace()
    try {
        if (init) {
            sh '''
                cd dodCheck
                npm i
            '''
        }
        sh '''
            cd dodCheck
            node dod/qTest.dod.js
        '''
    } catch (e) {
        println('ERRORRRR.......................')
        println(e)
    }
    removeDodCheck()
}

