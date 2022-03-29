package Util;

import java.util.ArrayList;
import java.util.List;

import AlunoInfo.Aluno;

public class ListaAlunos {
	
	private static List<Aluno> listaAlunos = new ArrayList<Aluno>();
	
	public static List<Aluno> getInstance(){
		return listaAlunos;
				
	}
}
