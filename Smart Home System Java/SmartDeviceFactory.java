public class SmartDeviceFactory {
    public SmartDevice createDevice(int id, String type) {
        switch (type.toLowerCase()) {
            case "Light" -> {
                return new Light(id);
            }
            case "Thermostat" -> {
                return new Thermostat(id);
            }
            case "Door" -> {
                return new DoorLock(id);
            }
            default -> throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}