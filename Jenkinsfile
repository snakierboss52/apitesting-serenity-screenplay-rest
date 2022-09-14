pipeline {
    agent any

    environment {
        //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
        VERSION = readMavenPom().getVersion()
        REPOSITORY_NAME = 'apitesting'
        def docker = "docker"
        }

    stages {
        stage('build image') {
            steps {
                echo 'Building..'
                sh "docker build -t apitesting:v1 ."
            }
        }
        stage('Running test in container'){
            steps{
                sh 'docker run apitesting:v1'
            }
        }
        stage('Deleting local images'){
            steps{
                echo 'deleting local image'
                sh "docker container prune -f"
            }
        }
    }
}