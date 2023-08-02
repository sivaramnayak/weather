package com.weather.demo.service;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
@Service
public class weatherService {

	private OkHttpClient client;
	private Response response;
	private String API="be73c793a2bce7f8830ad7bc329aace9";
	public JSONObject getWeather(String city)
	{
		client=new OkHttpClient();
		Request request=new Request.Builder()
				.url("https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid="+API)
				.build();
		try
		{
			response=client.newCall(request).execute();
			return new JSONObject(response.body().string());
		}
		catch(IOException e)
		{
			System.out.print("in catch");
			e.printStackTrace();
		}
		return null;
	}
}
