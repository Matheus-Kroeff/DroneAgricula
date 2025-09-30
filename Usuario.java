// Incompleto

public class Usuario { 

   public static final String TIPO_ADMIN = "Administrador";
   public static final String TIPO_OPERADOR = "Operador";

   private int id;
   private String nome;
   private String email;
   private String tipoAcesso; // Usará as constantes acima

   public Usuario(int id, String nome, String email, String tipoAcesso) {
      this.id = id;
      this.nome = nome;
      this.email = email;
      this.tipoAcesso = tipoAcesso;
   }

   public boolean login() {
   }

   public boolean isAdministrador() {
       return 
   }

   public boolean isOperador() {
        return
   }

// Getters 
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }
}
