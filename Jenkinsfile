node {
    stage('Prerequisite') {
        echo 'Java VERSION'
        sh 'java -version'
        echo 'Maven VERSION'
        sh 'mvn -version'
    }
    stage('Build') {
        echo 'Building via Maven'
        sh 'mvn clean install'
    }
    stage('Deploy to Runtime') {
        withCredentials([usernamePassword(credentialsId: 'provision', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
             sshCommand remote: remote, command: 'whoami', failOnError:'false'
        }
    }
}
