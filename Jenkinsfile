def remote = [:]
remote.name = 'runtime'
remote.host = 'runtime.passapong.dev'
remote.allowAnyHosts = true
remote.user = 'provision'
remote.password = 'This is my Password'

pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS=credentials('docker-hub-user')
    }

    stages {
        stage('Checking') {
            steps {
                echo 'Java VERSION'
                sh 'java -version'
                echo 'Maven VERSION'
                sh 'mvn -version'
            }
        }
        stage('Building') {
            steps {
                echo 'building project...'
                sh 'mvn clean deploy -Ddocker.user=DOCKERHUB_CREDENTIALS_USR -Ddocker.password=DOCKERHUB_CREDENTIALS_PSW -Ddocker.url=https://hub.docker.com/'
            }
        }
        stage('Deploy to Runtime') {
            steps {
                sshCommand remote: remote, command: 'whoami', failOnError:'false'
            }
        }
    }
}
