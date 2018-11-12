
node ('ubuntu') {
    

    stage ('checkout') {

        git url: 'https://github.com/thedevopsguru/multi-testapp.git'

    }

    stage ('Build') {
         
         sh '/usr/bin/mvn package'
         
    }
    
    stage ('UnitTest') {
        
        sh '/usr/bin/mvn test'
    }
   
   stage ('Code_Quality') {
     sh '/usr/bin/mvn sonar:sonar'
    }
    
    stage ('Upload_Artifacts') {
        
     sh 'curl -v  -F "r=releases" -F "g=com.genpact.demo" -F "a=App_demo" -F "v=1.0.0" -F "p=jar" -F "file=@./target/App_Demo-1.0.0.jar" -u admin:admin123 http://52.90.151.23:8081/nexus/content/repositories/snapshots/'   
    } 
    
    stage ('Build & Deploy Image') {
        
     sh 'docker build -t app .'
    }
    }
