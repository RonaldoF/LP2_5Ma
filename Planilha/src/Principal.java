import java.util.Scanner;
import static java.lang.System.*;

public class Principal {
	public static void main(String[] args) {
		Planilha obj = new Planilha('j',100);
		Scanner ler = new Scanner(in);
		String x;
		boolean sair = false;
		
		while(true)
		{
			//char + int
			out.println("Celula a ser alterada: ");
			x = ler.next();
			//scanner comando sair, fim do while
			if (x.equalsIgnoreCase("sair")) break;
			//entrada do char da celula, modifica para maiusculo
			char n1 = Character.toUpperCase(x.charAt(0));
			//valor de entrada do x é convertido para inteiro
			int n2 = Integer.parseInt(x.substring(1));
			//cria objeto valor de celula com 2 parametros de entrada char + int
			Celula valor = obj.getValor(n1,n2);
			//se valor é diferente de null, verifica se há valor senão vazio
			String formula = valor != null ? valor.getFormula() : "(Vazio)";
			//informa o valor da celula
			out.println("-- Valor atual da célula "+ x+": "+ formula +"--");
			//insere um novo valor
			out.println("Insira novo valor: "+x+"=");
			x = ler.next();
			//o obj da classe planilha acessa o metodo setvalor que pega o char int valor
			obj.setValor(n1, n2, x);
			
			if (x.equalsIgnoreCase("sair")) break;
		} 	
		
		out.println("Fim");
	}
	
	
}