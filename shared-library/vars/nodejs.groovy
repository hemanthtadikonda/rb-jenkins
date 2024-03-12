def call() {
   pipeline {
      agent any
      stages {
         stage('code Complie') {
            steps {
               sh 'env'
               sh 'echo npm install'
            }
         }
         stage('code Test'){
            when {
               allOf {
                  expression { env.BRANCH_NAME != null }
                  expression { env.TAG_NAME == null }
               }
            }
            steps {
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