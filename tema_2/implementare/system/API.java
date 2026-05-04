package tema2.implementare.system;

import java.util.ArrayList;
import java.util.List;

//!!!Singleton design pattern

public final class API {
  private static API instance = null;

  private List<WeatherApp> apps;
  private List<Sensor> sensors;

  private API() {
    this.apps = new ArrayList<>();
    this.sensors = new ArrayList<>();
  }

  public static API getInstance() {
    if (instance == null) {
      instance = new API();
    }
    return instance;
  }

  public List<WeatherApp> getApps() { return this.apps; }

  public List<Sensor> getSensors() { return this.sensors; }

  public void addApp(WeatherApp app) throws CustomError {
    apps.stream()
        .filter(el -> el.getClass().equals(app.getClass()))
        .findAny()
        .ifPresent(
            el -> { throw new CustomError("This weather app already exist"); });

    this.apps.add(app);
  }

  public void addSensor(Sensor sensor) {
    if (sensors.contains(sensor)) {
      throw new CustomError("");
    }

    this.sensors.add(sensor);
  }

  public static void subscribe(WeatherApp app, Sensor sensor)
      throws CustomError {

    if (app.getAmount() < sensor.getMonthlyFee()) {
      throw new CustomError("You can't subscribe!");
    }

    if (app.getSensors().contains(sensor)) {
      throw new CustomError("You already are subscribed to this sensor");
    }

    //substract amount
    app.subtractAmount(sensor.getMonthlyFee());

    app.addSensor(sensor);
  }
}
