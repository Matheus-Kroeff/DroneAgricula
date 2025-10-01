// Incompleto

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public Class MissaoVoo {

  private int id;
  private LocalDate data;
  private LocalTime horarioInicio;
  private LocalTime horarioFim;

  private Drone droneUtilizado;
  private AreaAgricola areaVoo;
  private Usuario operador; // O operador que agendou a missão

  // Construtor
    public MissaoVoo(int id, LocalDate data, LocalTime inicio, LocalTime fim, Drone drone, AreaAgricola area, Usuario operador) {
        this.id = id;
        this.data = data;
        this.horarioInicio = inicio;
        this.horarioFim = fim;
        this.droneUtilizado = drone;
        this.areaVoo = area;
        this.operador = operador;
    }

  public boolean validarNaoSobreposta() {
    }




// Getters
  public int getId() {
        return id;
  }

  public Drone getDroneUtilizado() {
       return droneUtilizado;
  }
}
