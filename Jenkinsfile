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
                sh 'cp ${env.WORKSPACE}/target/*.jar /opt/deployments/hateoas-example.jar'
                sh 'ln -s /opt/deployments/hateoas-example.jar /etc/init.d/hateoas-example'
                echo 'Starting application...'
                sh 'service hateoas-example start'
            }
        }
    }
}
