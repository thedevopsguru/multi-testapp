#!/usr/bin/env groovy
node ('ubuntu') {

    stage ('Selenium Test_Case') {
         sh '/usr/bin/mvn package'
        sh 'java -cp /var/jenkins_home/workspace/multi-testapp_feature_test-K6A4HLPE5X6MGUHQE6DGYJCAN5ZEL3RT5YF4CDH3HOUUMRUQXCMQ/target/container-test.jar org.testng.TestNG -testclass testcases.TestCase1'
        
         }
    stage ('Jira issue update in case of failure') {
     
        def testIssue = [fields: [ // id or key must present for project.
                               project: [id: '10000'],
                               summary: 'New JIRA Created from Jenkins.',
                               description: 'New JIRA Created from Jenkins.',
                               customfield_1000: 'customValue',
                               // id or name must present for issuetype.
                               issuetype: [id: '3']]]

    response = jiraEditIssue idOrKey: 'TEST', issue: testIssue

    echo response.successful.toString()
    echo response.data.toString()
    }
        }
