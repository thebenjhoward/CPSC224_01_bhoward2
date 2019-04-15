jar: clean
	javac Paralax.java
	jar -cmf Paralax.mf *.class

run-jar: jar
	java -jar Paralax.jar

class: clean
	javac Paralax.java
	java Paralax

rebuild: clean
	javac Paralax.java

clean:
	$(RM) *.class