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
        sh "mvn '-Dtest=*/RunCucumberTest.java' test"
      }
    }
  }
}
