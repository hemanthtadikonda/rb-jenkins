def info(message) {
   echo "INFO: ${message}"
}

def warning(message) {
   echo "WARNING: ${message}"
}

def call() {
   pipeline {
      agent any
      stages {
         stage('compile code'){
            steps {
               echo 'Hello World'
            }
         }
         stage('Test code'){
            steps {
               echo 'Hello World'
            }
         }
         stage('code quality'){
            steps {
               echo 'Hello World'
            }
         }
         stage('code security'){
            steps {
               echo 'Hello World'
            }
         }
         stage('Release'){
            steps {
               echo 'Hello World'
            }
         }
      }
   }
}