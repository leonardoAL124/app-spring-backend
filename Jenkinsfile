node{
    stage('Clonar repositorio'){
        git 'https://github.com/leonardoAL124/integracion-spring2'
    }
    
    stage('Limpieza'){
        bat 'D:\\servidor\\apache-maven-3.9.8\\bin\\mvn.cmd clean'
    }
    
    stage('Construir'){
        bat 'D:\\servidor\\apache-maven-3.9.8\\bin\\mvn.cmd package'
    }
}