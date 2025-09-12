import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroVeiculos {
    private static List<Veiculo> Veiculos = new ArrayList<>();
    private static Scanner ScannerInput = new Scanner(System.in);

    public static void main(String[] args) {
        int Opcao;

        do {
            System.out.println("\n=== Sistema de Cadastro de Veículos ===");
            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Listar Veículos");
            System.out.println("3 - Excluir Veículo");
            System.out.println("4 - Pesquisar Veículo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            Opcao = ScannerInput.nextInt();
            ScannerInput.nextLine();

            switch (Opcao) {
                case 1 -> CadastrarVeiculo();
                case 2 -> ListarVeiculos();
                case 3 -> ExcluirVeiculo();
                case 4 -> PesquisarVeiculo();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (Opcao != 0);
    }

    private static void CadastrarVeiculo() {
        System.out.print("Digite a marca: ");
        String Marca = ScannerInput.nextLine();

        System.out.print("Digite o modelo: ");
        String Modelo = ScannerInput.nextLine();

        System.out.print("Digite o ano: ");
        int Ano = ScannerInput.nextInt();
        ScannerInput.nextLine();

        System.out.print("Digite a placa: ");
        String Placa = ScannerInput.nextLine();

        for (Veiculo V : Veiculos) {
            if (V.GetPlaca().equalsIgnoreCase(Placa)) {
                System.out.println("Erro: Já existe um veículo com essa placa!");
                return;
            }
        }

        Veiculo NovoVeiculo = new Veiculo(Marca, Modelo, Ano, Placa);
        Veiculos.add(NovoVeiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void ListarVeiculos() {
        if (Veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        System.out.println("\n=== Lista de Veículos ===");
        for (Veiculo V : Veiculos) {
            System.out.println(V);
        }
    }
    private static void ExcluirVeiculo() {
        System.out.print("Digite a placa do veículo a ser removido: ");
        String Placa = ScannerInput.nextLine();

        Veiculo VeiculoRemover = null;
        for (Veiculo V : Veiculos) {
            if (V.GetPlaca().equalsIgnoreCase(Placa)) {
                VeiculoRemover = V;
                break;
            }
        }

        if (VeiculoRemover != null) {
            Veiculos.remove(VeiculoRemover);
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Erro: Veículo com a placa informada não encontrado.");
        }
    }

    private static void PesquisarVeiculo() {
        System.out.println("Pesquisar por:");
        System.out.println("1 - Placa");
        System.out.println("2 - Modelo");
        System.out.print("Escolha: ");
        int Escolha = ScannerInput.nextInt();
        ScannerInput.nextLine();

        if (Escolha == 1) {
            System.out.print("Digite a placa exata: ");
            String Placa = ScannerInput.nextLine();

            for (Veiculo V : Veiculos) {
                if (V.GetPlaca().equalsIgnoreCase(Placa)) {
                    System.out.println("Veículo encontrado: " + V);
                    return;
                }
            }
            System.out.println("Nenhum veículo encontrado com essa placa.");

        } else if (Escolha == 2) {
            System.out.print("Digite parte do modelo: ");
            String Modelo = ScannerInput.nextLine();

            boolean Encontrado = false;
            for (Veiculo V : Veiculos) {
                if (V.GetModelo().toLowerCase().contains(Modelo.toLowerCase())) {
                    System.out.println("Veículo encontrado: " + V);
                    Encontrado = true;
                }
            }
            if (!Encontrado) {
                System.out.println("Nenhum veículo encontrado com esse modelo.");
            }

        } else {
            System.out.println("Opção inválida!");
        }
    }
}