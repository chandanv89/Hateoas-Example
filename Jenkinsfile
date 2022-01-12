pipeline {
    agent any
	options {
		ansiColor('xterm')
	}

    stages {
        stage('Build') {
            steps {
                echo 'Cleaning workspace...'
		        sh 'mvn clean'

		        echo 'Compiling...'
		        sh 'mvn compile'

		        echo 'Packaging...'
		        sh 'mvn package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
		        sh 'mvn test'
            }
        }

	    stage('Install') {
		    steps {
			    echo 'Installing...'
			    sh 'mvn install -DskipTests'
		    }
	    }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
                echo "${env.JOB_NAME} ${env.BUILD_NUMBER}"
                sh 'cp ${env.WORKSPACE}/target/hateoas-example-*.jar /opt/deployments/hateoas-example.jar'
                echo 'ln -s /opt/deployments/hateoas-example.jar /etc/init.d/hateoas-example'
                echo 'Starting application...'
                echo 'service hateoas-example start'
            }
        }
    }
}
