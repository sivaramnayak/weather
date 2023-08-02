import axios from "axios";
class WeatherService
{
    static getDetails(v1)
    {
        return axios.get(`http://localhost:8080/weather/${v1}`);
    }
}
export default WeatherService;