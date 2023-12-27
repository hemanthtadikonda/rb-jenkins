pipeline {
   agent any
   environment {
      TEST_URL = 'https://google.com'
      SSH = credentials('centos-ssh')
   }
   stages {
      stage('compile') {
         steps {
            echo 'code compile'
         }
      }
      stage('test') {
         steps {
            echo TEST_URL
            echo SSH
            sh 'env'
         }
      }
   }
   post {
      always {
         echo post
         //send email
         //trigger another job
         //update some JIRA status about build
      }
   }
}