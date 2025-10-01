// incompleto

public class DadoColetado {

  private int id;
  private int fkMissao; // Chave estrangeira no modelo OO, para referência à Missão
  private String imagemURL;
  private double temperatura; 
  private double umidade;    
  private double valorSensorSimulado;

  public DadoColetado(int id, int fkMissao, String imagemURL, double temperatura, double umidade, double valorSensorSimulado) {
        this.id = id;
        this.fkMissao = fkMissao;
        this.imagemURL = imagemURL;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.valorSensorSimulado = valorSensorSimulado;
    }

 public void registrarDado() {
        System.out.println("Dado ID " + this.id + " (Temp: " + this.temperatura + "°C) gerado pela Missão " + this.fkMissao + ".");
    }
    
    // Getters
    public int getId() {
        return id;
    }

    public int getFkMissao() {
        return fkMissao;
    }

    public double getTemperatura() {
        return temperatura;
    }
}
