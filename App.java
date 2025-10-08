import java.util.Scanner;

public class App
{
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nome, cartaoCheck = " ";
		boolean erroTentativa;
		int idade, contaminado = 0, contadorErro = 0;
		
		System.out.println("Digite seu nome: ");
		nome = scanner.nextLine();
		System.out.println("Digite sua idade: ");
		idade = scanner.nextInt();
		System.out.println("Responda com SIM ou NAO");
		do{
		    System.out.println("\nSeu cartão de vacina está em dia?");
		    cartaoCheck = scanner.next().toUpperCase();
		    if(cartaoCheck.equals(cartaoCheck == "SIM")  || cartaoCheck == "NAO"){
		        break;
		    }else{
		        contadorErro = contadorErro + 1;
		        System.out.println("erro");
		        if(contadorErro == 3){
		            System.out.println("Tentativas excedidas! Encerrando entrevista.");
		            erroTentativa = true;
		        }else{
		            erroTentativa = false;
		        }
		    }
		}while(contadorErro < 3);
	}
}
