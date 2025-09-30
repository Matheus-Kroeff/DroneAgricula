// incompleto

public class DadoColetado {

  private int id;
  private int fkMissao; // Chave estrangeira no modelo OO, para referência à Missão
  private String imagemURL;
  private double temperatura; 
  private double umidade;    
  private double valorSensorSimulado;

  public DadoColetado() {
  }

  public void registrarDado() {
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
