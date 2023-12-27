pipeline {
    agent any

    stages {
        stage('code compile') {
            steps {
                echo 'code compile'
            }
        }
        stage('code test') {
           steps {
               echo 'code test'
           }
        }
        stage('code quality') {
            steps {
                echo 'code quality'
            }
        }
        stage('code security') {
           steps {
               echo 'code security'
           }
        }
    }
    post {
        always {
              echo 'post'
        }
    }
}