def call() {
   pipeline {
      agent any
      stages {
         stage('code compile'){
            steps {
               sh 'env'
               sh 'echo python code do not required'
            }
         }
         stage('code Test'){
            when {
               allOf{
                  expression { env.BRANCH_NAME ==~ ".*"}
                  expression { env.TAG_NAME  == null   }
               }
            }
            steps {
               sh 'echo code test'
            }
         }
         stage('code Quality'){
            when {
               expression { env.BRANCH_NAME ==~ "main"}
            }
            steps {
               sh 'echo sonar code security'
            }
         }
         stage('code security'){
            when {
               expression { env.BRANCH_NAME ==~ "main"}
            }
            steps {
               sh 'echo code security'
            }
         }
         stage('code Release') {
            when {
               expression { env.TAG_NAME ==~ ".*"}
            }
            steps {
               sh 'code Released'
            }
         }
      }


   }
}