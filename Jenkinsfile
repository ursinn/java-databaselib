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
                sh 'mvn clean package -Djar.finalName=DatabaseLib-${GIT_BRANCH#*/}-#${BUILD_NUMBER}'
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
                }
	    }
        }
        stage('Deploy') {
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
                branch 'develop'
            }
            steps {
                echo 'Deploying..'
                configFileProvider([configFile(fileId: 'maven_settings', variable: 'SETTINGS')]) {
                    sh "mvn -s $SETTINGS clean deploy -DskipTests"
                }
            }
        }
    }
}
