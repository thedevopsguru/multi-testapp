#!/usr/bin/env groovy
node ('ubuntu') {

    stage ('Selenium Test_Case') {
         sh '/usr/bin/mvn package'
        sh 'java -cp /var/jenkins_home/workspace/multi-testapp_feature_test-K6A4HLPE5X6MGUHQE6DGYJCAN5ZEL3RT5YF4CDH3HOUUMRUQXCMQ/target/container-test.jar org.testng.TestNG -testclass testcases.TestCase1'
        
         }
    stage ('Jira issue update in case of failure') {
     
echo "Connecting with jira"
withEnv(['JIRA_SITE=******']) {
def testIssue = [fields: [ project: [id: 10000],
summary: "New JIRA Created from Jenkins.",
description: "New JIRA Created from Jenkins.",
                   issuetype: [id: 3],
                   "customfield_10200": { "name": "TEST" } 
 ]]            
response = jiraNewIssue issue: testIssue
    echo response.successful.toString()
echo response.data.toString()
    }
        }
