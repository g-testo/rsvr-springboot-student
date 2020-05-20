pipeline {
  agent any
  tools {
    maven 'default'
  }
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
    stage('Deploy to Heroku') {
      steps {
         bat """
            heroku git:remote -a rsvrspringboot
            git checkout master
            git push heroku master
         """
      }
    }
  }
  post {
    always {
      bat """
        for /f "tokens=5" %%a in ('netstat -aon ^| find "4200"') do taskkill /f /pid %%a
      """
    }
  }
}
