package com.weather.demo.controller;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.weather.demo.service.weatherService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class weatherController {

	@Autowired
	weatherService Service;
	
	@GetMapping(value="/weather/{city}",produces="application/json")
	public ResponseEntity<String> getResult(@PathVariable String city)
	{
		JSONObject obj=Service.getWeather(city);
		if(obj.length()>1)
		{
			return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Weather data not found",HttpStatus.NOT_FOUND);
		}
	}
}
