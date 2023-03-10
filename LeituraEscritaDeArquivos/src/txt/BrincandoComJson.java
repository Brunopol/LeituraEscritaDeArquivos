package txt;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class BrincandoComJson {

	public static class Aluno {

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

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	public static void main(String[] args) throws IOException {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Bruno");
		aluno1.setIdade(17);
		aluno1.setEmail("Bruno@gmail.com");
		aluno1.setMessage("I am learning Java!!");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Miriã");
		aluno2.setIdade(15);
		aluno2.setEmail("Miria@gmail.com");
		aluno2.setMessage("I am encomodando o Bruno!!");
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(aluno1);
		alunos.add(aluno2);
		

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonAlunos = gson.toJson(alunos);
		
		File file = new File("//home//bruno//eclipse-workspace//LeituraEscritaDeArquivos//src//txt//arquivo.json");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		
		FileWriter fileWriter = new FileWriter(file);
		
		
		
		fileWriter.write(jsonAlunos);
		fileWriter.flush();
		fileWriter.close();
		
		
		/////////////////////////////////////////// LENDO O ARQUIVO ////////////////////////////////////////////////////
		
		
		FileReader fileReader = new FileReader(file);
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		for (JsonElement jsonElement : jsonArray) {
			
			Pessoa pessoa = new Gson().fromJson(jsonElement, Pessoa.class);
			pessoas.add(pessoa);
			
		}
		
		
		System.out.println(pessoas);
	

	}

}
