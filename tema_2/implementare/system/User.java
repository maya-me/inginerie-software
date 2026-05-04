package tema2.implementare.system;

import java.util.ArrayList;
import java.util.List;

public class User {
  List<WeatherApp> apps;
  private Location selectedLocation;

  public User() { this.apps = new ArrayList<>(); }

  public void subscribeToApp(WeatherApp app) {
    boolean accepted = app.addUser(this);
    if (accepted)
      this.apps.add(app);
  }

  public void setSelectedLocation(Location selectedLocation) {
    this.selectedLocation = selectedLocation;
  }

  public Location getSelectedLocation() {
    return this.selectedLocation;
  }

  public void receiveNotification(RealTimeData data) {
    
  }

  public void receiveAlert() {
    
  }
}
