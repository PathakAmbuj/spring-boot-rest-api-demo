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
                sh 'mvn jar:jar deploy:deploy'
            }
        }
    }
}
