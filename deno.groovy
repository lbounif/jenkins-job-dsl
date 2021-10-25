pipelineJob('deno app test') { 

  def repo = 'https://github.com/lbounif/deno-app.git' 

  description("Deno app") 
  keepDependencies(false) 

  properties{ 

    githubProjectUrl (repo) 
    rebuild { 
      autoRebuild(false) 
    } 
  } 

  definition { 

    cpsScm { 
      scm { 
        git ('https://github.com/lbounif/deno-app.git'){ 
            node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Lynda Bounif')
            node / gitConfigEmail('l_bounif@esi.dz')
          branches('master') 
          scriptPath('Jenkinsfile') 
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want 
        } 
      } 
    } 
  }
}
