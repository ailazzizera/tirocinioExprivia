## Funzionamento
Vi sono 2 script Python:

1: Questo script Python utilizza le librerie `ollama`, `fpdf` e `os` per generare automaticamente una risposta da un modello di intelligenza artificiale e salvarla in un file PDF.  
Nella prima parte, importa le librerie necessarie: `ollama` per comunicare con il modello AI, `fpdf` per creare documenti PDF e `os` per gestire i percorsi dei file.  

Viene quindi creato un client Ollama, definito il modello da usare (in questo caso “mistral”) e il prompt da inviare al modello (“Come ti chiami?”).  
Il client invia la richiesta e riceve una risposta, che viene salvata in una variabile.  

Successivamente, viene creato un oggetto PDF con `FPDF`, aggiunta una pagina, impostato il font, e scritta la risposta del modello nel PDF.  
Infine, lo script determina la directory in cui si trova il file `.py`, costruisce il percorso completo per il file PDF di output, lo salva con nome `output.pdf` e stampa a schermo un messaggio di conferma che indica che la risposta è stata salvata correttamente.  
