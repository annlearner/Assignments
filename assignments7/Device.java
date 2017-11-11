package assginment7;

public class Device {
	boolean start = true;
	public void startup() { 
		start = true;
		System.out.println("device is starting");
	} // print to console that device is starting
    public void shutdown() { 
    	start = false;
    	System.out.println("Device shutting down due to maintenance");
    } // print to console that device is shutting down and exit

}
