#!/usr/bin/env groovy
node ('ubuntu') {

    stage ('Selenium Test_Case') {
         sh '/usr/bin/mvn package'
        sh 'java -cp /var/jenkins_home/workspace/multi-testapp_feature_test-K6A4HLPE5X6MGUHQE6DGYJCAN5ZEL3RT5YF4CDH3HOUUMRUQXCMQ/target/container-test.jar org.testng.TestNG -testclass testcases.TestCase1'
        
         }
    stage ('Jira issue update in case of Selenium test case failure(s)') {
     
echo "Connecting with jira"

        echo "build stage" + currentBuild.result
        if(currentBuild.result=='FAILURE'){  
def issue = [fields: [ project: [key: 'TEST'],
                       summary: 'Jenkins Build Number : $BUILD_NUMBER - Failed, raising Jira for the issue tracking',
                       description: 'New JIRA issue has been created from Jenkins.',
                       issuetype: [name: 'Bug']]]
def newIssue = jiraNewIssue issue: issue, site: 'Jira Server'
echo newIssue.data.key
        }else {
        echo "Nothing failed.
        }
    }
        }
