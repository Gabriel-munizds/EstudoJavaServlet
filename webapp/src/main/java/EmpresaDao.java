import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDao implements AbstractDao<Empresa>{
    Connection connection;

    public EmpresaDao(){
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void create(Empresa obj) {
        String sql = "insert into empresas"	+
                "(nome)"+
                "values	(?)";
        try	{
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            // setando os valores
            stmt.setString(1, obj.getNome());
            //executa
            stmt.execute();
            stmt.close();
        }  catch (SQLException e)	{
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Empresa> retrieve() {
        try {
            List<Empresa> empresaList = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from empresas");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getLong("id"));
                empresa.setNome(rs.getString("nome"));
                empresaList.add(empresa);
            }
            rs.close();
            stmt.close();
            return empresaList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Empresa obj) {
    }

    @Override
    public void delete(Empresa obj) {
        // TODO Auto-generated method stub
        
    }

}