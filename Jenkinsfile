def remote = [:]
remote.name = 'runtime'
remote.host = '35.225.48.218'
remote.allowAnyHosts = true
remote.user = 'provision'
remote.password = 'This is my Password'

pipeline {
    agent any

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
                sh 'mvn clean install'
            }
        }
        stage('Deploy to Runtime') {
            steps {
                sshCommand remote: remote, command: 'whoami', failOnError:'false'
            }
        }
    }
}
