package Faca;

import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import AlunoInfo.Aluno;
import AlunoInfo.Endereco;
import BancoDados.ManiArqXml;
import BancoDados.ManipulaTxt;
import Util.ListaAlunos;
import View.ViewCrudAluno;

public class CrudAluno {

	public static void SalvarAluno(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {

		Aluno aluno = new Aluno();
		Endereco endAluno = new Endereco();
		String[] dadosAluno = ViewCrudAluno.ViewMenuSalvarAluno(reader);

		aluno.setNome(dadosAluno[0]);
		aluno.setCpf(dadosAluno[1]);
		aluno.setCurso(dadosAluno[2]);
		endAluno.setRua(dadosAluno[3]);
		endAluno.setNum(Integer.parseInt(dadosAluno[4]));
		endAluno.setBairro(dadosAluno[5]);
		endAluno.setCidade(dadosAluno[6]);
		endAluno.setEstado(dadosAluno[7]);
		endAluno.setCep(Integer.parseInt(dadosAluno[8])); 
		aluno.setEndereco(endAluno);

		ListaAlunos.getInstance().add(aluno);
		
		ManipulaTxt.SalvaArquivoTxt();
		ManiArqXml.SalvarArqXml();
		
	} 

	public static void ListarAlunoSalvo() throws FileNotFoundException, IOException, ParserConfigurationException, TransformerException, SAXException {
	
		ListaAlunos.getInstance().clear();
		//ManipulaTxt.LerArquivoTxt();
		ManiArqXml.LerArquivoXML();
		ViewCrudAluno.ViewListaDeAlunosEditada();
		
	} 

	public static void DeletarAlunos(BufferedReader reader) throws NumberFormatException, ParserConfigurationException, TransformerException, IOException {
		
		int indice = ViewCrudAluno.ViewMenuEditarOuDeletarAluno("deletar", reader);
		
		ListaAlunos.getInstance().remove(indice);
		
		ManipulaTxt.SalvaArquivoTxt();
		ManiArqXml.SalvarArqXml();
	}

	public static void EditarAluno (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
		
		String[] dadosEditados = {"" , ""};
		int indice = ViewCrudAluno.ViewMenuEditarOuDeletarAluno("editar", reader);
		
		Aluno aluno = ListaAlunos.getInstance().get(indice);
		
		 dadosEditados = ViewCrudAluno.ViewOpcaoEdicao(reader);

		switch(Integer.parseInt(dadosEditados[0])) {
		case 1:
			aluno.setNome(dadosEditados[1]);
			break;
		case 2:
			aluno.setCpf(dadosEditados[1]);
			break;
		case 3:
			aluno.setCurso(dadosEditados[1]);
			break;
		case 4:
			aluno.getEndereco().setRua(dadosEditados[1]);
			break;
		case 5:
			aluno.getEndereco().setNum(Integer.parseInt(dadosEditados[1]));
			break;
		case 6:
			aluno.getEndereco().setBairro(dadosEditados[1]);
			break;
		case 7:
			aluno.getEndereco().setCidade(dadosEditados[1]);
			break;
		case 8:
			aluno.getEndereco().setEstado(dadosEditados[1]);
			break;
		case 9:
			aluno.getEndereco().setCep(Integer.parseInt(dadosEditados[1]));
			break;
		}

		ListaAlunos.getInstance().set(indice, aluno);
		ManipulaTxt.SalvaArquivoTxt();

	}
}