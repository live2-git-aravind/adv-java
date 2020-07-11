package java7;

import java.util.HashMap;
import java.util.Map;

public class example2_usinghashmap {

	public static void main(String[] args) {
		int i = 100;
		float f = 500.50f;
		boolean bool=true;
		char ch='A';
		
		Map<String,Object> map =new HashMap();
		map.put("Integer", new Integer(i));
		map.put("Float", new Float(f));
		map.put("Boolean", new Boolean(bool));
		map.put("Char", new Character(ch));
		
		System.out.println(map);
		map.clear();
		System.out.println(map);
	}

}
