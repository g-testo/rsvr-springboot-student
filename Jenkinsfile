pipeline {
  agent none
  stages {
    stage('Jenkinsfile Test') {
      agent { 
        docker {
         image 'maven:3-alpine' 
        }
      }
      steps {
        sh 'mvn test'
      }
    }
  }
}
