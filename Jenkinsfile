pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "ayyanpasha/calculator"
        VERSION = "latest"
    }

    stages {
        // Stage 1: Build the project with Maven
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        // Stage 2: Build and Push Docker Image
        stage('Build & Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credentials') {
                        def image = docker.build("${DOCKER_IMAGE}:${VERSION}")
                        image.push()
                    }
                }
            }
        }

        // Stage 3: Deploy with Ansible
        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini deploy.yml --extra-vars "docker_image=${DOCKER_IMAGE}:${VERSION}"'
            }
        }
    }

    post {
        always {
            cleanWs() // Clean workspace after build
        }
    }
}