package it.imperato.test.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class, AppConfig2.class})
@ContextConfiguration(locations = {
        "classpath:test-app-config.xml",
        "classpath:test-applicationContext.xml",
        "classpath:test-persistence-config.xml",
        "classpath:test-security-config.xml"})
public class PasswordBCryptTest {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordBCryptTest.class);

    @Test
    public void bCryptTest() {

    	int i = 0;
		while (i < 5) {
			String password = "password";
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			log.info(hashedPassword);
			
			i++;
		}

    }
}
