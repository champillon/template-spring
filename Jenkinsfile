node {
    stage('Prerequisite') {
        echo 'Java VERSION'
        sh 'java -version'
        echo 'Maven VERSION'
        sh 'mvn -version'
    }
    stage('Build') {
        echo 'Building via Maven'
        sh 'pwd'
        sh 'mvn clean install'
    }
    stage('Deploy to Runtime') {
        withCredentials([usernamePassword(credentialsId: 'f1b7f160-d0c6-4940-b690-f3c9acaa1917', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
             sshCommand remote: remote, command: 'whoami', failOnError:'false'
        }
    }
}
