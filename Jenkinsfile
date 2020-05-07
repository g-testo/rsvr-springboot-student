pipeline {
  agent any
  stages {
    stage('SpringBoot Integration Test') {
      steps {
        sh "mvn '-Dtest=*/rsvrInClass/*' test"
      }
    }
    stage('SpringBoot Selenium/Cucumber Test') {
      steps {
        sh "mvn spring-boot:run"
        echo "Waiting for backend to start..."
        sleep(time:5,unit:"SECONDS")
        sh "mvn '-Dtest=*/RunCucumberTest.java' test"
      }
    }
  }
}
