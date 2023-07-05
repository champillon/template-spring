package demo.pt.templatespring.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/system")
public class SystemController {

    	@Autowired
	BuildProperties buildProperties;

	@Autowired
    	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LogManager.getLogger(SystemController.class);

    @GetMapping("/version")
	@PostConstruct
	public String version() {
		final String appName = buildProperties.getName();
		final String appVersion = buildProperties.getVersion();
		final String result = "application: " + appName + " version: " + appVersion;
		String uri = "http://localhost:5000/WeatherForecast";
		String sql = "SELECT COUNT(datname) FROM pg_catalog.pg_database";

        RestTemplate restTemplate = new RestTemplate();
        String weatherForecast = restTemplate.getForObject(uri, String.class);

	int countDB =  jdbcTemplate.queryForObject(sql, Integer.class);

        logger.info(result+" "+countDB+" "+weatherForecast);
		
		return result;
	}
    
}
