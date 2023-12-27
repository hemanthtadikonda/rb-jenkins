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
      stage('ping') {
         steps {
            sh 'ansible -i 172.31.20.134, all -e ansible_user=${SSH_USR} -e ansible_password=${SSH_PSW} -m ping'
         }
      }
   }
   post {
      always {
         echo 'post'
         //send email
         //trigger another job
         //update some JIRA status about build
      }
   }
}