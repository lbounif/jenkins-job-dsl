job('NodeJS example') {
    scm {
        git('https://github.com/lbounif/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Lynda Bounif')
            node / gitConfigEmail('l_bounif@esi.dz')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}