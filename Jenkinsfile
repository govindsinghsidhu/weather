pipeline {
    agent none
   stages {
        stage('Maven Install') {
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
stage('Build Docker image') {
    agent any
steps{
sh 'docker build -t dockerhublive/weather:latest .'
}
}
stage('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhubid', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push dockerhublive/weather:latest'
        }
      }
    }
stage('Docker Cleaning up') {
    agent any
steps{
sh 'docker rmi dockerhublive/weather:latest'
}
}
stage('Kubernate Deployment') {
    agent any
steps{
sh 'kubectl apply -f deployment.yaml'
}
}       
       
    }
}
