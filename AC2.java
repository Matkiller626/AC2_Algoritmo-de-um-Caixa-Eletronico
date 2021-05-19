import java.util.Scanner;

public class AC2 {
    public static void main(String[] args) {
    
        Scanner ler = new Scanner(System.in);
        String cpf_correto = "12345678900";
        String senha_correta = "01020304";
        String cpf_digitado="";
        String senha_digitada="";
        float saldo = 1000;
        int erro_senha=0;
        int opçao;
        float operaçao;
        int conta_transf;
        int agencia_transf;
        int banco_transf;
        int x = 50;
        String[] extrato = new String[x];
        float[] extrato_valor = new float[x];
        int index=0;

        
        System.out.println("    BEM-VINDO   ");
        System.out.println("    BANCO JAVA    ");
        System.out.println("Faça login com CPF e Senha \n");
        
        while(!cpf_digitado.equals(cpf_correto)){
            System.out.print("Digite seu CPF: ");
            cpf_digitado = ler.next();
            
            if(!cpf_digitado.equals(cpf_correto)){
                System.out.println("Acesso nao permitido. Tente novamente.\n");
            }
        }
        
        while(!senha_digitada.equals(senha_correta)){
            System.out.print("Digite sua senha: ");
            senha_digitada = ler.next();
            if(!senha_digitada.equals(senha_correta)){
                erro_senha++;
                System.out.println("Senha incorreta.\n");
            }
            if(erro_senha==3){
                System.out.println("Tentativas excedidas.\n"
                        + "Conta bloqueada.\n");
                System.exit(0);
            }
        }
        
        
        do{
        System.out.println("    MENU    \n"
                + "1 - Saldo\n"
                + "2 - Depósito\n"
                + "3 - Saque\n"
                + "4 - Extrato\n"
                + "5 - Tranferencia\n"
                + "0 - Sair\n");
        opçao = ler.nextInt();
        
            switch(opçao){
            
                case 1:
                    System.out.println("\nSeu saldo é: "+saldo+"\n");
                    break;
                
                case 2:
                    System.out.print("\nDigite o valor do depósito: ");
                    operaçao = ler.nextFloat();
                        if(operaçao<=0){
                            System.out.println("Impossivel realizar deposito.\n");
                        }else{
                            saldo = saldo + operaçao;
                            extrato[index] = "Deposito";
                            extrato_valor[index] = operaçao;
                            index++;
                            System.out.println("Deposito realizado com sucesso.\n");
                        }
                        break;
                        
                case 3:
                    System.out.print("\nDigite o valor do saque: ");
                    operaçao = ler.nextFloat();
                    if(operaçao>saldo || operaçao<=0){
                        System.out.println("\nImpossivel realizar saque.\n");
                    }else{
                        saldo = saldo - operaçao;
                        extrato[index] = "Saque      ";
                        extrato_valor[index] = operaçao;
                        index++;
                        System.out.println("\nSaque realizado com sucesso.\n");
                    }
                    break;
                
                case 4:
                    System.out.println("\t      Extrato:");
                    for(int i = 0; extrato[i] != null;i++){
                        System.out.println(extrato[i]+"\t\t"+extrato_valor[i]);
                    }
                    System.out.println("\n");
                    break;
                
                case 5:
                    System.out.print("\nDigite a conta do favorecido: ");
                    conta_transf = ler.nextInt();
                    System.out.print("\nDigite a agencia do favorecido: ");
                    agencia_transf = ler.nextInt();
                    System.out.print("\nDigite o banco do favorecido: ");
                    banco_transf = ler.nextInt();
                    System.out.print("\nDigite o valor da transferencia: ");
                    operaçao = ler.nextFloat();
                
                    if(operaçao>saldo || operaçao<=0){
                    System.out.println("\nImpossivel realizar transferencia.\n");
                    }else{
                        saldo = saldo - operaçao;
                        extrato[index] = "Transferencia";
                        extrato_valor[index] = operaçao;
                        index++;
                        System.out.println("\nTranferencia realizada com sucesso para esses dados:\n"
                                +"Conta: "+conta_transf+"\n"
                                + "Agencia: "+agencia_transf+"\n"
                                + "Banco: "+banco_transf+"\n"
                                + "Valor transferido: "+operaçao+"\n");
                    }
                    break;
                
                default:
                    System.out.println("\n Opçao inválida \n");
                
            }
        }while(opçao!=0);
        
        System.out.println("\nSessão finalizada com sucesso!\n");

    }
}