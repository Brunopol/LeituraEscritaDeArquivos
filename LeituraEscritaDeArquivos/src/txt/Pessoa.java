package txt;

public class Pessoa {

	private String nome;
	private int idade;
	private String email;
	private String message;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAge() {
		return idade;
	}

	public void setAge(int age) {
		this.idade = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", age=" + idade + ", email=" + email + ", message=" + message + "]";
	}

}
