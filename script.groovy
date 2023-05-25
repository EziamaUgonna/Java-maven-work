def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerid', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t elvindavin4u/practice:v1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push elvindavin4u/practice:v1'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
