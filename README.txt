Projet multimodule avec Maven

I) créer parent ('quickstart')

1 ) Editer pom.xml: renommer le packaging <packaging>jar</packaging> en <packaging>pom</packaging>

II) créer les modules

1) crée module 'domaine' ('quickstart' )

2) crée module 'dao' ('quickstart' )

3) crée module 'service' ('quickstart' )

4) crée module 'présentation' ('webapp')


III) Créer base de données  (???)


IV) Ajouter dépendances



1) dépendances du module domaine : aucune

2) dépendances du module dao : driver mysql jdbc 5.1.46 (+ domaine)

3) dépendances du module service : dao (+ domaine)

4) dépendances du module presentation : 
	service (+ domaine) 
	+ JSTL (1.2) + JSP (pas besoin)+ Servlet ()
		
4.0)['webapp']Verifier que le dossier 'Libraries' contient les libreries suivantes:
- ApacheTomcat 9.0 !!!!!!
- JRE (java 9)
- Maven dependencies: junit (par defaut)
- References libraries: jstl 1.2

4.1) JSTL 
		<!-- JSTL -->
		<dependency>
			<groupId>jstl</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
		
		!!Attention: verifier que la ligne <scope>provided</scope> est supprimée
		RQ. Observer que le fichier .jar est transferé du repertoire 'Referenced libraries' a 'Maven Dependencies'
		Le jar jstl 1.2 peut être supprimé du repertoire WEB-INF/lib de l'ancien projet
		
		
4.2) JSP: ne pas rajouté
		<!-- JSP -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jsp-api</artifactId>
			<version>2.0</version>
			<scope>provided</scope>
		</dependency>
		
4.3) Servlet
		<!-- Servlet: https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
		<scope>provided</scope>
		</dependency>	
		RQ. Observer que le fichier .jar apparait sur 'Maven Dependencies'

!!Attention: supprimer ligne <scope>provided</scope> si jamais la libraire n'est pas fournie aillerus

V) Ajouter pages web (ecrans) : html/JSP + images + JS + CSS
Remplacer le contenu du repertoire 'webapp' par celui du 'WebContent' ancien
Verifier que WEB-INF/lib n'existe plus et que les fichier .jsp marchent quand meme

VI) Ajouter code des couches 
-dao:OK
-domaine:OK
-service: OK
-presentation: 

Dans le cas d'un projet 'webapp'[VERIFIE]:
-Dans le repertoire 'src/main' du projet, creer un repertoire 'java' et un package 'presentation'
-Copier-coller la classe Servlet.java 
-Mettre à jour la declaration de package (package presentation)

Dans le cas d'un module 'webapp' dans un projet multimodule [NON-VERIFIE]:
-?

VII) compiler  / tester / executer 

Click droit sur root du projet parent + Run as> Java Application (si projet 'quickstart')
ou
Click droit sur root du projet parent + Run as> Run on Server (si projet 'webapp') et selectionner 'Tomcat'

ERREURS COMMUNS possibles:
-ERREUR de version de compilateur [RESOLUE]
-ERREUR de compilation de la JSTL [NON RESOLUE]


VIII) Packager / livrer
Click droit sur root du projet parent + Run as> 4 Maven build 
Introduire dans le champ 'Goals': 'clean install package' et clicker ensuite sur 'Run'

ERREURS COMMUNS possibles:
-ERREUR: aucun attribut manifest principal [RESOLUE]
-ERREUR: javax.servlet does not exist -> aller sur rajouter dependences 4.3) Servlet


Resolution ERREURS COMMUNNES

<!-- ===== ERREUR de version de compilateur ===== -->
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.1:compile (default-compile) on project monProjetQuickstart: Compilation failure: Compilation failure:
[ERROR] Source option 1.5 is no longer supported. Use 1.6 or later.
[ERROR] Target option 1.5 is no longer supported. Use 1.6 or later.
------------------------------------------------------
Solution: 
Editer les proprietes de pom.xml parent et rajouter le compilateur 1.6
------------------------------------------------------
<properties>
	<maven.compiler.source>1.6</maven.compiler.source>
	<maven.compiler.target>1.6</maven.compiler.target>
</properties>
<!-- =====================================-->

<!-- ===== ERREUR: aucun attribut manifest principal ==== -->
------------------------------------------------------
Solution: 
Editer la section build de pom.xml (parent?) pour rajouter le manifest
------------------------------------------------------
<!-- =====  Build ===== -->
    <build>
        <!-- Gestion des plugins (version) -->
        <pluginManagement>
            <plugins>
                <!-- Plugin responsable de la génération du fichier JAR -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-jar-plugin</artifactId>
                    <version>3.0.2</version>
                </plugin>
            </plugins>
        </pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <!-- Création du Manifest pour la définition de la classe Main -->
                        <manifest>
                            <mainClass>home.melomanab.monProjetQuickstart.App</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
<!-- =====================================-->



