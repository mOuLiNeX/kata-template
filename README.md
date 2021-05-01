# Template pour katas (Java version)

Projet Java/gradle(wrapper) avec bibliothèques JUnit5/AssertJ.

Pour lancer les tests en continu (pour pas relancer les tests manuellement à chaque fois)
```shell
./gradlew -t test
```

Couverture de code (tâche `jacocoTestReport`) et mutation testing (tâche `pitest`) sont également dispos.

**Pré-requis :** Java version 11+