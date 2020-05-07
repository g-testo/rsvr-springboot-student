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
      }
      steps {
        echo "Waiting for backend to start..."
        sleep(time:5,unit:"SECONDS")
      }
      steps {
        sh "mvn '-Dtest=*/RunCucumberTest.java' test"
      }
    }
  }
}
