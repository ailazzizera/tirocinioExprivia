import requests
import json
from fpdf import FPDF  
import os

# URL per la richiesta POST. Controlla che il server Ollama sia in esecuzione su questa porta o avvialo con: ollama serve mistral
url = "http://localhost:11434/api/chat"

payload = {
    "model": "mistral",  # Modifica questo per cambiare il modello
    "messages": [{"role": "user", "content": "What are you able to do?"}]
}

# Invia una richiesta POST al server Ollama
response = requests.post(url, json=payload, stream=False)

# Check the response status
if response.status_code == 200:
    print("Streaming response from Ollama:")
    pdf = FPDF() 
    pdf.add_page()
    pdf.set_font("Arial", size=12)
    output_text = "" 

    for line in response.iter_lines(decode_unicode=False):
        if line:
            try:
                # Ogni linea è un JSON, quindi dobbiamo decodificarla
                json_data = json.loads(line)
                # Stampa anche il messaggio su terminale (Possibile anche eliminarlo)
                if "message" in json_data and "content" in json_data["message"]:
                    content = json_data["message"]["content"]
                    print(content, end="")
                    output_text += content
            except json.JSONDecodeError: # Se non riesce a decodificare la linea, stampa un messaggio di errore
                print(f"\nFailed to parse line: {line}")
    print()

    pdf.multi_cell(0, 10, output_text)
    output_path = os.path.join(os.path.dirname(__file__), "outputHTTP.pdf")  # Salva il PDF nella stessa cartella dello script
    pdf.output(output_path)
    print(f"Risposta salvata su {output_path}")
else:
    print(f"Error: {response.status_code}")
    print(response.text)