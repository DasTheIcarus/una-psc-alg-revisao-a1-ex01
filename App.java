import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome;
        int idade;
        String cartaoCheck, sintomasCheck, contatoCheck, viagemCheck;
        double risco = 0;

        System.out.print("Informe o seu nome: ");
        nome = scanner.nextLine();

        System.out.print("Informe a sua idade: ");
        idade = scanner.nextInt();
        scanner.nextLine(); 

        
        cartaoCheck = perguntar(scanner, "Seu cartão de vacina está em dia? (SIM/NAO)");
        if (cartaoCheck == null) {
            encerrar();
            return;
        }

        sintomasCheck = perguntar(scanner, "Teve algum dos sintomas recentemente? (dor de cabeça, febre, náusea, dor articular, gripe) (SIM/NAO)");
        if (sintomasCheck == null) {
            encerrar();
            return;
        }

        contatoCheck = perguntar(scanner, "Teve contato com pessoas com sintomas gripais nos últimos dias? (SIM/NAO)");
        if (contatoCheck == null) {
            encerrar();
            return;
        }

        viagemCheck = perguntar(scanner, "Está retornando de viagem realizada no exterior? (SIM/NAO)");
        if (viagemCheck == null) {
            encerrar();
            return;
        }

        if (cartaoCheck.equalsIgnoreCase("NAO")) {
            risco += 10;
        }
        if (sintomasCheck.equalsIgnoreCase("SIM")) {
            risco += 30;
        }
        if (contatoCheck.equalsIgnoreCase("SIM")) {
            risco += 30;
        }
        if (viagemCheck.equalsIgnoreCase("SIM")) {
            risco += 30;
        }

        
        String orientacao;

        if (risco <= 30) {
            if (viagemCheck.equalsIgnoreCase("SIM")) {
                orientacao = "Você ficará sob observação por 05 dias.";
            } else {
                orientacao = "Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica.";
            }
        } else if (risco <= 60) {
            orientacao = "Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.";
        } else if (risco < 90) {
            orientacao = "Paciente com alto risco de estar infectado. Gentileza aguardar em lockdown por 05 dias para ser acompanhado.";
        } else {
            orientacao = "Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado.";
        }

        
        System.out.println("\n- RESULTADO DO DIAGNÓSTICO -");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cartão de vacina em dia: " + cartaoCheck);
        System.out.println("Teve sintomas recentemente: " + sintomasCheck);
        System.out.println("Teve contato com pessoas infectadas: " + contatoCheck);
        System.out.println("Retornando de viagem: " + viagemCheck);
        System.out.println("Chances de estar contaminado: " + risco + "%");
        System.out.println("Orientação: " + orientacao);

        scanner.close();
    }

   
    public static String perguntar(Scanner scanner, String pergunta) {
        for (int i = 1; i <= 3; i++) {
            System.out.print(pergunta + " ");
            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.equals("SIM") || resposta.equals("NAO")) {
                return resposta;
            } else {
                System.out.println("Resposta inválida! Tente novamente. (" + i + " de 3 tentativas)");
            }
        }
        return null; 
    }

    
    public static void encerrar() {
        System.out.println("\nNão foi possível realizar o diagnóstico.");
        System.out.println("Gentileza procurar ajuda médica caso apareça algum sintoma.");
    }
}
