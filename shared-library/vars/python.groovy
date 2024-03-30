def call() {
   pipeline {
      agent any
      stages {

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
               allOf{
                  expression { env.BRANCH_NAME ==~ ".*"}
                  expression { env.TAG_NAME  == null   }
               }
            }
            steps {
               //sh 'sonar-scanner -Dsonar.host.url=http://172.31.38.221:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true'
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
               sh 'echo code Released'
            }
         }
      }


   }
}