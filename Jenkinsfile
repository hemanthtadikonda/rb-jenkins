def x =10
env.y = 20
def samplefun(){
   print "Hello World"
   print "Welcome"
}

node {
   if ( x > 10 ) {
      stage('one') {
         sh 'echo one'
         sh "echo y - ${y}"
         print y
      }
   }elseif (x > 25 ) {
      stage('four') {
         samplefun()
      }
   } else {
      stage('three') {
      print y
      }
   }
}

