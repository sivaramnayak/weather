import React, { useRef, useState } from "react";
import WeatherService from "./WeatherService";
import "./App.css";
const Weather = () => {
  const cityRef = useRef(null);
  const [elist, setElist] = useState(null);

  const getDetails = () => {
    let v1 = cityRef.current.value;
    WeatherService.getDetails(v1)
      .then(response => {
        if (response.data.cod === "404") {
          setElist({ cod: "404" }); 
        } else {
          setElist(response.data);
        }
      })
      .catch(error => {
        setElist(null);
      });
  };

  let message;
  if (elist === null) {
    message = "Enter a city and click Submit to get weather information.";
  } else if (elist.cod === "404") {
    message = "City not found.";
  }

  return (
    <div className="body">
      <h1>Check Your Location Weather Condition</h1>
      <form className="form">
        <input type="text" name="city" placeholder="enter the city" ref={cityRef} autoFocus />
        <br></br><button type="button" onClick={getDetails}>Submit</button>
      </form>
      <div className="title">{message}</div>
      {elist !== null && elist.cod !== "404" && (
        <div className="info">
          <h2>Weather Information</h2>
          <ul>
            <li>Temperature: {elist.main.temp}°C</li>
            <li>Pressure: {elist.main.pressure} hPa</li>
            <li>Humidity: {elist.main.humidity}%</li>
            <li>Weather Main: {elist.weather[0].main}</li>
          </ul>
        </div>
      )}
    </div>
  );
};

export default Weather;
