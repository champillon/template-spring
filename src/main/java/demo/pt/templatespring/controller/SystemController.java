package demo.pt.templatespring.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
	BuildProperties buildProperties;

    @GetMapping("/version")
	@PostConstruct
	public String version() {
		final var appName = buildProperties.getName();
		final var appVersion = buildProperties.getVersion();

		return "application: " + appName + " version: " + appVersion;
	}
    
}
