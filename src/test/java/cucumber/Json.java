package cucumber;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {

	private String nome;
	private String cpf;
	private String email;

	public Json(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	//public Json(String nameJson) throws IOException, ParseException {
		//LerJson(nameJson);
	//}

	public void LerJson(String nameJson) throws IOException, ParseException {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("C:/Users/yohan/Desktop/workSpace/PortoSeguroCotacaoComJSON/src/test/java/cucumber/dados.json"));
			JSONObject jsonObject = (JSONObject) obj;
			nome = (String) jsonObject.get("nome");
			cpf = (String) jsonObject.get("cpf");
			email = (String) jsonObject.get("email");

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
