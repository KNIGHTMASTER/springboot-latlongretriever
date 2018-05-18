package com.zisal.latlongretriever.springbootlatlongretriever;

import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootLatlongretrieverApplication {

	@Autowired
	private LatLongRetriever latLongRetriever;

	@Autowired
	private FileReaderSpbu fileReaderSpbu;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLatlongretrieverApplication.class, args);
	}


	@Bean
	public CommandLineRunner runApp() {
		return args -> {
			List<String> spbuList = fileReaderSpbu.getSpbuName();
			for (String spbuName : spbuList) {
				LatLng latLng = latLongRetriever.getLatLng(latLongRetriever.retrieve(spbuName));
				System.out.println("Retrieved Lat Lng : "+latLng.toString());
			}
		};
	}
}
