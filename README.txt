Projet multimodule avec Maven

I) créer parent


--> créer projet 'quickstart' puis renommer le packaging en 'pom'


II) créer les modules


1) crée module domaine ('quickstart' )

2) crée module dao ('quickstart' )

3) crée module service ('quickstart' )

4) crée module présentation ('webapp')


III) Créer base de données  (???)


IV) Ajouter dépendances

1) dépendances du module domaine : aucune

2) dépendances du module dao : driver mysql jdbc 5.1.46 (+ domaine)

3) dépendances du module service : dao (+ domaine)

4) dépendances du module presentation : 
	service (+ domaine) + JSTL (1.2) + JSP (pas besoin)+ Servlet ()

!!Attention: supprimer ligne <scope>provided</scope>

V) Ajouter pages web (ecrans) : html/JSP + images + JS + CSS
Remplacer le contenu du repertoire 'webapp' par celui du 'WebContent' ancien

VI) Ajouter code des couches 
-dao:OK
-domaine:OK
-service: OK
-presentation: 
Rajouter repertoire java dans src/main, creer package,
 et copier les classes .java dedans: OK

 QUESTIONS
 Anciens imports?
 
 pb sur projets individuels mais pas sur multimodule...





VII) compiler  / Tester / packager / livrer

Lancer serveur sur module presentation

Maven
Goal: clean install package


Erreur compilation:
Try:
Sur "pom" parent, rajouter le compilateur suivant dans <properties>
	<maven.compiler.source>1.6</maven.compiler.source>
	<maven.compiler.target>1.6</maven.compiler.target>

Erreur page jstl: 
Try: eliminer la mention provided sur dependence jsp
	<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jsp-api</artifactId>
			<version>2.0</version>
		<!--	<scope>provided</scope> -->

Code original pour dependances:
		<!-- JSTL -->
		<dependency>
			<groupId>jstl</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
			 <scope>provided</scope> 
		</dependency>
		<!-- Servlet -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jsp-api</artifactId>
			<version>2.0</version>
			 <scope>provided</scope> 
		</dependency>
		<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
		<scope>provided</scope>
		</dependency>