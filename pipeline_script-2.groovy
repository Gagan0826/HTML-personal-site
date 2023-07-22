pipeline {
    agent any
    stages {
        stage("Install Apache2") {
            steps {
                sh 'sudo apt update' // Run apt update before installing Apache2
                sh 'sudo apt install apache2 -y'
            }
        }
        stage("Print Working Directory") {
            steps {
                sh 'pwd'
            }
        }
        stage("Git Clone") {
            steps {
                sh 'rm -rf jenkins-test-repo-1'
                sh 'git clone https://Gagan_br_ITT@bitbucket.org/dvoptrain/jenkins-test-repo-1.git'
                sh 'cd jenkins-test-repo-1'
                sh 'ls'
            }
        }
        stage("Copy and Host to Apache2") {
            steps {
                
                sh 'cd jenkins-test-repo-1/HTML-personal-site-master/'
                sh 'ls'
                sh 'sudo cp -r /var/lib/jenkins/workspace/pipeline-2/jenkins-test-repo-1/HTML-personal-site-master/* /var/www/html'
            }
        }
    }
}
