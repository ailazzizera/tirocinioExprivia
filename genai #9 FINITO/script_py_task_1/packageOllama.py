import ollama
from fpdf import FPDF
import os

client = ollama.Client()

model = "mistral"  # Modifica questo per cambiare il modello
#prompt = "Come ti chiami?"
prompt = input("Prompt: ")

response = client.generate(model=model, prompt=prompt)

# Creo un oggetto PDF
pdf = FPDF()
pdf.add_page()
pdf.set_font("Arial", size=12)

pdf.multi_cell(0, 10, response.response)
pdf_file_name = "output.pdf"

# Salvo il PDF nella stessa directory dello script
script_directory = os.path.dirname(os.path.realpath(__file__))
pdf_file_path = os.path.join(script_directory, pdf_file_name)

pdf.output(pdf_file_path)
print(f"Risposta salvata nel file: {pdf_file_name}")
