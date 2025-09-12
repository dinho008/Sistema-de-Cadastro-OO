public class Veiculo {
    private String Marca;
    private String Modelo;
    private int Ano;
    private String Placa;

    public Veiculo() {
    }
    
    public Veiculo(String Marca, String Modelo, int Ano, String Placa) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Ano = Ano;
        this.Placa = Placa;
    }

    public String GetMarca() {
        return Marca;
    }

    public void SetMarca(String Marca) {
        this.Marca = Marca;
    }

    public String GetModelo() {
        return Modelo;
    }

    public void SetModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int GetAno() {
        return Ano;
    }

    public void SetAno(int Ano) {
        this.Ano = Ano;
    }

    public String GetPlaca() {
        return Placa;
    }

    public void SetPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String toString() {
        return "Veículo {" +
                "Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Ano=" + Ano +
                ", Placa='" + Placa + '\'' +
                '}';
    }
}