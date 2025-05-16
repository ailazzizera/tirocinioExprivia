# 2. GenAI - modello locale per reportistica TEC

Il task 2 mi richiede di utilizzare un modello AI in locale e di inviare un messaggio tramite prompt e facendomi restituire la risposta in formato *JSON*

Per questo codice ho utilizzato semplici richieste HTTP.
Il modello scelto, gira su un container *Docker*.

Il codice:
* Spring Boot riceve il prompt via HTTP POST.
* Usa WebClient per inviare una HTTP POST diretta a Ollama: http://localhost:11434/api/generate.
* Elabora la risposta JSON ricevuta da Ollama.
* Restituisce solo il campo *response* in formato JSON.

Per testare il corretto funzionamento, effettuare una richiesta POST su *Postman* all'[API](http://localhost:8080/api/ai/prompt)

Il prompt deve essere del tipo: 

```bash
{
  "prompt": "Quanti abitanti vivono a Molfetta?"
}
```
Inviata la POST, la risposta ricevuta sarà del tipo:

```bash
{
    "risposta": "Ci sono 58.305 abitanti a Molfetta nel 2021."
}
```

È possibile modificare il modello nel controller.

