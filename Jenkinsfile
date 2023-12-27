pipeline {
   agent any
   environment {
      TEST_URL = 'clang'
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