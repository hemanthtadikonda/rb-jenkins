def compile() {
   stage('code complie'){
      if (env.codeType == "maven"){
         print 'maven'
      }
      if (env.codeType == "nodejs"){
         print 'nodejs'
      }
      if (env.codeType == "python"){
         print 'python'
      }
      if (env.codeType == "static"){
         print 'static'
      }
   }
}

def test(){
   stage('code test'){
      if (env.codeType == "maven"){
         print 'maven test'
      }
      if (env.codeType == "maven"){
         print 'maven test'
      }
      if (env.codeType == "python"){
         print 'python test'
      }
      if (env.codeType == "static"){
         print 'static test'
      }
   }
}

def codeQuality(){
   stage('code quality'){
      if (env.codeType == "maven"){
         sh 'sonar-scanner -Dsonar.host.url=http://172.31.38.221:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true -Dsonar.java.binaries=./target'
      } else {
         sh 'sonar-scanner -Dsonar.host.url=http://172.31.38.221:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true'
      }
   }
}

def codeSecurity(){
   stage('code security') {
      print 'codeSecurity'
   }
}

def release(){
   stage('release'){
      print 'release'
   }
}