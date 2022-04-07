import java.util.Scanner;



public class App01 {
	
    static Scanner ler = new Scanner(System.in);
	static int cont = 0;
	static ImovelArray[] imovel = new ImovelArray[3];

	 public static void main(String[] args) {

	        int opcao = 0;

	        do {
	            System.out.println("---OP��ES---");
	            System.out.println("1- Cadastrar im�vel");
	            System.out.println("2- Calcular consumo");
	            System.out.println("3- Calcular conta individual");
	            System.out.println("4- Excluir cadastro de im�vel");
	            System.out.println("5- Listar dados de todos os im�veis cadastrados");
	            System.out.println("6- Alterar cadastro de im�vel");  //FAZER!
	            System.out.println("0- Finalizar");

	            try {
	                System.out.println("Digite a op��o: ");
	                opcao = ler.nextInt();
	            }
	            catch (Exception e) {
	                System.out.println("\n >>> erro! a op��o deve ser num�rica! <<< \n");
	                ler.nextLine();
	                continue;
	            }

	            switch (opcao) {

	                case 1:
	                	cadastrarImovel();
	                    break;

	                case 2:
	                	calcularConsumo();
	                    break;

	                case 3:
	                	calcularConta();             	
                        break;

	                case 4:
	                	excluirCadastro();
	                	break;
	                	               	
	                case 5:
	                	listarCadastros();
	                	break;
	                
	                case 6:
	                	alterarCadastro();
	                	break;
				
	                case 0:
	                    System.out.println("\n >>> sistema finalizado <<< \n");
	                    return;

	                default:
	                    System.out.println("\n >>> op��o inv�lida <<< \n");
	                    break;
	            }
	        } while (true);
	    }

public static int pesquisarImovel(int idImovel) {
	for (int i = 0 ; i < cont ; i++) {
		if (imovel[i].getIdImovel() == idImovel) {
	       return i;
	     }
	}
 return -1;
}

public static void cadastrarImovel() {
    if (cont == imovel.length) {
        System.out.println("\n >>> a mem�ria do sistema est� cheia! <<< \n");
    }
    
    int leituraAtual = 0;
    String tipo;
    int idImovel = 0;
    
    System.out.println("---Cadastrar im�vel---");
    try {
    System.out.println("Digite o identificador do im�vel: ");
    idImovel = ler.nextInt();
    }
    catch (Exception e) {
    	System.out.println("\n>>> leitura inv�lida. digite apenas n�meros <<<\n");
    }
    
    System.out.println("Digite o tipo do im�vel (C / I / R)");
    ler.nextLine();
    tipo = ler.nextLine().toUpperCase();
    
    try {
    System.out.println("Digite a leitura atual do contador: ");
    leituraAtual = ler.nextInt();
    } catch (Exception e) {
    	System.out.println("\n>>> leitura inv�lida. digite apenas n�meros <<< \n");
    }
    
    imovel[cont] = new ImovelArray(idImovel, tipo, leituraAtual);
    cont++;		
}

public static void calcularConsumo() {
    if (cont == 0) {
        System.out.println("\n >>> nenhum im�vel cadastrado <<< \n");
    }

    System.out.println("---Calcular consumo---");
    System.out.println("Digite o identificador do im�vel: ");
    int idImovel = ler.nextInt();  //~~~~~SO DEIXAR NUMERO
    
    int posicao = pesquisarImovel(idImovel);
     
    if (posicao == -1) {
        System.out.println(">>> im�vel n�o cadastrado <<<");
    }    
    
    System.out.println("Digite a leitura atual do contador: ");
    int leituraAtual = ler.nextInt();
    
    posicao = pesquisarImovel(idImovel);

    imovel[posicao].registrarLeitura(leituraAtual);

    System.out.println("O consumo atual deste im�vel �: " + imovel[posicao].getConsumo());    
}

public static void calcularConta() {
    if (cont == 0) {
        System.out.println("\n >>> nenhum im�vel cadastrado <<< \n");
    }
    System.out.println("---Calcular consumo individual---");
    int idImovel = 0;
    try {
    	System.out.println("Digite o identificador do im�vel: ");
    	idImovel = ler.nextInt();     
    } catch (Exception e) {
    	System.out.println("\n>>> leitura inv�lida. digite apenas n�meros <<< \n");	                    	
    }
    
    int posicao = pesquisarImovel(idImovel);
 	                    
    if (posicao == -1) {
        System.out.println(">>> im�vel n�o cadastrado <<<");
    }
    
    imovel[posicao].calcularConta();
    
    System.out.printf("O valor da conta deste im�vel � %.2d: " , imovel[posicao].getValorConta());
    
    if (imovel[posicao].getValorConta() == 0) {
    	System.out.println("\n>>> este im�vel n�o registrou consumo <<<\n");
    }	
}

public static void excluirCadastro() {
	if (cont == 0) {
		System.out.println("\\n >>> nenhum im�vel cadastrado! <<< \\n");
	}
	System.out.println("---Excluir cadastro---");
	System.out.println("Digite o identificador do im�vel que voc� quer excluir: ");
	int idImovel = ler.nextInt();       //~~~~~~SO DEIXAR ESCREVER NUMERO
	
	int posicao = pesquisarImovel(idImovel);
	
	if (posicao != -1) {
		imovel[posicao] = null;
		imovel[posicao] = imovel[posicao + 1];
		imovel[posicao + (cont - 1)] = null;      //esvazia o ultimo
	} else {
		System.out.println("\n>>> identificador n�o cadastrado! <<<\n");
	}
		
	System.out.println("\n>>> cadastro exclu�do com sucesso! <<< \n");	
}

public static void listarCadastros() {

	System.out.println("---Listagem de im�veis---");
	
    for (ImovelArray imovel : imovel) {
        if (imovel != null) {
            System.out.println(imovel.toString());
        }
    }
}

public static void alterarCadastro() {
	if (cont == 0) {
		System.out.println("\\n >>> nenhum im�vel cadastrado! <<< \\n");	                		
	}
	
	System.out.println("---Alterar cadastro---");
	System.out.println("Digite o identificador: ");
	int idImovel = ler.nextInt();            //~~~~SO DEIXAR ESCREVER NUMERO
	
	int posicao = pesquisarImovel(idImovel);
	
	if (posicao != -1) {
    	System.out.println("O que voc� deseja alterar?");
    	System.out.println("1- tipo do im�vel");
    	System.out.println("2- leitura atual");
    	
    	int opcao1 = 0;
    	
        try {
            System.out.println("Digite a op��o: ");
            opcao1 = ler.nextInt();
        }
        catch (Exception e) {
            System.out.println("\n >>> erro! a op��o deve ser num�rica! <<< \n");
            ler.nextLine();
        }
    	switch (opcao1) {
    	
    	case 1:
    		String tipoNovo;
            System.out.println("---o tipo atual a ser alterado �: " + imovel[posicao].getTipo().toUpperCase());
    		System.out.println("Digite o novo tipo (C / I / R)");
            ler.nextLine();
    		tipoNovo = ler.nextLine();
    		imovel[posicao].setTipo(tipoNovo);
    		System.out.println("Tipo alterado!\n");
    		break;
    	case 2:
    		int leituraAtualNova = 0;
            System.out.println("---a leitura atual a ser alterada �: " + imovel[posicao].getLeituraAtual());    		
    		System.out.println("Digite a nova leitura: ");
    		leituraAtualNova = ler.nextInt();    //~~~SO RECEBRR NUMERO
    		imovel[posicao].setLeituraAtual(leituraAtualNova);
    		System.out.println("Leitura alterada!\n");
    		break;
    	default:	
            System.out.println("\n>>> op��o inv�lida <<<\n");
            break;
    	}
 	} else {
		System.out.println("\n>>> identificador n�o cadastrado! <<<\n");
   	}	
}
}
