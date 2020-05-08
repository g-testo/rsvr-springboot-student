pipeline {
  agent any
  stages {
    stage('SpringBoot Integration Test') {
      steps {
        sh "mvn '-Dtest=*/rsvrInClass/*' test"
      }
    }
    stage('Clone and run angular repo') {
      steps {
        sh "rm -rf rsvr-angular"
        sh "git clone https://github.com/g-testo/rsvr-angular; cd rsvr-angular; npm install; ng serve &"
        sh "pwd"
      }
    }
    stage('SpringBoot Selenium/Cucumber Test') {
      steps {
        sh "mvn spring-boot:run &"
        sleep(time:10,unit:"SECONDS")
        sh "mvn '-Dtest=*/RunCucumberTest.java' test"
      }
    }
  }
}
