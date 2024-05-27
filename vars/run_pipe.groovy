def call(String message) {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    script {
                        echo 'Checking out code...'
                        // Git 리포지토리를 자격 증명과 함께 체크아웃
                        // checkout([
                        //     $class: 'GitSCM',
                        //     branches: [[name: '*/main']],
                        //     userRemoteConfigs: [[
                        //         url: 'https://your-git-repo-url/project-repo.git',
                        //         credentialsId: 'git-credentials-id'
                        //     ]]
                        // ])
                    }
                }
            }

            stage('Build') {
                steps {
                    echo 'Building the project...'
                    // 여기에 실제 빌드 스텝을 추가합니다. 예를 들어:
                    // sh 'make build'
                }
            }

            stage('Test') {
                steps {
                    echo 'Running tests...'
                    // 여기에 테스트 스텝을 추가합니다. 예를 들어:
                    // sh 'make test'
                }
            }

            stage('Deploy') {
                steps {
                    echo 'Deploying the application...'
                    // 여기에 배포 스텝을 추가합니다. 예를 들어:
                    // sh 'make deploy'
                }
            }
        }

        post {
            always {
                echo 'Cleaning up...'
                // 여기에 클린업 스텝을 추가합니다.
            }
            success {
                echo 'Pipeline succeeded!'
                echo "Message: ${message}"
            }
            failure {
                echo 'Pipeline failed!'
            }
        }
    }
}
