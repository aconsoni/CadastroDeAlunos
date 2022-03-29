package AlunoInfo;

public class Aluno {
	
	//INFORMA��ES SOBRE O ALUNO
	private String nome;
	private String cpf;
	private String curso;
	private Endereco endereco;

	public Aluno() {	
	}
	
	public Aluno(String dados) {
				
		String[] atributos = dados.split(",");
	
		String[] nome = atributos[1].split("=");
		String[] cpf = atributos[2].split("=");
		String[] curso = atributos[3].split("=");
		
		Endereco endeAlu = new Endereco(atributos);
		
		this.nome = nome[1].trim();
		this.cpf = cpf[1].trim();
		this.curso = curso[1].trim();
		this.endereco = endeAlu;
				
	}
	
	//SET E GET PARA CADA ATRIBUTO
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Aluno, " +"Nome =  " + nome + ", CPF= " + cpf + ", Curso= " + curso + ", Endere�o= " + endereco ;
	} 
	
}