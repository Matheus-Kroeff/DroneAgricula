public class Drone {

    // Atributos privados 
    private int id;
    private String sensoresDisponiveis; // Ex: "Temperatura, Umidade, Câmera HD"
    private String status;              // Ex: "Disponível", "Em Missão", "Manutenção"
    private int bateriaMinima;          // Valor percentual (Ex: 30)
    private boolean sensoresFuncionando;
    
    // Constante para o nível mínimo de bateria exigido 
    private static final int BATERIA_REQUISITO = 40; 

    // Construtor
    public Drone(int id, String sensoresDisponiveis, int bateriaAtual, boolean sensoresFuncionando) {
        this.id = id;
        this.sensoresDisponiveis = sensoresDisponiveis;
        this.bateriaMinima = bateriaAtual;
        this.sensoresFuncionando = sensoresFuncionando;
        this.status = "Disponível"; // Status inicial
    }

    // Método de Segurança: Checklist de Pré-Voo
    // Implementa o requisito: "Checklist de segurança antes do voo (bateria mínima e sensores funcionando)."
    public boolean checarPreVoo() {
        // Validação da Bateria
        if (this.bateriaMinima < BATERIA_REQUISITO) {
            System.out.println("Alerta de Segurança: Bateria insuficiente (" + this.bateriaMinima + "%)!");
            return false;
        }

        // Validação dos Sensores
        if (!this.sensoresFuncionando) {
            System.out.println("Alerta de Segurança: Sensores principais não estão funcionando!");
            return false;
        }

        System.out.println("Checklist OK: Drone apto para o voo.");
        return true;
    }

    // Getters (acesso controlado)
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
    
    // Setter (modificação controlada do status)
    public void setStatus(String status) {
        this.status = status;
    }

}
