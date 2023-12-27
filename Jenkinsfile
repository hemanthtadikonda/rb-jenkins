pipeline {
   agent any
   environment {
      CC = 'clang'
   }
   stages {
      stage('compile') {
         steps {
            echo 'code compile'
         }
      }
      stage('test') {
         steps {
            echo CC
         }
      }
   }
}