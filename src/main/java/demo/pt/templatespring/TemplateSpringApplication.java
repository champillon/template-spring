package demo.pt.templatespring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TemplateSpringApplication {

	@Autowired
	BuildProperties buildProperties;

	public static void main(String[] args) {
		SpringApplication.run(TemplateSpringApplication.class, args);
	}

	@GetMapping("/system/version")
	@PostConstruct
	public String version() {
		final var appName = buildProperties.getName();
		final var appVersion = buildProperties.getVersion();

		return "application: " + appName + " version: " + appVersion;
	}

}
