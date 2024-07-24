node{
    tools{
        Maven
    }
    stage('Limpiar'){
        bat 'mvn clean install'
    }
    stage('Crear'){
        bat 'mvn clean package'
    }
}