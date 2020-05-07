import java.util.Random;

class Celula
{
	public int elemento;
	public Celula prox;
	
	public Celula()
	{
		elemento = 0;
		prox = null;
	}

	public Celula(int x)
	{
		elemento = x;
		prox = null;
	}

}

class Pilha
{
	private Celula topo;

	//Construtor Padrao	
	public Pilha()
	{
		topo = null;
	}

	/*
	*Construtor Alternativo
	*Param tam: tamanho inicial da pilha
	*/
	public Pilha(int tam) throws Exception
	{
		if(tam <= 0)
		{
			throw new Exception("Erro! Tamanho inválido");
		}
		else
		{
			Random gerador = new Random();
			int x = 0;
			
			topo = null;
				
			for(int i = 0; i < tam; i++)
			{
				x = gerador.nextInt();				
					
				Celula tmp = new Celula(x);
				tmp.prox = topo;
				topo = tmp;
				tmp = null;
			}
		

		}
	}


	/*
	*Metodo para inserir elementos na pilha
	*@param x : valor a ser inserido na pilha
	*/	
	public void inserir(int x)
	{
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}


	/*
	*Funcao para remover elemento da pilha
	*@return : elemento removido
	*/
	public int remover () throws Exception
	{
		
		if (topo == null)
		{		
			throw new Exception("ERRO");
		}		
		int removido = 0;		
			
		Celula tmp = topo;

		removido = topo.elemento;

		topo = topo.prox;

		tmp.prox = null;

		tmp = null;

		return removido;
	}

	/*
	*Metodo para mostrar na tela os elementos da pilha
	*/
	public void mostrar() throws Exception
	{
		if (topo == null)
		{
			throw new Exception("Erro Pilha");
		}

		System.out.print("[ ");

		for(Celula i = topo; i!= null; i = i.prox)
		{
			System.out.print(i.elemento+" ");
		}
		
		System.out.println("]");
	}

	
	//Encapsulamento do metodo MostrarOrdRemocao
	public void mostrarRemocaoRecursivo() throws Exception
	{
		if(topo == null)
		{
			throw new Exception("Erro pilha vazia");
		}

		System.out.print("[ ");
		mostrarOrdRemocao(topo);
		System.out.println("]");
	}

	/*
	*Metodo recursivo para mostrar os elementos da pilha na ordem de remoção
	*@param i : contador da recursao
	*/
	private void mostrarOrdRemocao(Celula i)
	{
		if(i != null)
		{
			System.out.print(i.elemento+" ");
			mostrarOrdRemocao(i.prox);
		}
	
	}

	
	//Encapsulamento do metodo mostrarOrdInserido
	public void mostrarInseridoRecursivo()
	{
		System.out.print("[ ");
		mostrarOrdInserido(topo);
		System.out.println("]");
	}
	
	/*
	*Metodo recursivo para mostrar os elementos da pilha na ordem em que foram inseridos
	*@param i : contador da recursao
	*/
	private void mostrarOrdInserido(Celula i)
	{
		if(i != null)
		{
			mostrarOrdInserido(i.prox);
			System.out.print(i.elemento+" ");
		}
	
	}

	
	/*
	*Metodo iterativo para mostrar os elementos da pilha na ordem em que foram inseridos na pilha
	*/
	public void mostrarInserido() throws Exception
	{
		if(topo == null)
		{
			throw new Exception("Erro pilha vazia");
		}

		Celula i;
		Celula j = null;

		for (i=topo; i.prox != null; i = i.prox);
		
		System.out.print("[ ");	
	
		while (i != topo)
		{
			for(j = topo; j.prox != i; j = j.prox);
					
			System.out.print(i.elemento+" ");
			i = j;
			
			if(i == topo)
			{
				System.out.print(i.elemento+" ");
			}
		}
	
		System.out.println("]");	
	}

	/*
	*Funcao para somar os elementos da lista
	*@return : a soma dos elementos da lista
	*/
	public int soma() throws Exception
	{
		if(topo == null)
		{
			throw new Exception("Erro pilha vazia");
		}

		int soma = 0;

		for(Celula i = topo; i != null; i = i.prox)
		{
			soma += i.elemento;
		}

		return soma;
	}

	//encapsulamento da funcao somaRecursiva
	public int somaRecursiva() throws  Exception
	{
		if(topo == null)
		{
			throw new Exception("Erro pilha vazia");
		}

		return somaRecursiva(topo);
	}

	/*
	*Funcao recursiva para somar os elementos da lista
	*@param i : contador da recursao	
	*@return : a soma dos elementos da lista
	*/
	private int somaRecursiva(Celula i)
	{
		int soma = 0;
		if(i != null)
		{
			soma = i.elemento + somaRecursiva(i.prox);
		}

		return soma;
	}

	
	/*
	*Funcao para mostrar o maior elemento presente na pilha
	*/
	public int maiorElemento () throws Exception
	{
		if(topo == null)
		{
			throw new Exception("Erro pilha vazia");
		}

		int maior = topo.elemento;

		for (Celula i = topo.prox; i != null; i=i.prox)
		{
			if(i.elemento > maior)
			{
				maior = i.elemento;	
			}
			
		}
	
		return maior;	
	}

	//Encapsulamento da funcao maiorElementoR()
	public int maiorElementoR() throws Exception
	{
		if(topo == null)
		{
			throw new Exception("Erro pilha vazia");
		}
		return maiorElementoR(topo);
	}
	
	/*
	*Funcao recursiva para identificar o mair elemento da pilha
	*@param i : Controle da recursão
	*/
	public int maiorElementoR(Celula i)
	{
		int maior = 0;
		if(i != null)
		{
			maior = maiorElementoR(i.prox);
			
			if(i.elemento > maior)
			{
				maior = i.elemento;
			}
		}
		return maior;
	}
	
}

public class pilhaF
{
	public static void main(String [] args) throws Exception
	{
		Pilha pilha = new Pilha();
	
		for (int i = 10; i > 0; i--)
		{
			pilha.inserir(i);
		}
		
		pilha.mostrar();

		System.out.println("soma: "+pilha.soma());
		System.out.println("soma recursiva: "+pilha.somaRecursiva());
		System.out.println("maior: "+pilha.maiorElemento());
		System.out.println("maior recursivo: "+pilha.maiorElementoR());
		
		pilha.mostrarRemocaoRecursivo();
		System.out.println("Removido "+pilha.remover());
		System.out.print("Mostrar de forma Recursiva: ");		
		pilha.mostrarInseridoRecursivo();
		System.out.print("Mostrar de forma Iterativa: ");	
		pilha.mostrarInserido();

	}


}
