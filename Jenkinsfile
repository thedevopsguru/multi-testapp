#!/usr/bin/env groovy
	node ('ubuntu') {
	
	    stage ('Selenium Test_Case') {
	         sh '/usr/bin/mvn package'
	        sh 'java -cp /var/jenkins_home/workspace/multi-testapp_feature_test-K6A4HLPE5X6MGUHQE6DGYJCAN5ZEL3RT5YF4CDH3HOUUMRUQXCMQ/target/container-test.jar org.testng.TestNG -testclass testcases.TestCase1'
	        
	         }
	    stage ('SOAPUI Test_Case') {
	        
	        sh 'curl --form "project=@/var/jenkins_home/workspace/multi-testapp_feature_test-K6A4HLPE5X6MGUHQE6DGYJCAN5ZEL3RT5YF4CDH3HOUUMRUQXCMQ/soap.xml" http://localhost:3000'

	        }
	    
	    stage ('Jira issue update in case of Selenium test case failure(s)') {
	     
	echo "Connecting with jira"
	
	        echo "build stage" + currentBuild.result
            echo "BUILD_NUMBER=${env.BUILD_NUMBER}"
	    echo "JOB_NAME=${env.JOB_NAME}" 
	    def job_name= JOB_NAME
		    def build_num= BUILD_NUMBER
		    echo ":::->" + job_name 
	        
	def issue = [fields: [ project: [key: 'TEST'],
	                       summary: '$job_name : $build_num - Failed for Selenium test cases hence raising Jira Issue',
	                       description: 'New JIRA issue has been created from Jenkins. Jenkins Build : $build_num - Failed for Selenium test cases hence raising Jira Issue',
	                       issuetype: [name: 'Bug']]]
	def newIssue = jiraNewIssue issue: issue, site: 'Jira Server'
	echo newIssue.data.key
    }
 }
