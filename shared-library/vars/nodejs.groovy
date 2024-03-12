def call() {
   pipeline {
      agent any
      stages {
         stage('code Complie') {
            steps {
               sh 'find .'
               sh 'echo npm install'
            }
         }
         stage('code Test'){
            when {
               allOf {
                  expression ( BRANCH_NAME ==~ ".*")
                  expression ( TAG_NAME !=~ null )
               }
            }
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