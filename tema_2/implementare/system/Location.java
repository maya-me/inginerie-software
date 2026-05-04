package tema2.implementare.system;

import java.util.Objects;

public final class Location {

  public static enum LatCoordinates { N, S }
  ;
  public static enum LongCoordinates { W, E }
  ;

  private double latitude;
  private double longitude;
  private LatCoordinates latCoordinate;
  private LongCoordinates longCoordinate;

  public Location(double latitude, double longitude,
                  LatCoordinates latCoordinate,
                  LongCoordinates longCoordinate) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.latCoordinate = latCoordinate;
    this.longCoordinate = longCoordinate;
  }

  public double getLatitude() { return this.latitude; }

  public double getLongitude() { return this.longitude; }

  public LatCoordinates getLatCoordinate() { return this.latCoordinate; }

  public LongCoordinates getLongCoordinate() { return this.longCoordinate; }

  public void setLatitude(double latitude) { this.latitude = latitude; }

  public void setLongitude(double longitude) { this.longitude = longitude; }

  public void setLatCoordinate(LatCoordinates latCoordinate) { this.latCoordinate = latCoordinate; }

  public void setLongCoordinate(LongCoordinates longCoordinate) { this.longCoordinate = longCoordinate; }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !this.getClass().equals(obj.getClass())) {
      return false;
    }
    Location location = (Location) obj;
    return Objects.equals(this.latitude, location.getLatitude())
        && Objects.equals(this.longitude, location.getLongitude())
        && Objects.equals(this.latCoordinate, location.getLatCoordinate())
        && Objects.equals(this.longCoordinate, location.getLongCoordinate());
  }
}
