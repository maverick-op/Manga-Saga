package com.manga.saga;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.manga.saga.dao.UserRepository;
import com.manga.saga.entities.User;


@SpringBootApplication
@ComponentScan(basePackages = "com.manga.saga.*")
public class SagaApplication implements CommandLineRunner {
    
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
    public BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SagaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
			
		user.setId(1);
		user.setEmail("admin@saga.com");
		user.setEnable(true);
		user.setName("PRATYUSH PRATEEK");
		user.setPhone("1234567890");
		user.setRole("ROLE_ADMIN");
		user.setPassword(passwordEncoder.encode("admin"));
		user.setProfile("admin.png");
		user.setDate(new Date());
		
		this.userRepo.save(user);
		
		
		
	}

}
