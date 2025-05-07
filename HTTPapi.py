import requests
import json
from fpdf import FPDF  # Import FPDF for PDF generation
import os  # Import os to handle file paths

# Set up the base URL for the local Ollama API
url = "http://localhost:11434/api/chat"

# Define the payload (your input prompt)
payload = {
    "model": "mistral",  # Replace with the model name you're using
    "messages": [{"role": "user", "content": "What are you able to do?"}]
}

# Send the HTTP POST request with streaming enabled
response = requests.post(url, json=payload, stream=False)

# Check the response status
if response.status_code == 200:
    print("Streaming response from Ollama:")
    pdf = FPDF()  # Create a PDF object
    pdf.add_page()
    pdf.set_font("Arial", size=12)
    output_text = ""  # Collect all output text

    for line in response.iter_lines(decode_unicode=False):
        if line:  # Ignore empty lines
            try:
                # Parse each line as a JSON object
                json_data = json.loads(line)
                # Extract and print the assistant's message content
                if "message" in json_data and "content" in json_data["message"]:
                    content = json_data["message"]["content"]
                    print(content, end="")
                    output_text += content  # Append content to output_text
            except json.JSONDecodeError:
                print(f"\nFailed to parse line: {line}")
    print()  # Ensure the final output ends with a newline

    # Write the collected text to the PDF
    pdf.multi_cell(0, 10, output_text)
    output_path = os.path.join(os.path.dirname(__file__), "outputHTTP.pdf")  # Save in the same folder
    pdf.output(output_path)  # Save the PDF to a file
    print(f"Risposta salvata su {output_path}")
else:
    print(f"Error: {response.status_code}")
    print(response.text)