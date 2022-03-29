package View;

import java.io.BufferedReader;
import java.io.IOException;
import AlunoInfo.Aluno;
import Util.ListaAlunos;

public class ViewCrudAluno {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException {
		
		System.out.println("1 - Cadastrar Alunos\n"
						+ "2 - Listar Alunos\n"
						+ "3 - Deletar Alunos\n"
						+ "4 - Editar Alunos\n"
						+ "5 - Sair");

		return Integer.parseInt(reader.readLine());	
	}
	
	public static String[] ViewMenuSalvarAluno(BufferedReader reader) throws IOException {
		String[] menuAluno = {"Nome do Aluno", "CPF", "Curso","Endere�o: \n Rua",
									"N�mero","Bairro","Cidade", "Estado", "CEP"};
		String[] dadosAluno = {"","","","","","","","",""};
		
		for(int i=0; i < menuAluno.length; i++) {
			System.out.println(menuAluno[i]);
			dadosAluno[i] = reader.readLine();			
		}
			
		return dadosAluno;
	}
	
	public static int ViewMenuEditarOuDeletarAluno(String editar_deletar,BufferedReader reader) throws NumberFormatException, IOException {		

		for (int i = 0; i < ListaAlunos.getInstance().size(); i++)
			System.out.println(i + " - " + ListaAlunos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja "+ editar_deletar);
						
		return Integer.parseInt(reader.readLine());
	}

	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws IOException {
		
		String[] dadosEditados = {"" ,""};
		
		System.out.println("Escolha o atributo que deseja alterar:");
		System.out.println("1 - Nome\n"
				+ "2 - CPF\n"
				+ "3 - Rua\n"
				+ "4 - N�mero\n"
				+ "5 - Bairro\n"
				+ "6 - Cidade\n"
				+ "7 - Estado\n"
				+ "8 - CEP\n");
		
		dadosEditados[0] = reader.readLine();
		System.out.println("Escreva o novo valor do atributo");
		dadosEditados[1] = reader.readLine();
		
		return dadosEditados;
	}
	
	public static void ViewListaDeAlunosEditada() {
		
		for (Aluno a : ListaAlunos.getInstance()) {
			System.out.println("ALUNO");
			System.out.println("Nome = " + a.getNome());
			System.out.println("CPF = " + a.getCpf());
			System.out.println("Rua = " + a.getEndereco().getRua());
			System.out.println("N�mero = " + a.getEndereco().getNum());
			System.out.println("Bairro = " + a.getEndereco().getBairro());
			System.out.println("Cidade = " + a.getEndereco().getCidade());
			System.out.println("Estado = " + a.getEndereco().getEstado());
			System.out.println("CEP = " + a.getEndereco().getCep());
			
		}
		
		System.out.println();
		
	}
		public static void ViewMsgFim(int op) {
			
			String[] msgFinal = {"Aluno salvo com sucesso!!",
									"Aluno editado com sucesso!!",
									"Aluno deletado com sucesso!!",
									"Fim do Programa!!"};
			
			System.out.println(msgFinal[op]);
		}
			
}
