package tema2.implementare.system;

import java.util.List;
import java.util.Objects;

public abstract class Sensor {
  protected List<WeatherApp> apps;
  protected String name;
  protected Location location;
  protected double monthlyFee;
  protected RealTimeData realTimeData;

  public Sensor(String name, Location location, double monthlyFee) {
    this.name = name;
    this.location = location;
    this.monthlyFee = monthlyFee;
  }

  public List<WeatherApp> getApps() { return this.apps; }

  // PARADOX - sensor is not allowed to push directly inside an app
  // cuz it may be harmful. Server has to do this -- OOP
  public void pushNotifications() {
    realTimeData.setLocation(this.location);
    apps.stream().forEach((app) -> { app.receiveData(realTimeData); });
  }

  public String getName() { return this.name; }

  public double getMonthlyFee() { return this.monthlyFee; }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !this.getClass().equals(obj.getClass())) {
      return false;
    }
    Sensor sensor = (Sensor)obj;
    return Objects.equals(this.name, sensor.getName());
  }
}

/* getData() {
  while (true) {
      if (newDataFound) {
        // construct the RealTimeData object
        pushNotification();
      }
  }
} */