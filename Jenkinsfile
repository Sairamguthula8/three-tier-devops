pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
    }

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/your-username/three-tier-devops-project.git'
            }
        }

        stage('Build Backend') {
            steps {
                dir('backend') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                sh '''
                    docker build -t yourdockerhub/backend:latest backend/
                    docker build -t yourdockerhub/frontend:latest frontend/
                    echo "$DOCKERHUB_CREDENTIALS_PSW" | docker login -u "$DOCKERHUB_CREDENTIALS_USR" --password-stdin
                    docker push yourdockerhub/backend:latest
                    docker push yourdockerhub/frontend:latest
                '''
            }
        }

        stage('Deploy to K8s') {
            steps {
                sh '''
                    kubectl apply -f k8s/mysql-deployment.yaml
                    kubectl apply -f k8s/backend-deployment.yaml
                    kubectl apply -f k8s/frontend-deployment.yaml
                '''
            }
        }
    }
}

