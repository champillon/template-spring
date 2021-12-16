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
                sh 'mvn clean install'
            }
        }
        stage('Login') {
			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}
        stage('Push') {

			steps {
				sh 'docker push bharathirajatut/nodeapp:latest'
			}
		}
        stage('Deploy to Runtime') {
            steps {
                sshCommand remote: remote, command: 'whoami', failOnError:'false'
            }
        }
    }

    post {
		always {
			sh 'docker logout'
		}
	}
}
