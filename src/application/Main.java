package application;

import entities.Client;
import services.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Client> list = new ArrayList<>();
        ClientService service = new ClientService();


        int opcao;

        System.out.println("[Cadastro de Clientes]");
        do{
            System.out.println("[1] Cadastrar novo Cliente");
            System.out.println("[2] Alterar dados do Cliente");
            System.out.println("[3] Acessar dados do Cliente");
            System.out.println("[4] Remover Cliente");
            System.out.println("[5] Encerrar");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    service.cadastrarCliente(sc, list);
                    break;

                case 2:
                    service.alterarCliente(sc, list);
                    break;
                case 3:
                    service.acessarClientes(sc, list);
                    break;
                case 4:
                    service.removerCliente(sc, list);
                    break;
                case 5:
                    System.out.println("Encerrando o Sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        }while(opcao != 5);

        sc.close();
        }
    }
