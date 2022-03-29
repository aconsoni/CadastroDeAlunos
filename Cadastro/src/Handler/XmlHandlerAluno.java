package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import AlunoInfo.Aluno;
import AlunoInfo.Endereco;
import Util.ListaAlunos;

public class XmlHandlerAluno extends DefaultHandler {
	private StringBuilder texto;
	Aluno aluno;
	Endereco endereco;


		@Override
		public void startDocument() throws SAXException {
			System.out.println("Inicio do Documento");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("Fim do Documento");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if (qName.equals("Aluno")) {
				aluno = new Aluno();
				endereco = new Endereco();
			} else {
				texto = new StringBuilder();
				}
			}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equals("Nome")){
				aluno.setNome(texto.toString());
			}else if (qName.equals("Cpf")) {
				aluno.setCpf(texto.toString());
			}else if (qName.equals("Curso")) {
				aluno.setCurso(texto.toString());
			}else if (qName.equals("Rua")) {
				endereco.setRua(texto.toString());
			}else if (qName.equals("Num")) {
				endereco.setNum(Integer.parseInt(texto.toString()));
			}else if (qName.equals("Bairro")) {
				endereco.setBairro(texto.toString());
			}else if (qName.equals("Cidade")) {
				endereco.setCidade(texto.toString());
			}else if (qName.equals("Estado")) {
				endereco.setEstado(texto.toString());
			}else if (qName.equals("Cep")) {
				endereco.setCep(Integer.parseInt(texto.toString()));
				
				ListaAlunos.getInstance().add(aluno);
		
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			texto.append(ch, start, length);
			
		}

		@Override
		public void error(SAXParseException e) throws SAXException {
		}
}
