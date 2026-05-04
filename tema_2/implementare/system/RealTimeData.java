package tema2.implementare.system;

public class RealTimeData {
  private double temperature;
  private double wind;
  private double humidity;
  private int precipitation;
  private double visibility;
  private double pressure;
  private int uvIndex;
  private Location location;

  private RealTimeData(Builder builder) {
    this.temperature = builder.temperature;
    this.wind = builder.wind;
    this.humidity = builder.humidity;
    this.precipitation = builder.precipitation;
    this.visibility = builder.visibility;
    this.pressure = builder.pressure;
    this.uvIndex = builder.uvIndex;
  }

  public static class Builder {
    private double temperature;
    private double wind;
    private double humidity;
    private int precipitation;
    private double visibility;
    private double pressure;
    private int uvIndex;

    public Builder temperature(double temperature) {
      this.temperature = temperature;
      return this;
    }

    public Builder wind(double wind) {
      this.wind = wind;
      return this;
    }

    public Builder humidity(double humidity) {
      this.humidity = humidity;
      return this;
    }

    public Builder precipitation(int precipitation) {
      this.precipitation = precipitation;
      return this;
    }

    public Builder visibility(double visibility) {
      this.visibility = visibility;
      return this;
    }

    public Builder pressure(double pressure) {
      this.pressure = pressure;
      return this;
    }

    public Builder uvIndex(int uvIndex) {
      this.uvIndex = uvIndex;
      return this;
    }

    public RealTimeData build() { return new RealTimeData(this); }
  }

  public void setLocation(Location location) { this.location = location; }

  public Location getLocation() { return this.location; }
}