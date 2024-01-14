pipeline {
        agent any

    tools {
        maven 'jenkins-maven'
        jdk 'jenkins-jdk'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'cp /var/lib/jenkins/workspace/spring-boot-rest-api-demo-pipeline/target/spring-boot-rest-api-demo-0.0.1-SNAPSHOT.jar /home/deployments/'
            }
        }
    }
}
