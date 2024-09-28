from flask import Flask, request, render_template
import pandas as pd

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/display', methods=['POST'])
def display_file():
    file = request.files['file']
    if not file:
        return "No file"

    # Tenta ler o arquivo com diferentes codificações
    try:
        df = pd.read_csv(file, delimiter=";")
    except UnicodeDecodeError:
        file.seek(0)  # Reseta o ponteiro do arquivo
        try:
            df = pd.read_csv(file, encoding='latin1', delimiter=";")
        except UnicodeDecodeError:
            file.seek(0)  # Reseta o ponteiro do arquivo
            df = pd.read_csv(file, encoding='ISO-8859-1', delimiter=";")

    # Renderiza o template com os dados do arquivo CSV
    return render_template('display.html', tables=[df.to_html(classes='data')], titles=df.columns.values)

if __name__ == '__main__':
    app.run(debug=True)