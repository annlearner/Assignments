package assginment7;

public class Sensor extends Thread {
    private final Device device;
    double value;
    boolean change;
    public Sensor(Device device) {
        this.device = device;
    }
    public double getValue() {
        return value;
    }
    public void updateValue() { 
        this.value += 0.001; // you check with other values here and see how it works
    }
    public void run(){ 
    while(device.start){
    	updateValue();
    	synchronized (Sensor.class) {
    		Sensor.class.notify();
		}
   
    	
    }
    //and signals the controller if its value has changed.
    	
    }
}
