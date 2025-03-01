pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/ayyanpasha/scientific-calculator.git'
        DOCKER_REGISTRY = 'docker.io'
        IMAGE_TAG = '0.0.1'
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }
        stage('Build and Test') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}:${IMAGE_TAG}", '.')
                    // Optionally, also tag the image as "latest" for consistency
                    docker.build("${DOCKER_IMAGE_NAME}:latest", '.')
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'DockerHubCred') {
                        // Tag the image with the appropriate version and latest
                        sh "docker tag ${DOCKER_IMAGE_NAME}:${IMAGE_TAG} ${DOCKER_REGISTRY}/ayyanpasha/scientific-calculator:${IMAGE_TAG}"
                        sh "docker tag ${DOCKER_IMAGE_NAME}:${IMAGE_TAG} ${DOCKER_REGISTRY}/ayyanpasha/scientific-calculator:latest"

                        // Push both the versioned tag and latest tag
                        sh "docker push ${DOCKER_REGISTRY}/ayyanpasha/scientific-calculator:${IMAGE_TAG}"
                        sh "docker push ${DOCKER_REGISTRY}/ayyanpasha/scientific-calculator:latest"
                    }
                }
            }
        }
        stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                    )
                }
            }
        }
    }
    post {
        success {
            echo 'Pipeline successfully completed!'
        }
        failure {
            echo 'Pipeline failed!'
            // Add failure notifications here (e.g., Slack, email)
        }
    }
}
