package demo.pt.templatespring.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
	BuildProperties buildProperties;

	private static final Logger logger = LogManager.getLogger(SystemController.class);

    @GetMapping("/version")
	@PostConstruct
	public String version() {
		final var appName = buildProperties.getName();
		final var appVersion = buildProperties.getVersion();
		final var result = "application: " + appName + " version: " + appVersion;

		logger.info(result);
		return result;
	}
    
}
