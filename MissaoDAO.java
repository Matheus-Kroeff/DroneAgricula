import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime; // Para Time

public class MissaoDAO {

    // Simulação da conexão com o banco de dados. 
    private Connection conexao; 

    public MissaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Método que salva a Missão de Voo de forma segura
    public boolean salvarMissao(int idMissao, int idDrone, int idArea, int idOperador, Date data, LocalTime inicio, LocalTime fim) {

        String sql = "INSERT INTO TB_MISSAO (id_missao, fk_drone, fk_area, fk_operador, data, horario_inicio, horario_fim) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        // Usando try-with-resources para garantir o fechamento do PreparedStatement
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            // Atribuição dos valores aos placeholders de forma segura
            stmt.setInt(1, idMissao);
            stmt.setInt(2, idDrone);
            stmt.setInt(3, idArea);
            stmt.setInt(4, idOperador);
            stmt.setDate(5, data);
            stmt.setTime(6, java.sql.Time.valueOf(inicio)); // Converte LocalTime para java.sql.Time
            stmt.setTime(7, java.sql.Time.valueOf(fim)); 
            
            // Executa o comando SQL
            stmt.executeUpdate();
            System.out.println("Missão salva com segurança (PreparedStatement)!");
            return true;
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar a missão no banco de dados: " + e.getMessage());
            return false;
        }
    }
    
    // Método para fechar a conexão no final
    public void fecharConexao() {
        try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                this.conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
