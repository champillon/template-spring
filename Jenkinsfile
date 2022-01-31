def remote = [:]
remote.name = 'runtime'
remote.host = 'runtime.passapong.dev'
remote.allowAnyHosts = true
remote.user = 'provision'
remote.password = 'This is my Password'

pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-user')
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
        stage('Check for Vulnerabilities') {
            steps {
                container ('snyk') {
                    withCredentials([string(credentialsId: 'SNYK_TOKEN', variable: 'SNYK_TOKEN')]) {
                        sh '''
                        ls
                        cd template-spring
                        snyk config set api=$SNYK_TOKEN
                        snyk test
                        '''
                    }
                }
            }
        }
        stage('Building') {
            steps {
                echo 'building project...'
                sh 'mvn clean install'
            }
        }
        stage('Push') {
            steps {
                withDockerRegistry([ credentialsId: 'docker-hub-user', url: '' ]) {
                    sh 'docker tag template-spring:0.0.2-SNAPSHOT  champillon/template-spring:0.0.2-SNAPSHOT'
                    sh 'docker push champillon/template-spring:0.0.2-SNAPSHOT'
                }
            }
        }
        stage('Deploy to Runtime') {
            steps {
                withDockerRegistry([ credentialsId: 'docker-hub-user', url: '' ]) {
                    sshCommand remote: remote, command: 'docker run -d -p 80:8080 champillon/template-spring:0.0.2-SNAPSHOT', failOnError:'false'
                }
            }
        }
    }
}
