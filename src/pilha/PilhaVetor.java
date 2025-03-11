package pilha;

public class PilhaVetor {
	
	public static int[] pilha=new int[5];
	public static int topo=0;
	
	public static boolean empty() {
		if(topo==0)
			return true;
		else
			return false;
	}
	
	public static int empilhar(int item) {
		if(topo==pilha.length)
			System.out.println("PILHA CHEIA");
		else
			pilha[topo++]=item;
		return item;
			
	}
	
	public static int desempilhar() {
		if(empty()) {
			System.out.println("PILHA VAZIA");
			return -1;
		}
		else
			return pilha[--topo];
		
	}
	public static void main(String[] args) {
		System.out.println("Vazia:"+empty());
		System.out.println("Topo:"+topo);
		
		System.out.println("Item:"+empilhar(23));
		System.out.println("Topo:"+topo);
		
		System.out.println("Item:"+empilhar(3));
		System.out.println("Topo:"+topo);
		
		System.out.println("Item:"+empilhar(2));
		System.out.println("Topo:"+topo);
		System.out.println("Item:"+empilhar(45));
		System.out.println("Topo:"+topo);
		
		System.out.println("Item:"+empilhar(56));
		System.out.println("Topo:"+topo);
		
		System.out.println("Item desempilhar:"+desempilhar());
		System.out.println("Topo:"+topo);
		
		System.out.println("Item:"+empilhar(90));
		System.out.println("Topo:"+topo);
		
		
		
		
		 
	}
}
