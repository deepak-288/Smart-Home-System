
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartHomeSystem {
    private final Map<Integer, SmartDevice> devices = new HashMap<>();
    private final List<Schedule> schedules = new ArrayList<>();
    private final List<Trigger> triggers = new ArrayList<>();
    
    // Add a device to the system
    public void addDevice(SmartDevice device) {
        devices.put(device.getId(), device);
    }
    
    // Remove a device from the system
    public void removeDevice(int deviceId) {
        devices.remove(deviceId);
    }
    
    // Turn a device on
    public void turnOn(int deviceId) {
        SmartDevice device = devices.get(deviceId);
        if (device != null) {
            device.turnOn();
        }
    }
    
    // Turn a device off
    public void turnOff(int deviceId) {
        SmartDevice device = devices.get(deviceId);
        if (device != null) {
            device.turnOff();
        }
    }
    
    // Set a schedule for a device
    public void setSchedule(int deviceId, String time, String command) {
        schedules.add(new Schedule(deviceId, time, command));
    }
    
    // Add a trigger to the system
    public void addTrigger(String condition, String action) {
        triggers.add(new Trigger(condition, action));
    }
    
    // Check triggers and execute actions if conditions are met
    public void checkTriggers() {
        for (Trigger trigger : triggers) {
            if (trigger.evaluate(devices)) {
                trigger.execute(this);
            }
        }
    }
    
    // Report status of all devices
    public String getStatus() {
        StringBuilder status = new StringBuilder();
        for (SmartDevice device : devices.values()) {
            status.append(device.getStatus()).append("\n");
        }
        return status.toString();
    }
    
    // Execute scheduled tasks based on the current time
    public void executeScheduledTasks(String currentTime) {
        for (Schedule schedule : schedules) {
            if (schedule.getTime().equals(currentTime)) {
                if (schedule.getCommand().equalsIgnoreCase("Turn On")) {
                    turnOn(schedule.getDeviceId());
                } else if (schedule.getCommand().equalsIgnoreCase("Turn Off")) {
                    turnOff(schedule.getDeviceId());
                }
            }
        }
    }

    public static void main(String[] args) {
        SmartHomeSystem system = new SmartHomeSystem();
        
        SmartDeviceFactory factory = new SmartDeviceFactory();
        SmartDevice light = factory.createDevice(1, "light");
        SmartDevice thermostat = factory.createDevice(2, "thermostat");
        SmartDevice doorLock = factory.createDevice(3, "door");
        
        system.addDevice(light);
        system.addDevice(thermostat);
        system.addDevice(doorLock);
        
        system.turnOn(1);
        system.setSchedule(2, "06:00", "Turn On");
        system.addTrigger("temperature > 75", "turnOff(1)");
        
        System.out.println(system.getStatus());
    }
}