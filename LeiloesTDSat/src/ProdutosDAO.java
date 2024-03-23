
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) throws Exception {
        conn = new conectaDAO().connectDB();
        
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)");
        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getValor());
        stmt.setString(3, produto.getStatus());
        stmt.executeUpdate();
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
