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
          //  echo "build number" +  $BUILD_NUMBER
            echo "BUILD_NUMBER=${env.BUILD_NUMBER}"
		    
		     echo "JOB_NAME=${env.JOB_NAME}" 
		    echo "job_name" 

	        
	        if(currentBuild.result=='FAILURE'){  
	def issue = [fields: [ project: [key: 'TEST'],
	                       summary: 'env.JOB_NAME : env.BUILD_NUMBER - Failed for Selenium test cases hence raising Jira Issue',
	                       description: 'New JIRA issue has been created from Jenkins. Jenkins Build : env.BUILD_NUMBER - Failed for Selenium test cases hence raising Jira Issue',
	                       issuetype: [name: 'Bug']]]
	def newIssue = jiraNewIssue issue: issue, site: 'Jira Server'
	echo newIssue.data.key
	        }else {
	        echo "Nothing failed, so there is no need to create Jira issue"
			
			def issue = [fields: [ project: [key: 'TEST'],
					      summary: 'JOB_NAME : {env.BUILD_NUMBER} - Failed for Selenium test cases hence raising Jira Issue',
	                       description: 'New JIRA issue has been created from Jenkins. Jenkins Build : env.BUILD_NUMBER - Failed for Selenium test cases hence raising Jira Issue',
	                       issuetype: [name: 'Bug']]]
	def newIssue = jiraNewIssue issue: issue, site: 'Jira Server'
	echo newIssue.data.key
	        }
	    }
	        }
