pipeline {
    agent any
    tools {
        maven 'Maven-3'
    }
    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Fetching Code') {
            steps {
                git branch: 'dockerBranch', credentialsId: 'f869616e-bac6-4fff-bcf5-51b644c05ffe', url: 'https://github.com/akreddy051/redis-docker.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh '''
      export PATH="/Applications/Docker.app/Contents/Resources/bin:/usr/local/bin:$PATH"
      docker build -t testdocker .
    '''
            }
        }
        stage('Start Redis') {
            steps {
                sh '''
          export PATH="/Applications/Docker.app/Contents/Resources/bin:/usr/local/bin:$PATH"

          docker network create domp-network || true

          docker ps | grep redis || docker run -d \
            --name redis \
            --network domp-network \
            -p 6379:6379 \
            redis
        '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
          export PATH="/Applications/Docker.app/Contents/Resources/bin:/usr/local/bin:$PATH"
          docker stop testdocker || true
          docker rm testdocker || true
          docker run -d -p 12000:12000 --network domp-network --name testdocker testdocker
        '''
            }
        }
    }
}
