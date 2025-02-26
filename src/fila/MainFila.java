package fila;

public class MainFila {

	public static void main(String[] args) {
		//FILA DE INTEIROS COM VETOR
		FIlaVetor fv=new FIlaVetor(4);
		fv.enqueue(123);
		fv.enqueue(3);
		fv.enqueue(5);
		fv.enqueue(100);
		System.out.println(fv.front());
		
		
		
	}
}
