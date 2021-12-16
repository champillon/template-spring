def remote = [:]
remote.name = 'runtime'
remote.host = '35.225.48.218'
remote.allowAnyHosts = true

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
                withCredentials([usernamePassword(credentialsId: '7ce2c7d5-dba1-4569-8efa-bc1dd846e8c0', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    step {
                        remote.user = USERNAME
                        remote.password = PASSWORD

                        sshCommand remote: remote, command: 'whoami', failOnError:'false'
                    }
                }
            }
        }
    }
}
