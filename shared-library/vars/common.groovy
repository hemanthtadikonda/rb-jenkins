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
      print 'codeQuality'
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