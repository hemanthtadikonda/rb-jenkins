pipeline {
   agent any
   environment {
      TEST_URL = 'https://google.com'
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
         }
      }
   }
}