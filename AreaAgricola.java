public class AreaAgricola {

    private int id;
    private double tamanhoHectares;
    private String localizacao;
    private String tipoCultivo;

    // Construtor
    public AreaAgricola(int id, double tamanhoHectares, String localizacao, String tipoCultivo) {
        this.id = id;
        this.tamanhoHectares = tamanhoHectares;
        this.localizacao = localizacao;
        this.tipoCultivo = tipoCultivo;
    }

    // Getters 
    public int getId() {
        return id;
    }

    public double getTamanhoHectares() {
        return tamanhoHectares;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    // Método de cadastro (simulação)
    public void cadastrarArea() {
        System.out.println("Área Agrícola ID " + this.id + " (" + this.tipoCultivo + ") cadastrada com sucesso.");
    }
}
