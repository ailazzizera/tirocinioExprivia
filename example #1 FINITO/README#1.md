# 1 - Creazione di un backend
1 - In questo push, ho utilizzato il framework 'SprintgBoot' per la creazione del backend. Questo contiene un database NOSQL, MongoDB. Per avviare e testare il corretto funzionamento, avviare nella cartella del progetto, denominata 'example' il container che eseguirà l'istanza di MongoDB con il comando:

```bash
docker-compose up
```

2 - Dopo che il container è stato avviato, aprire il progetto con IDE 'IntellIJ' e spostarsi nella classe *App.class*. Effettuare il run del backend cliccando il tasto esegui presente accanto al nome della classe. 


3 - Infine per verificare il corretto funzionamento, è stato creato un test case presente nel file *test/AppTest.class*. Da terminale, eseguire il comando: 

3 - Infine per verificare il corretto funzionamento, da terminale, eseguire il comando: 

```bash
mvn test
```
Questo verificherà con dati di esempio presenti nella classe di test *test/AppTest.class* il corretto funzionamento del db e la corretta implementazione di tutte le entità presenti.
