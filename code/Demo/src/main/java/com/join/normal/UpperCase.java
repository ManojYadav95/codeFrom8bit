package com.join.normal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UpperCase 
{
	@GetMapping("/ss")
	public String upper(@RequestParam String str)
	{
		return (str.toUpperCase());
	}
}
