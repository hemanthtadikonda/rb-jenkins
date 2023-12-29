def x =10
env.y = 20
def samplef(){
   print "Hello World"
   print "Welcome"
}

node {
   stage('one') {
      sh 'echo one'
      sh "echo y - ${y}"
      print y
   }
   stage('two') {
      sh 'echo two'
      sh "echo y value is ${y}"
   }
   stage('three') {
      sh 'echo three'
      print x
      samplef()
   }
   stage('four') {
      samplef()
   }
}

