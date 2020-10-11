pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
	
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
				sh 'mvn clean package -Djar.finalName=DatabaseLib-#${BUILD_NUMBER}'
			}
			post {
				success {
					archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
                }
			}
        }
    }
}
