public class Thermostat extends SmartDevice {
    private int temperature;
    
    public Thermostat(int id) {
        super(id, "thermostat");
        this.temperature = 70; // Default temperature
    }
    
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " is set to " + temperature + " degrees.");
    }
    
    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is now active.");
    }
    
    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is now inactive.");
    }
    
    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees.";
    }
    
    public int getTemperature() {
        return temperature;
    }
}
