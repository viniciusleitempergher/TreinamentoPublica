package exercicio02;

public class Nota {
	int codigoAluno;
	int codigoTurmaAluno;
	int codigoProva;
	double nota;
	
	public Nota(int codigoTurmaAluno, int codigoAluno, int codigoProva, double nota) {
		super();
		this.codigoAluno = codigoAluno;
		this.codigoProva = codigoProva;
		this.nota = nota;
		this.codigoTurmaAluno = codigoTurmaAluno;
	}
}
