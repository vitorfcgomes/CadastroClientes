package services;
import java.util.List;
import java.util.Scanner;
import entities.Client;

public class ClientService {
    public void cadastrarCliente(Scanner sc, List<Client> list) {
        System.out.println("Nome: ");
        String name = sc.nextLine();
        System.out.println("--------------------------");

        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("--------------------------");

        System.out.println("Número: ");
        String number = sc.nextLine();
        System.out.println("--------------------------");

        System.out.println("Cliente Cadastrado com Sucesso!");
        Client client = new Client(name, number, email);
        list.add(client);


    }

    public void alterarCliente(Scanner sc, List<Client> list) {
        System.out.println("Informe o EMAIL do cliente: ");
        String email = sc.nextLine();

        Client client = buscarPorEmail(list, email);

        if (client == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        System.out.println("\nOque deseja alterar: ");
        System.out.println("[1] Alterar Nome ");
        System.out.println("[2] Alterar Email ");
        System.out.println("[3] Alterar Número ");
        System.out.print("Digite qual opção: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo Nome: ");
                client.setName(sc.nextLine());
                break;
            case 2:
                System.out.println("Digite o novo E-mail: ");
                client.setEmail(sc.nextLine());
                break;
            case 3:
                System.out.println("Digite o novo Número: ");
                client.setNumber(sc.nextLine());
                break;
            default:
                System.out.println("Opção Inválida! ");
                return;


        }
        System.out.println("Dados atualizados com sucesso! ");
    }
    private Client buscarPorEmail(List<Client> list, String email){
        for(Client c : list){
            if(c.getEmail().equals(email)){
                return c;
            }

        }
        return null;

    }
    public void acessarClientes(Scanner sc, List<Client> list){
        System.out.println("Digite o email do cliente: ");
        String email = sc.nextLine();

        Client client = buscarPorEmail(list,email);

        if(client == null){
            System.out.println("Cliente não Encontrado! ");
        }else{
            System.out.println("===================================");
            System.out.println("        Dados do Cliente       ");
            System.out.println();
            System.out.println("Nome: " + client.getName());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Telefone: " + client.getNumber());
            System.out.println("===================================");
        }
    }
    public void removerCliente(Scanner sc, List<Client>list){
        System.out.println("Digite o email do client que deseja remover: ");
        String email = sc.nextLine();
        Client client = buscarPorEmail(list, email);

        if(client == null){
            System.out.println("Cliente não encontrado! ");
            return;
        }
        System.out.println("Deseja remover este cliente? (s / n): ");
        Character confirm = sc.next().charAt(0);

        if(confirm == 's'){
            list.remove(client);
            System.out.println("Cliente Removido com Sucesso!");
        }else{
            System.out.println("Operação Cancelada! ");
        }
    }
}
