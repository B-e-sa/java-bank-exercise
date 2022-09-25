import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    // Saldo inicial do banco
    static int saldo = 1000;

    /* 
     * Concatena-se uma dessas strings para alterar a cor
     * da próxima mensagem no console
    */ 
    // Cor vermelha
    static String corDaProximaMensagemVermelha = "\u001B[31m";

    // Cor verde
    static String corDaProximaMensagemVerde = "\u001B[32m";

    /* 
     * Cor padrão
     * Se não resetar a cor, o console ficará colorido o programa inteiro
    */
    static String corDaProximaMensagemNormal = "\u001B[0m";

    // Um separador de quebra de linha
    static String separadorDeLinha = "==================================";

    /*
     * Pergunta se o usuário quer
     * 1 = Depositar dinheiro em sua conta
     * 2 = Sacar dinheiro de sua conta
     * 3 = Sair da aplicação
     */
    static void selecaoDeOpcao() {

        System.out.print(
            "\n" 
            + "Deseja realizar qual procedimento?" 
            + "\n[1] Depósito" 
            + "\n[2] Saque" 
            + "\n[3] Sair\n"
            + separadorDeLinha 
            + "\n"
            );

        int opcaoSelecionada = sc.nextInt();

        if (opcaoSelecionada == 1) {
            depositarDinheiro(saldo);
        } else if (opcaoSelecionada == 2) {
            sacarDinheiro(saldo);
        } else {}
    }

    // Operação caso a opção escolhida tenha sido depósito
    static void depositarDinheiro(int valor) {
        System.out.println("Insira o valor que deseja depositar: ");

        int valorDepositado = sc.nextInt();

        // Se o valor de deposito for inválido (negativo ou nulo)
        if (valorDepositado <= 0) {

            System.out.println(
                "\n"
                + separadorDeLinha
                + corDaProximaMensagemVermelha
                + "\nERRO! valor inválido"
                + corDaProximaMensagemNormal
                + "\nPor favor, insira um valor válido (maior que 0)");

            selecaoDeOpcao();

        // Se o valor depositado for válido
        } else {
            saldo += valorDepositado;
            System.out.println(
                "\n"
                + separadorDeLinha 
                + corDaProximaMensagemVerde 
                + "\nR$" + valorDepositado + " depositado com sucesso\n" 
                + corDaProximaMensagemNormal 
                + "\nO seu saldo atual é de R$" + saldo
                );

            selecaoDeOpcao();
        };
    };

    // Operação caso a opção escolhida tenha sido saque
    static void sacarDinheiro(int valor) {
        System.out.println("Insira um valor para saque:");

        int valorDeRetirada = sc.nextInt();

        // Caso o valor de saque seja maior que o saldo total da conta
        if (valorDeRetirada > saldo) {
            System.out.println(
                "\n"
                + separadorDeLinha
                + corDaProximaMensagemVermelha
                + "\nERRO! "
                + "Você não possui este valor em sua conta" 
                + corDaProximaMensagemNormal
                + "\nPor favor, insira um valor válido (menor ou igual ao saldo total)"
                );

            selecaoDeOpcao();
        
        // caso o valor seja válido
        } else {
            saldo -= valorDeRetirada;
            System.out.println(
                "\n"
                + separadorDeLinha 
                + corDaProximaMensagemVerde
                + "\nVocê sacou " + valorDeRetirada + " da sua conta, agora seu saldo total é de R$" + saldo 
                + corDaProximaMensagemNormal
                );
            selecaoDeOpcao();
        };
    };

    // Tela inicial do programa
    static void mostrarSituacaoDaConta(int valor) {
        System.out.println(
            separadorDeLinha
            + "\nVocê possui uma quantia de R$" + saldo
            );

        selecaoDeOpcao();
    };

    public static void main(String[] args) {
        mostrarSituacaoDaConta(saldo);
    };
};
