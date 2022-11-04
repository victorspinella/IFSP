package controller;





import modelo.entidade.Funcionario;
import modelo.service.FuncionarioService;
import view.AdminManterFuncionario;



public class FuncionarioController {
	
	
	private Funcionario funcionario ;
	
	
	   public void executa(AdminManterFuncionario frame) {
		   
		    funcionario = new Funcionario();
		    
		    funcionario.setNome(frame. getTxtNome().getText());
		    funcionario.setMatricula(Integer.parseInt(frame.getTextMatricula().getText()));
		    funcionario.setCargo(frame. getTextCargo() .getText());
		    funcionario.setSenha(frame. getTextSenha() .getText());
	        
	        FuncionarioService service = new FuncionarioService();
	        
	        service.salvar(funcionario);
	       
		   
		   
	   }
	   
	   
	   public void deleta(AdminManterFuncionario frame) {
		   
		    funcionario = new Funcionario();
		    
		    funcionario.setNome(frame. getTxtNome().getText());
		    funcionario.setMatricula(Integer.parseInt(frame.getTextMatricula().getText()));
		    funcionario.setCargo(frame. getTextCargo() .getText());
		    funcionario.setSenha(frame. getTextSenha() .getText());
	        
	        FuncionarioService service = new FuncionarioService();
	   
	        service.deletar(funcionario);}
	   
	   
	   
	   public void pesquisar(AdminManterFuncionario frame) {
		   
		    funcionario = new Funcionario();
		    
		   
		    funcionario.setMatricula(Integer.parseInt(frame.getTextMatricula().getText()));
		  	        
	        FuncionarioService service = new FuncionarioService();
	   
	        service.pesquisar(funcionario);}
	   
	  
	   
	   
	   
   
    

   

}