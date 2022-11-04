package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.protocol.Resultset;
import modelo.entidade.Funcionario;




public class FuncionarioDao {
	
private	    Resultset rPesquisa  ;
private 	Funcionario  fPesquisa = new Funcionario () ;
	
	
	
	
	public void salvar(Funcionario funcionario) {    	
    	Conexao conexao = new Conexao();
    	
        String sql = "INSERT INTO " +
                "funcionario (nome, matricula, cargo,senha) " +
                "VALUES (?,?,?,?)";
        try {
        	
        	PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
        	
            stmt.setString(1, funcionario.getNome());
			stmt.setLong(2,   funcionario.getMatricula());
			stmt.setString(3, funcionario.getCargo());
			stmt.setString(4, funcionario.getSenha());
			
			
			stmt.execute();
            stmt.close();
          }
        
     
        catch (SQLException e) {
            e.printStackTrace();
          } }
	
	
	public void deletar(Funcionario funcionario) {    	
    	Conexao conexao = new Conexao();
    	
        String sql = "delete from funcionario where matricula=?";
        try {
        	
        	PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
        	stmt.setLong(1,   funcionario.getMatricula());
			
			stmt.execute();
            stmt.close();
          }
        
     
        catch (SQLException e) {
            e.printStackTrace();
          } }
	
	
	
	
	
	
	 public Funcionario pesquisarFuncionario (Funcionario funcionario ){ 
	 Conexao conexao = new Conexao();
  
       String sql = "select from funcionario where matricula=?";
        try {
        	
        
        	
        	
        	PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
        	stmt.setLong(1,   funcionario.getMatricula());
 
        	fPesquisa.setNome( "nome") ; 
        	
        	
        //	 fPesquisa.setMatricula(Integer.parseInt("matricula"));
        	// fPesquisa.setCargo("cargo");
        	// fPesquisa.setSenha("senha");
         
         }
        
     
        catch (SQLException e) {
           e.printStackTrace();
            
             }
		return fPesquisa;
		 }


	


	
	
	
	
	



}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

