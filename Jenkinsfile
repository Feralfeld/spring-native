pipeline {
  environment {
    imagename = "feralfeld/spring-native"
    clusterNamespace = "applications"
    registryCredential = 'feralfeld-dockerhub'
    appName = "spring-native"
    deployServiceName = "spring-native-service"
    servicePortName = "http"
    servicePort = "8080"
    deploymentName = "spring-native-deployment"
    nodePort = "32100"
    dockerImage = ''
    IMAGE = readMavenPom().getArtifactId()
    VERSION = readMavenPom().getVersion()
  }
    agent any
    tools {
        maven '3.8.5'
    }

    stages {

        stage('Docker Build'){
            steps{
            	sh "docker build -f Dockerfiles/Dockerfile -t feralfeld/jibber-benchmark:native.0.0.1-SNAPSHOT -m 5g ."
		        sh "docker login -u feralfeld -p ${variavel}"
             	sh "docker push feralfeld/${IMAGE}:${VERSION}"
           }
        }

	  stage ('Kubernetes Deploy') {
            steps {
                echo "Deploying yaml"
		        sh "sed -i 's|ImageName|${ImageName}:${VERSION}|' deployment.yaml"
            	sh """sed -i "s|NAMESPACE|${clusterNamespace}|" deployment.yaml"""
                sh """sed -i "s|APP|${appName}|" deployment.yaml"""
                sh """sed -i "s|SERVICENAME|${deployServiceName}|" deployment.yaml"""
                sh """sed -i "s|PORTNAME|${servicePortName}|" deployment.yaml"""
		    	sh """sed -i "s|NODEPORT|${nodePort}|" deployment.yaml"""
                sh """sed -i "s|PORT|${servicePort}|" deployment.yaml"""
                sh """sed -i "s|DEPLOYMENTNAME|${deploymentName}|" deployment.yaml"""
		    	echo "Deploying MODIFICADO"
		   	    sh "cat deployment.yaml"
                sh "/usr/bin/kubectl apply -f deployment.yaml"
	    }
        }

    }
}