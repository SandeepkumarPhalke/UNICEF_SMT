package runner;

import java.util.Base64;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;

public class Test extends PageObject{

	private static EnvironmentVariables environmentVariables;
	public static void main(String[] args) {
		
		String originalInput = "Test@123";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		
		System.out.println(encodedString);
		
//		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//		String decodedString = new String(decodedBytes);
		
		System.out.println(new String(Base64.getDecoder().decode(encodedString)));
	}

}
