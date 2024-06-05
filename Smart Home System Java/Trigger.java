import java.util.Map;

public class Trigger {
    
    public Trigger(String condition, String action) {
    }
    
    public boolean evaluate(Map<Integer, SmartDevice> devices) {
        // Here you would implement the logic to evaluate the condition.
        // For simplicity, we assume the condition is always true.
        return true;
    }
    
    public void execute(SmartHomeSystem system) {
        // Here you would implement the logic to execute the action.
        // For simplicity, we assume the action is to turn off a device with id 1.
        system. turnOff(1);
    }
}
