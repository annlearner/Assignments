package assginment7;

public class Controller extends Thread{
	static Device device;
	static Sensor heat;
	static Sensor pressure;
	static double resValue;
	//poll the sensors concurrently to running the device
   public Controller(Device device,Sensor heat,Sensor pressure){
	   this.device = device;
	   this.heat = heat;
	   this.pressure = pressure;
   }
  
   public void run(){ 
	    device.startup();
	    //controller shuts down the device if the heat sensor exceeds the value 70 or the pressure sensor the value 100.
	   synchronized (Sensor.class) {
	       while(true){
	    		if(pressure.value > 100 || heat.value > 70){
	    		
	    			System.out.println("heat ->" + heat.value + "pressure ->" + pressure.value);
	    			device.shutdown();	
	    			break;
	    		}else{
	    			System.out.println("heat ->" + heat.value + "pressure ->" + pressure.value);
	    			try {
	    				Sensor.class.wait();
	    			}catch(InterruptedException e) {
					// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		
	    	}
	    }
   }
   }
}