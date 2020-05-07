pipeline {
  agent any
  tools {
    maven 'Default'
  }
  stages {
    stage('Jenkinsfile Test') {
      steps {
        sh 'mvn -v'
      }
    }
  }
}
