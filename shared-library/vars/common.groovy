def compile() {
   stage('code complie'){
      if (env.codeType == "maven") {
         //sh 'mvn package'
         //sh '/home/centos/maven/bin/mvn -version'
         sh '/home/centos/maven/bin/mvn package'
         //print 'maven'
      }
      if (env.codeType == "nodejs"){
         //print 'npm install'
         sh 'npm install'
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
         //sh 'sonar-scanner -Dsonar.host.url=http://172.31.38.221:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true -Dsonar.java.binaries=./target'
         print 'ok'
      } else {
         //sh 'sonar-scanner -Dsonar.host.url=http://172.31.38.221:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true'
         print 'ok'
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
      sh 'echo ${TAG_NAME} >VERSION'
      if (env.codeType == "nodejs"){
         sh 'zip -r ${component}-${TAG_NAME}.zip server.js node_modules VERSION ${schema_dir}'
      }else if (env.codeType == "maven"){
         sh 'cp target/${component}-1.0.jar ${component}.jar ; zip -r ${component}-${TAG_NAME}.zip ${component}.jar VERSION ${schema_dir}'
      } else {
         sh 'zip -r ${component}-${TAG_NAME}.zip *'
         sh 'ls'
      }
      sh 'curl -v -u admin:admin123 --upload-file ${component}-${TAG_NAME}.zip http://172.31.37.183:8081/repository/${component}/${component}-${TAG_NAME}.zip'
   }
}
