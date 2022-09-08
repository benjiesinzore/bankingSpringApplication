package benjamin.sinzore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		try {
			SpringApplication.run(Application.class, args);
		} catch (Exception ee){
			ee.printStackTrace();
		}


	}

}
