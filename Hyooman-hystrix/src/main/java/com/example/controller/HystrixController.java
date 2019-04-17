package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Hyooman;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api")
public class HystrixController {
	
	RestTemplate restTemp = new RestTemplate();
	
	@HystrixCommand(fallbackMethod="hystrixDefault")
	@GetMapping("/fetchhyoomans")
	public List<Hyooman> fetchHyoomans(){
		List<Hyooman> hList = restTemp.getForObject("http://localhost:8765/hyooman-service-one/api/allhyoomans/", List.class);
		return hList;
	}
	
	public List<Hyooman> hystrixDefault(){
		List<Hyooman> hList = new ArrayList<>();
		hList.add(new Hyooman("Pete","TJ"));
		return hList;
	}

}
