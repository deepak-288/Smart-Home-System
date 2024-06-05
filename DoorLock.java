public class DoorLock extends SmartDevice {
    private boolean isLocked;
    
    public DoorLock(int id) {
        super(id, "door");
        this.isLocked = true;
    }
    
    @Override
    public void turnOn() {
        isLocked = false;
        System.out.println("Door " + id + " is unlocked.");
    }
    
    @Override
    public void turnOff() {
        isLocked = true;
        System.out.println("Door " + id + " is locked.");
    }
    
    @Override
    public String getStatus() {
        return "Door " + id + " is " + (isLocked ? "Locked" : "Unlocked");
    }
}
