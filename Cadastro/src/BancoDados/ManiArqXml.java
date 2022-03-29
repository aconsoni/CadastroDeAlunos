package BancoDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import AlunoInfo.Aluno;
import Handler.XmlHandlerAluno;
import Util.ListaAlunos;

public class ManiArqXml {

	public static String nomeDoArquivo = "CadastroDeAluno.xml";

	public static void SalvarArqXml() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element alunoTag = doc.createElement("Alunos");

		doc.appendChild(alunoTag);

		for(Aluno a: ListaAlunos.getInstance()) {
			Element alunosTag = doc.createElement("Aluno");
			alunoTag.setAttribute("ID", "1");
			alunosTag.appendChild(alunoTag);

			Element nomeTag = doc.createElement("Nome");
			nomeTag.setTextContent(a.getNome());
			alunoTag.appendChild(nomeTag);

			Element cpfTag = doc.createElement("CPF");
			cpfTag.setTextContent(a.getCpf());
			alunoTag.appendChild(cpfTag);

			Element cursoTag = doc.createElement("Curso");
			cursoTag.setTextContent(a.getCurso());
			alunoTag.appendChild(cursoTag);
			
					//ENDERECO 
					Element endTag = doc.createElement("Endereço");
					alunoTag.appendChild(endTag);
		
					Element ruaTag = doc.createElement("Rua");
					ruaTag.setTextContent(a.getEndereco().getRua());
					endTag.appendChild(ruaTag);
		
					Element numTag = doc.createElement("Número");
					numTag.setTextContent(String.valueOf(a.getEndereco().getNum()));
					endTag.appendChild(numTag);
		
					Element bairroTag = doc.createElement("Bairro");
					bairroTag.setTextContent(a.getEndereco().getBairro());
					endTag.appendChild(bairroTag);
		
					Element cidadeTag = doc.createElement("Cidade");
					cidadeTag.setTextContent(a.getEndereco().getCidade());
					endTag.appendChild(cidadeTag);
		
					Element estadoTag = doc.createElement("Estado");
					estadoTag.setTextContent(a.getEndereco().getEstado());
					endTag.appendChild(estadoTag);
		
					Element cepTag = doc.createElement("Cep");
					cepTag.setTextContent(String.valueOf(a.getEndereco().getCep()));
					endTag.appendChild(cepTag);

		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();

		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4" );

		DOMSource source = new DOMSource(doc);

		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo), "ISO-8859-1")) {
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);		
		}

	}
	
public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		
		SAXParserFactory spf =  SAXParserFactory.newInstance();		
		SAXParser parser = spf.newSAXParser();
		
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")){
			InputSource source =  new InputSource(isr);
			XmlHandlerAluno handler = new XmlHandlerAluno();			
			parser.parse(source, handler);	
		}
		
	}


}
