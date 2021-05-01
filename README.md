# Template pour katas (Kotlin version)

Projet Kotlin/gradle(wrapper) avec bibliothèque [kotest](https://kotest.io) ( sachant qu'un [plugin IntelliJ](https://plugins.jetbrains.com/plugin/14080-kotest) existe).

Plusieurs styles de TU sont proposés. Couverture de code (tâche `jacocoTestReport`) et mutation testing (tâche `pitest`) sont également dispos.

Pour lancer les tests en continu (pour pas relancer les tests manuellement à chaque fois)
```shell
./gradlew -t test
```

Couverture de code (tâche `jacocoTestReport`) et mutation testing (tâche `pitest`) sont également dispos.

**Pré-requis :** Java version 11+