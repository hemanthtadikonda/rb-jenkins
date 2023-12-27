pipeline {
   agent any
   environment {
      TEST_URL = 'https://google.com'
      SSH = credentials('centos-ssh')
   }
   options {
      ansiColor('xterm')
   }
   parameters {
       string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

       text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

       booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')

       choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

       password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
   }
   triggers { pollSCM('*/1 * * * *') }

   tools {
      maven 'maven'
   }

   stages {
      stage('compile') {

         steps {
            sh 'mvn --version'
         }
      }
      stage('test') {

         input {
            message "Should we continue?"
            ok "Yes, we should."
         }
         steps {
            echo TEST_URL
            echo SSH
            sh 'env'
         }
      }
      stage('ping') {
         when {
            branch 'master'
         }

         steps {
            sh 'ansible -i 172.31.20.134, localhost -m ping'
            //sh 'ansible -i 172.31.20.134, all -e ansible_user=${SSH_USR} -e ansible_password=${SSH_PSW} -m ping'
         }
      }
   }
   post {
      always {
         echo 'post'
         echo 'poll SCM check'
         cleanWs()
      }
   }
}
