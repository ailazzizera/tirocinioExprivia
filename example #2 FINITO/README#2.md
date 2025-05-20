# 2 - Creare le prime operazioni CRUD del sistema backend
Il codice è stato migliorato permettendo di effettuare operazioni CRUD sul database MongoDB. In particolare:
* **GET /api/assessments**  
  ➔ Recupera tutti gli assessment.

* **GET /api/assessments/{id}**  
  ➔ Recupera un assessment specifico tramite ID.

* **POST /api/assessments**  
  ➔ Crea un nuovo assessment.  
  ➔ Richiede un body JSON strutturato con `surveys`, `tools`, `engine`.

* **PUT /api/assessments/{id}**  
  ➔ Aggiorna un assessment esistente.

* **DELETE /api/assessments/{id}**  
  ➔ Elimina un assessment esistente dato il suo ID.


Il test delle API con **Postman** ha permesso di:

* Verificati tutti gli endpoint CRUD.
* Testare correttamente i casi di:
    - Inserimento (POST).
    - Modifica (PUT).
    - Lettura singola e multipla (GET).
    - Eliminazione (DELETE).

Per testare il corretto funzionamento, avviare il codice come presente nel **README#1**.
Accedere al sito *Postman* e creare una nuova collezione, importando il file *assessment.postman_collection.json*. Testare liberamente le API e verificarne correttamente il funzionamento con *STATUS 200* della request.

## Info 
Nel codice sono stati implementati anche i *dots* che permettono di preparare il programma a uno sviluppo futuro del frontend.
Ho utilizzato anche i *mapper* che servono per associare un ID a un oggetto seguendo l'approccio *DTO pattern*