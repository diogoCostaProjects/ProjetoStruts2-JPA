package br.com.treinaweb2.teste.login.actions;

public class LoginAction {
	
	/*Classe baseada em javaBeans, 
	 * 
	 * para set�-la basta por o mesmo nome nos atributos da tag "name" do pojo do jsp*/
	
	private String email;
	private String senha;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public String logar(){ /* invocado pelo struts, cuida da parte l�gica, podendo logar no BD
	 						   Conversa com as paginas JSP atrav�s do result, encaminha qual caminho deve ser tomado */ 
		if(this.email.equals("teste@teste.com") && this.senha.equals("123")){
			return "SUCCESS";
		}else{
			return "ERROR";
		}
	}
	
	

}
