def call(String credId, String imageName,String imageTag){
  withCredentials([usernamePassword(credentialsId:credId,
                                    usernameVariable:"dockerHubUser",
                                    passwordVariable:"dockerHubPass")]){
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                    sh "docker image tag ${imageName}:${imageTag} ${env.dockerHubUser}/${imageName}:${imageTag}"
                    sh "docker push ${env.dockerHubUser}/${imageName}:${imageTag}"
          }
}


# withCredentials([usernamePassword(
  #                  'credentialsId':"dockerHubCred",
   #                 usernameVariable:"dockerHubUser/USERNAME"
    #                passwordVariable:"dockerHubPASS/PASSWORD")]) {
    #            sh "docker login -u ${env.dockerHubUser/USERNAME} -p ${env.dockerHubPass/PASSWORD} "
    #            sh "docker image tag image:latest ${env.dockerHuvuser}/image:latest"
    #            sh "docker push ${env.dockerHuvuser/USERNAME}/image:latest"
    #            }
