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
        sh "[[ ! -d ./rsvr-angular ]] && git clone https://github.com/g-testo/rsvr-angular; cd rsvr-angular; [[ ! -d ./node_modules ]] && npm install; ng serve &"
       }
    }
    stage('SpringBoot Selenium/Cucumber Test') {
      steps {
        sh "mvn spring-boot:run &"
        sleep(time:10,unit:"SECONDS")
        sh "mvn '-Dtest=*/RunCucumberTest.java' test"
      }
    }
    stage('Build Docker File') {
      steps {
        sh "mvn package; docker build -t rsvrspringboottest ."
      }
    }
  }
  post {
    always {
      sh "kill \$(lsof -t -i:4200)"
    }
  }
}
