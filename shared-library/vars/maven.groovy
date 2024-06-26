def call() {
   pipeline {
      agent any
      stages {

         stage('code complie') {
            steps {
               //sh "export PATH=/opt/maven/bin:$PATH"
               sh 'sudo /home/centos/maven/bin/mvn package'
            }
         }
         stage('code Test') {
            when {
               allOf {
                  expression  { env.BRANCH_NAME ==~ ".*" }
                  expression  { env.TAG_NAME    == null }
               }
            }
            steps {
               sh 'echo code test'
            }
         }
         stage('code quality') {
            when {
               allOf {
                  expression  { env.BRANCH_NAME ==~ ".*" }
                  expression  { env.TAG_NAME    == null }
               }
            }
            steps {
               //sh 'sonar-scanner -Dsonar.host.url=http://172.31.38.221:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true -Dsonar.java.binaries=./target'
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
               sh 'echo ${TAG_NAME} >VERSION'
               sh 'cp target/${component}-1.0.jar ${component}.jar ; zip -r ${component}-${TAG_NAME}.zip ${component}.jar VERSION ${schema_dir}'
            }
         }
      }
   }
}




/// /etc/ssh ]# visudo
//## Allow root to run any commands anywhere
//root    ALL=(ALL)       ALL
//jenkins ALL=(ALL)       NOPASSWD: ALL
//## Allows members of the 'sys' group to run networking, software,
//## service management apps and more.
//# %sys ALL = NETWORKING, SOFTWARE, SERVICES, STORAGE, DELEGATING, PROCESSES, LOCATE, DRIVERS
//
//## Allows people in group wheel to run all commands
//# %wheel        ALL=(ALL)       ALL
//
//## Same thing without a password
//# %wheel        ALL=(ALL)       NOPASSWD: ALL
