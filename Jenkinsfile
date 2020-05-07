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
        return;
      }
    }
    stage('SpringBoot Selenium/Cucumber Test') {
      when {
          expression { myStage == 'SpringBoot Selenium/Cucumber Test' }
      }

      steps {
        sh "mvn '-Dtest=*/RunCucumberTest.java' test"
      }
    }
  }
}
