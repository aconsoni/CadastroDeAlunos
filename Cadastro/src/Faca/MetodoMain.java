package Faca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import View.ViewCrudAluno;

public class MetodoMain {
	
	public static void main (String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {

		BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));

		int menu = 0;
		while (menu != 5) {
			menu = ViewCrudAluno.ViewMenuPrincipal(reader);	
				switch (menu) {
				case 1:
					CrudAluno.SalvarAluno(reader);
					break;
				case 2:
					CrudAluno.ListarAlunoSalvo();
					break;
				case 3:
					CrudAluno.DeletarAlunos(reader);
					break;
				case 4:
					CrudAluno.EditarAluno(reader);
					break;
				case 5:
					ViewCrudAluno.ViewMsgFim(3);
					break;
			}
		}
	}
}