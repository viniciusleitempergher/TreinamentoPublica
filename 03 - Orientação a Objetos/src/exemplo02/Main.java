package exemplo02;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		// Instanciar objetos da classe curso
		Curso c1 = new Curso();
		c1.nome = "Java";
		c1.valor = 3000;
		
		Curso c2 = new Curso();
		c2.nome = "C#";
		c2.valor = 2850;
		
		Curso c3 = new Curso();
		c3.nome = "Angular";
		c3.valor = 1700;
		
		// ArrayList de cursos
		ArrayList<Curso> cursos = new ArrayList<>();
		cursos.add(c1);
		cursos.add(c2);
		cursos.add(c3);
		
		// Listar cursos
		for (int i = 0; i < cursos.size(); i++) {
			System.out.println(cursos.get(i).nome);
			System.out.println(cursos.get(i).valor);
			System.out.println(" --------------- ");
		}
	}
}
