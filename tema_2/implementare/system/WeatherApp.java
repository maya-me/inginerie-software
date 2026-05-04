package tema2.implementare.system;

import java.util.ArrayList;
import java.util.List;

public abstract class WeatherApp {
  private List<Sensor> sensors;
  private List<User> users;
  private double amount;

  public WeatherApp(double amount) {
    this.sensors = new ArrayList<>();
    this.amount = amount;
  }

  public List<Sensor> getSensors() { return this.sensors; }

  public double getAmount() { return this.amount; }

  // not safe cuz its public
  // if we put it private API can't access it -- PARADOX
  public void subtractAmount(double tax) { this.amount -= tax; }

  public void addAmount(double extraAmount) { this.amount += extraAmount; }

  public void addSensor(Sensor sensor) { sensors.add(sensor); }

  public void subscribeToSensor(Sensor sensor) { API.subscribe(this, sensor); }

  public void receiveData(RealTimeData weatherData) {
    if (weatherData.alerta()) {
      boolean ok = true;
    }
      //compute grafic
    users.stream().forEach(user -> {
      // send data to user after prepare it
      if (user.getSelectedLocation().equals(weatherData.getLocation())) {
        // send it just if location is selected
        user.receiveNotification(weatherData);
      }
    });
  }

  public boolean addUser(User user) {
    // validare
    // wrong validation - return false;

    this.users.add(user);
    return true;
  }
}
