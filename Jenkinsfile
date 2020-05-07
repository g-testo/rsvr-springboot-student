pipeline {
  agent any
  stages {
    stage('SpringBoot Integration Test') {
      steps {
        sh "mvn '-Dtest=*/rsvrInClass/*' test"
      }
    }
    stage('Start up backend') {
      steps {
        echo "Waiting for backend to start..."
        sh "mvn spring-boot:run"
        sleep(time:10,unit:"SECONDS")
      }
    }
    stage('SpringBoot Selenium/Cucumber Test') {
      steps {
        sh "mvn '-Dtest=*/RunCucumberTest.java' test"
      }
    }
  }
}
