pipeline{
  agent any
  stages{
    stage("Checkout"){
      steps{
        checkout scm
      }
    }
    stage("Build"){
      steps{
       bat 'mvn clean'
      }
    }
    stage("Test"){
      steps{
       bat 'mvn test'
      }
    }
    stage("SonarQube"){
      steps{
        withSonarQubeEnv("SonarQube_GlobalConfiguration"){
          bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121:sonar"
        }
      }
    }
    stage("Upload to Artifactory"){
      steps{
        rtMavenDeployer(
            id:'deployer',
            serverId:'3143322@artifactory',
            releaseRepo:'Ashok_nagp2024',
            snapshotRepo:'Ashok_nagp2024'
        )
        rtMavenRun(
            pom:'pom.xml',
            goals: 'clean install',
            deployerId: 'deployer'
        )
        rtPublishBuildInfo(
            serverId:'3143322@artifactory'
        )
      }
    }
  }
  post {
        always {
            echo 'This will always run after the stages complete.'
        }
        success {
            echo 'Build was successful!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}