package BancoDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import AlunoInfo.Aluno;
import Util.ListaAlunos;

public class ManipulaTxt {
	
	private static String NomeDoArquivo = "CadastroDeAluno.txt";
	
	public static void SalvaArquivoTxt() throws IOException {
		
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(NomeDoArquivo));
				PrintWriter pw = new PrintWriter(buffer)) {
			for (Aluno a : ListaAlunos.getInstance())
			pw.println(a);
		} 
	}
	
	public static void LerArquivoTxt() throws IOException {
		
		try (FileWriter arquivo = new FileWriter(NomeDoArquivo, true)) {}
		
		String line;

		try (BufferedReader reader = new BufferedReader(new FileReader(NomeDoArquivo))) {

			while ((line = reader.readLine()) != null && !"".equals(line)) {
				Aluno aluno = new Aluno(line);
				ListaAlunos.getInstance().add(aluno);
				
				} 
			}
		} 
									
	}