def call() {
   pipeline {
      agent any
      stages {
         stage('code Complie') {
            steps {
               sh 'find env'
               sh 'echo npm install'
            }
         }
         stage('code Test'){
            steps{
               sh 'echo code test'
            }
         }
         stage('code quality'){
            steps{
               sh 'echo code quality'
            }
         }
         stage('code code security'){
            steps{
               sh 'echo code code security'
            }
         }
         stage('code Release'){
            steps{
               sh 'echo code release'
            }
         }
      }
   }
}