import ollama
from fpdf import FPDF

client = ollama.Client()

model = "tinyllama"
prompt = input("Prompt: ")

response = client.generate(model=model, prompt=prompt)

# Create a PDF document
pdf = FPDF()
pdf.add_page()
pdf.set_font("Arial", size=12)
# Add a cell with the response text
pdf.multi_cell(0, 10, response.response)
# Save the PDF to a file
pdf_file_name = "output.pdf"
pdf.output(pdf_file_name)
print(f"Response saved to {pdf_file_name}")
