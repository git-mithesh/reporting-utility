node {
	def app
	
	stage('Clone Repository'){
	checkout scm
	}
	stage('Compile-Package'){
	def mvnHome=tool name: 'maven3.6.3', type: 'maven'
	sh "${mvnHome}/bin/mvn package"
	}
	stage("Build image"){
	app=docker.build("mitheshjain88/reporting-utility")
	}
	stage('Test image'){
	app.inside{
	echo "Test passed"
	}
	}
	stage('Push image'){
	docker.withRegistry('https://registry.hub.docker.com','dockerHub'){
	app.push("${env.BUILD_NUMBER}")
	app.push("latest")
	}
	echo "Trying to push Docker build to Docker hub"
	}
	}