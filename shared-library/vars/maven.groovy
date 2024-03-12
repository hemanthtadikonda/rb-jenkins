def call() {
   pipeline {
      agent any
      stages {

         stage('code complie') {
            steps {
               sh 'echo code compile'
            }
         }
         stage('code Test') {
            when {
               allOf {
                  expression  { env.BRANCH_NAME ==~ ".*" }
                  expression  { env.TAG_NAME    ==~ null }
               }
            }
            steps {
               sh 'echo code test'
            }
         }
         stage('code quality') {
            when {
               expression  { env.BRANCH_NAME ==~ "main" }
            }
            steps {
               sh 'echo code quality'
            }
         }
         stage('code security') {
            when {
               expression  { env.BRANCH_NAME ==~ "main" }
            }
            steps {
               sh 'echo code security'
            }
         }
         stage('code Release') {
            when {
               expression  { env.TAG_NAME ==~ ".*" }
            }
            steps {
               sh 'echo code release'
            }
         }
      }
   }
}