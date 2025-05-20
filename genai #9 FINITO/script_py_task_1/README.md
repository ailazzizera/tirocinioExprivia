## Funzionamento
Vi sono 2 script Python:

1: *packageOllama.py* Questo script Python utilizza le librerie `ollama`, `fpdf` e `os` per generare automaticamente una risposta da un modello di intelligenza artificiale e salvarla in un file PDF.  
Nella prima parte, importa le librerie necessarie: `ollama` per comunicare con il modello AI, `fpdf` per creare documenti PDF e `os` per gestire i percorsi dei file.  

Viene quindi creato un client Ollama, definito il modello da usare (in questo caso “mistral”) e il prompt da inviare al modello (“Come ti chiami?”).  
Il client invia la richiesta e riceve una risposta, che viene salvata in una variabile.  

Successivamente, viene creato un oggetto PDF con `FPDF`, aggiunta una pagina, impostato il font, e scritta la risposta del modello nel PDF.  
Infine, lo script determina la directory in cui si trova il file `.py`, costruisce il percorso completo per il file PDF di output, lo salva con nome `output.pdf` e stampa a schermo un messaggio di conferma che indica che la risposta è stata salvata correttamente.  

2: *HTTPapi.py* Questo script Python interagisce con un server locale di Ollama tramite la sua API HTTP per inviare un messaggio al modello AI 'mistral' e salvare la risposta in un file PDF. Innanzitutto, definisce l’endpoint API http://localhost:11434/api/chat e prepara un payload JSON contenente un messaggio da parte dell’utente scritto nel codice o preso da input. 

Effettua una richiesta POST a quell’URL e, se la risposta è positiva (status_code == 200), crea un oggetto PDF (FPDF), aggiunge una pagina, imposta il font, e inizia a leggere la risposta riga per riga (in modalità streaming). Ogni riga viene trattata come una stringa JSON che contiene un campo message con un content, ovvero il testo generato dal modello. 

Questo contenuto viene sia stampato a video che scritto nel pdf. Una volta completata la lettura della risposta, il testo viene scritto nel PDF tramite multi_cell, e il file viene salvato nella stessa cartella dello script. Se invece la risposta dal server non è 200, stampa l’errore.
