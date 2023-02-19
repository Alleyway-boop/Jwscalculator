pipeline{
    agent any
    stages{
        stage('编译源码') {
            steps {
                powershell '''mkdir target
		    cd target
                    mkdir classes
                    cd ..\\src\\main\\java
		            javac gitops\\jwscalculator\\*.java -d ..\\..\\..\\target\\classes'''
            }
        }
        stage('生成jar ') {
            steps {
                powershell '''cd target\\classes
		    jar cfe jwscalculator.jar gitops.jwscalculator.JwsCalculator gitops'''
            }
        }
        stage('生成密钥'){
            steps{
                powershell '''cd target\\classes
		    keytool -genkey -alias mykey -keystore mykeystore.pfx -storetype PKCS12 -keyalg RSA -storepass mystorepass  -validity 365 -keysize 2048 -dname "CN=liudongliang, OU=chzu, L=xxxy, S=chuzhou, O=anhui, C=CH"'''
            }
        }
        stage('签名jar') {
            steps {
                powershell '''cd target\\classes
		    jarsigner -keystore myKeystore.pfx jwscalculator.jar mykey -storepass mystorepass
		    move jwscalculator.jar ..\\..\\src\\main\\webapp'''
            }
        }

        stage('打包War') {
            steps {
		   powershell '''cd src\\main\\webapp
		      jar cfM jwscalculator.war  *'''
            }
        }
        stage('部署tomcat'){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:8080')], contextPath: '/jwscalculator', war: 'src/main/webapp/jwscalculator.war'
            }
        }
        stage('本地运行jar'){
            steps{
                powershell '''cd src\\main\\webapp
		   java -jar jwscalculator.jar'''
            }
        }
        stage('本地运行jnlp'){
            steps{
                powershell '''cd src\\main\\webapp
		   javaws jwscalculator.jnlp'''
            }
        }
        stage('WebStart'){
            steps{
                powershell 'explorer http://localhost:8080/jwscalculator/index.html'
            }
        }
        stage('清除'){
            steps{
                powershell '''Remove-Item target -Recurse
		    cd src\\main\\webapp
                    del jwscalculator.jar
                    del jwscalculator.war'''
            }
        }
    }
}
