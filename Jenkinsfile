node {
    stage('Checking') {
        echo 'Java VERSION'
        sh 'java -version'
        echo 'Maven VERSION'
        sh 'mvn -version'
    }
    stage('Building') {
        echo 'Building via Maven'
        sh 'mvn clean install'
    }
}
