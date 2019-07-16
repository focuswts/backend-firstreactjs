package br.com.bgt.firstsystem;


import ch.vorburger.mariadb4j.MariaDB4jService;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FirstsystemApplication implements ExitCodeGenerator {


    private final MariaDB4jSpringService mariaDB4j;

    @Autowired
    public FirstsystemApplication(MariaDB4jSpringService mariaDB4j) {
        this.mariaDB4j = mariaDB4j;
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(FirstsystemApplication.class);
        app.setBannerMode(Mode.OFF);
        ConfigurableApplicationContext ctx = app.run(args);
        MariaDB4jService.waitForKeyPressToCleanlyExit();
        ctx.stop();
        ctx.close();

    }


    @Override
    public int getExitCode() {
        return mariaDB4j.getLastException() == null ? 0 : -1;
    }

}
