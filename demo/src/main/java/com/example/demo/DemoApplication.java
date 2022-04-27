package com.example.demo;


import com.example.demo.dao.ISautoRepository;
import com.example.demo.dao.ISmenetlevelRepository;
import com.example.demo.dao.ISnavRepository;
import com.example.demo.entity.ISauto;
import com.example.demo.entity.ISmenetlevel;
import com.example.demo.entity.ISnav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ISnavRepository isnavRepository;

	@Autowired
	ISautoRepository iSautoRepository;

	@Autowired
	ISmenetlevelRepository ismenetlevelRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("starting...");
	}

	@Override
	public void run(String... args) throws Exception
	{
		if (isnavRepository.findAll().size() == 0) {
			ISnav dizel = new ISnav(1,"Dízel",481);
			ISnav petrol = new ISnav(2,"Benzin",481);
			isnavRepository.saveAll(List.of(dizel,petrol));

			List<ISnav> navarak = isnavRepository.findAll();

			ISauto auto = null;
			ISauto auto1 = null;

			auto = new ISauto((long) 1, "AAA001", 5, "piros", 0, 0, new SimpleDateFormat("dd-MM-yyyy").parse("18-04-2016"), 4, navarak.get(0));
			auto1 = new ISauto((long) 2, "AAA002", 4, "szürke", 0, 0, new SimpleDateFormat("dd-MM-yyyy").parse("17-05-2016"), 7, navarak.get(1));

			iSautoRepository.saveAll(List.of(auto, auto1));
			List<ISauto> autok = iSautoRepository.findAll();

			ISmenetlevel menetlevel = null;
			ISmenetlevel menetlevel1 = null;
			ISmenetlevel menetlevel2 = null;

			menetlevel = new ISmenetlevel((long) 1, "Eger", "BudaPest ", "Nagy István", 139, "2022-04-24", 0, autok.get(0));
			menetlevel1 = new ISmenetlevel((long) 2, "Eger", "Debrecen ", "Nagy István", 131, "2022-04-24", 0, autok.get(1));
			menetlevel2 = new ISmenetlevel((long) 3, "Kisvárda", "Nyíregyháza ", "Nagy István", 43, "2022-04-24", 0, autok.get(0));

			ismenetlevelRepository.saveAll(List.of(menetlevel, menetlevel1, menetlevel2));
			}
		}



	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}


}
