package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
//		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
//		String pass = "1111";
//		String maHoa = b.encode(pass);
//		System.out.print(maHoa);
	}
}
