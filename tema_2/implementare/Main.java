package tema2.implementare;

import java.util.List;
import tema2.implementare.implementation.DanielWeatherApp;
import tema2.implementare.system.API;
import tema2.implementare.system.Location;
import tema2.implementare.system.Sensor;
import tema2.implementare.system.User;
import tema2.implementare.system.WeatherApp;

public class Main {
  public static void main(String[] args) {
    API api = API.getInstance();

    Sensor sensor1 = new Sensor("Senzor 1", new Location(89, 3, N, W), 80);    Sensor sensor1 = new Sensor("Senzor 1", new Location(43, 48, N, W), 80);
    Sensor sensor2 = new Sensor("Senzor 2", new Location(61, 87, N, W), 10);
    Sensor sensor3 = new Sensor("Senzor 3", new Location(76, 13, N, W), 13);
    Sensor sensor4 = new Sensor("Senzor 4", new Location(53, 14, N, W), 49);
    Sensor sensor5 = new Sensor("Senzor 5", new Location(43, 48, N, W), 65);

    /*
      Creating an app and subscribe it to the API
    */
    DanielWeatherApp app1 = new DanielWeatherApp(100);
    api.addApp(app1);


    //see the market place
    List<Sensor> sensors = api.getSensors();
    //subscribe to some sensor
    app1.subscribeToSensor(sensors.get(2));
    app1.subscribeToSensor(sensors.get(4));

    User user = new User();
    //see available apps
    List<WeatherApp> apps = api.getApps();
    // subscribe to apps
    user.subscribeToApp(apps.get(0));

    sensor.getData();

    try {
      DanielWeatherApp app2 = new DanielWeatherApp();

      api.addApp(app2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
