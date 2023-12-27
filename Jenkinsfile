pipeline {
   agent any
   options {
      ansiColor('xterm')
   }

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
      stage('ping') {
         steps {
            sh 'ansible -i 172.31.20.134, localhost -m ping'

         }
      }
   }
   post {
      always {
         echo 'post'

      }
   }
}
