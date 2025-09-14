import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroVeiculos {
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Listar Veículos");
            System.out.println("3 - Excluir Veículo");
            System.out.println("4 - Pesquisar Veículo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarVeiculo();
                case 2 -> listarVeiculos();
                case 3 -> excluirVeiculo();
                case 4 -> pesquisarVeiculo();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private static void cadastrarVeiculo() {
String marca;
while (true) {
    System.out.print("Marca: ");
    marca = scanner.nextLine().trim();
    if (!marca.isEmpty() && !marca.matches("\\d+")) {
        break;
    } else {
        System.out.println("Marca inválida! Não pode conter apenas números.");
    }
}
String modelo;
while (true) {
    System.out.print("Modelo: ");
    modelo = scanner.nextLine().trim();
    if (!modelo.isEmpty()) {
        break;
    } else {
        System.out.println("Modelo inválido! Não pode ficar em branco.");
    }
}
        System.out.print("Ano: ");
        int ano;
while (true) {
    System.out.print("Ano do veículo (1986 a 2026): ");
    if (scanner.hasNextInt()) {
        ano = scanner.nextInt();
        scanner.nextLine();
        if (String.valueOf(ano).length() == 4 && (ano >= 1986 && ano <= 2026)) {
            break;
        } else {
            System.out.println("Ano inválido! Digite um valor entre 1986 e 2026.");
        }
    } else {
        System.out.println("Entrada inválida! Digite apenas números.");
        scanner.nextLine();
    }
}
        System.out.print("Placa: ");
        String placa;
        while (true) {
            System.out.print("Placa (formato ABC-123): ");
            placa = scanner.nextLine().toUpperCase();
            if (placa.matches("^[A-Z]{3}-\\d{3}$")) {
                break;
            } else {
                System.out.println("Placa inválida! Use o formato ABC-123 (3 letras, hífen, 3 números).");
    }
}
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Erro: já existe um veículo com essa placa!");
                return;
            }
        }

        veiculos.add(new Veiculo(marca, modelo, ano, placa));
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo v : veiculos) {
            System.out.println(v);
        }
    }

    private static void excluirVeiculo() {
        System.out.print("Informe a placa do veículo a excluir: ");
        String placa = scanner.nextLine();

        Veiculo veiculoParaRemover = null;
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                veiculoParaRemover = v;
                break;
            }
        }

        if (veiculoParaRemover != null) {
            veiculos.remove(veiculoParaRemover);
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Placa não encontrada.");
        }
    }

    private static void pesquisarVeiculo() {
        System.out.println("Pesquisar por:");
        System.out.println("1 - Placa");
        System.out.println("2 - Modelo");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Informe a placa: ");
            String placa = scanner.nextLine();
            boolean encontrado = false;
            for (Veiculo v : veiculos) {
                if (v.getPlaca().equalsIgnoreCase(placa)) {
                    System.out.println(v);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum veículo encontrado com essa placa.");
            }
        } else if (tipo == 2) {
            System.out.print("Informe parte do modelo: ");
            String modelo = scanner.nextLine();
            boolean encontrado = false;
            for (Veiculo v : veiculos) {
                if (v.getModelo().toLowerCase().contains(modelo.toLowerCase())) {
                    System.out.println(v);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum veículo encontrado com esse modelo.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
