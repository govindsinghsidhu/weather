pipeline {
    agent none
   stages {
        stage('Build code') {
      agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v $HOME/.m2:/root/.m2'
        }
      }
      steps {
        sh 'mvn clean install'
      }
    }
stage('Build image') {
    agent any
steps{
sh 'docker build -t dockerhublive/weather:latest .'
}
}
stage('Push image') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhubid', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push dockerhublive/weather:latest'
        }
      }
    }

stage('Deploy') {
    agent any
steps{
sh 'kubectl apply -f deployment.yaml'
}
}
stage('Restart') {
    agent any
steps{
sh 'kubectl rollout restart deployment weather'
}
}
stage('Cleanup') {
    agent any
steps{
sh 'docker rmi dockerhublive/weather:latest'
}       
}
   }
}
