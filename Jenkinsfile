pipeline {
   agent any

   stages {
      stage('compile') {
         steps {
            sh 'mkdir hema'
            sh 'cd hema'
            sh 'git branch: 'main', url: 'https://github.com/hemanthtadikonda/rb-jenkins.git''

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
