package txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscreverArquivo {

	public static void main(String[] args) throws IOException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		File arquivo = new File("//home//bruno//eclipse-workspace//LeituraEscritaDeArquivos//src//txt//arquivo.txt");

		if (!arquivo.exists()) {

			arquivo.createNewFile();

		}

		FileWriter escrever_no_arquivo = new FileWriter(arquivo);

		escrever_no_arquivo.write("Bruno;17;Bruno@gmail.com \n");
		escrever_no_arquivo.write("Maria;45;Maria@gmail.com \n");
		escrever_no_arquivo.write("Joao;34;Joao@gmail.com \n");
		escrever_no_arquivo.write("Pedro;14;Pedro@gmail.com \n");
		escrever_no_arquivo.write("Miria;15;Miria@gmail.com \n");

		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();

		// Leitura de Arquivo
		FileInputStream entradaArquivo = new FileInputStream(
				new File("//home//bruno//eclipse-workspace//LeituraEscritaDeArquivos//src//txt//arquivo.txt"));

		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

		while (lerArquivo.hasNext()) {

			String linha = lerArquivo.nextLine();

			if (!(linha == null) && !linha.isEmpty()) {

				String[] banco = linha.split(";");

				Pessoa pessoa = new Pessoa();

				pessoa.setNome(banco[0]);
				pessoa.setAge(Integer.valueOf(banco[1]));
				pessoa.setEmail(banco[2]);
				
				pessoas.add(pessoa);

			}

		}

		for (Pessoa pessoa : pessoas) {
			
			System.out.println(pessoa);
			
		}
		
		lerArquivo.close();
		
		
	}

}
