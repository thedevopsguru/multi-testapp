node ('ubuntu') {

    stage ('Selenium Test_Case') {
         sh '/usr/bin/mvn package'
        sh 'java -cp /var/jenkins_home/workspace/multi-testapp_feature_test-K6A4HLPE5X6MGUHQE6DGYJCAN5ZEL3RT5YF4CDH3HOUUMRUQXCMQ/target/container-test.jar org.testng.TestNG -testclass testcases.TestCase1'
        
         }
    stage ('Jira issue update in case of failure') {
      sh  'curl \
   -D- \
   -u admin:admin \
   -X POST \
   --data { \
    "fields": { \
       "project": \
       { \
          "key": "TEST" \
       }, \
       "summary": "Issue from Jenkinsfile for selenium test case failures.", \
       "description": "Creating of an issue using project keys and issue type names using the REST API", \
       "issuetype": { \
          "name": "Bug" \
       } \
   } \
} \
 \
   -H "Content-Type: application/json" \
   http://52.90.151.23:9090/rest/api/2/issue/' 
    }
        }
