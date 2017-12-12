package assignment6;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

	@Test
	public void test() {
		HashMap<String,Userdata> map = new  HashMap<String,Userdata>();
		Atm atm = new Atm(2, 0.04, map);
		
		String input2 = "457-345-2876";
		String input3 = "146789";
		Assert.assertEquals(input3, map.get(input2));
		
		String input4 = "437-323-2356";
		String input5 = "012345";
		Assert.assertEquals(input4, map.get(input5));
		
		String input7 = "700.0";
		String eo = "1179.0";
		String Output1 = String.valueOf(atm.base);
		Assert.assertEquals(eo, Output1);

		String input8 = "300.0";
		String eo1 = "843.63";
		String Output2 = String.valueOf(atm.base);
		Assert.assertEquals(eo1, Output2);
		
		String[] eo9 = {"deposit +700.0", "withDrawal +400.0"};
		ArrayList<String> Output3 = atm.Trans;
		Assert.assertEquals(eo9, Output3);
		
		String eo10 = "843.63";
		String Output4 = String.valueOf(atm.base);
		Assert.assertEquals(eo10, Output4);
	}
} 
