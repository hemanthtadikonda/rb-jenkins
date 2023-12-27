pipeline {
   agent any
   environment {
      URL = 'google.com'
   }
   stages {
      stage('compile') {
         steps {
            echo 'code compile'
         }
      }
      stage('test') {
         steps {
            echo URL
         }
      }
   }
}