node {
    agent any

    stages {
        stage('Checking') {
            steps {
                echo "Java VERSION"
                sh 'java -version'
                echo "Maven VERSION"
                sh 'mvn -version'
            }
        }
        stage('Building') {
            steps {
                echo 'building project...'
                sh "mvn clean install"
            }
        }
    }
}
