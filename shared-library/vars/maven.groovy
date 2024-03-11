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
                  expression  { BRANCH_NAME ==~ ".*" }
                  expression  { TAG_NAME    ==~ null }
               }
            }
            steps {
               sh 'echo code test'
            }
         }
         stage('code quality') {
            when {
               expression  { BRANCH_NAME ==~ "main" }
            }
            steps {
               sh 'echo code quality'
            }
         }
         stage('code security') {
            when {
               expression  { BRANCH_NAME ==~ "main" }
            }
            steps {
               sh 'echo code security'
            }
         }
         stage('code Release') {
            when {
               expression  { TAG_NAME ==~ "main" }
            }
            steps {
               sh 'echo code release'
            }
         }
      }
   }
}