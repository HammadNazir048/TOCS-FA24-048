pipeline {
    agent any

    environment {
        AZURE_SUBSCRIPTION_ID = credentials('azure-subscription-id')  // Azure subscription credentials
        AZURE_CLIENT_ID = credentials('azure-client-id')  // Azure Client ID
        AZURE_CLIENT_SECRET = credentials('azure-client-secret')  // Azure Client Secret
        AZURE_TENANT_ID = credentials('azure-tenant-id')  // Azure Tenant ID
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/your-username/your-repo.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Build your application (Example: Maven for Java)
                    sh 'mvn package'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Add unit and integration tests
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy to Azure') {
            steps {
                script {
                    // Login to Azure CLI
                    sh """
                        az login --service-principal -u ${AZURE_CLIENT_ID} -p ${AZURE_CLIENT_SECRET} -t ${AZURE_TENANT_ID}
                        az account set --subscription ${AZURE_SUBSCRIPTION_ID}
                    """

                    // Deploy application to Azure App Service
                    sh """
                        az webapp deployment source config-zip -g <resource-group> -n <app-name> -s <deployment-slot> -z target/my-app.zip
                    """
                }
            }
        }
    }

    post {
        success {
            echo "Deployment successful!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
