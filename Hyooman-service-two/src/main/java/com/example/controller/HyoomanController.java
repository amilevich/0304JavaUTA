package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hyooman;

@RestController
@RequestMapping("/api")
public class HyoomanController {

	@GetMapping("/hyooman")
	public Hyooman getHyooman() {
		Hyooman h = new Hyooman("Empty String", "Tabitha");
		return h;
	}

}
