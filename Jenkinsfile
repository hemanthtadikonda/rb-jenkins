pipeline {
   agent any
   environment {
      URL = 'clang'
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