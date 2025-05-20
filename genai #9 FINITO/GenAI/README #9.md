# 2. GenAI - modello locale per reportistica TEC

Il task 2 mi richiede di utilizzare un modello AI in locale e di inviare un messaggio tramite prompt e facendomi restituire la risposta in formato *JSON*

Per questo codice ho utilizzato semplici richieste HTTP e RestClient.
Il modello scelto, gira in locale, su porta 11434.
Il backend gira su porta 8080.

Il codice:
- Espone un'API REST su `/api/ai/prompt` per ricevere richieste HTTP `POST`.
- Accetta un JSON in input con il campo `prompt` (la domanda da porre al modello).
- Utilizza `ObjectMapper` per creare in sicurezza il JSON da inviare al modello, evitando problemi di sicurezza come la **JSON Injection**.
- Invia la richiesta HTTP POST a `http://localhost:11434/api/generate` (API del modello Ollama).
- Riceve la risposta e la deserializza in un oggetto `OllamaResponse`.
- Restituisce la risposta al client nel formato JSON specificato:
```json
{ 
"risposta": "..." 
}
```
* Gestisce i casi di errore: se la risposta di Ollama è *null*, restituisce "Errore nella generazione della risposta.".

Aggiunto un *.json* che facilita il test su *Postman*