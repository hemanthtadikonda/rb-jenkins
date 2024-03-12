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
                  expression { env.BRANCH_NAME ==~ ".*" }
                  expression { env.TAG_NAME == null }
               }
            }
            steps {
               sh 'echo code test'
            }
         }
         stage('code quality'){
            when {
               expression { env.BRANCH_NAME ==~ "main" }
            }
            steps{
               sh 'echo code quality'
            }
         }
         stage('code code security'){
            when {
               expression { env.BRANCH_NAME ==~ "main" }
            }
            steps{
               sh 'echo code code security'
            }
         }
         stage('code Release'){
            when {
               expression { env.TAG_NAME ==~ ".*" }
            }
            steps{
               sh 'echo code release'
            }
         }
      }
   }
}