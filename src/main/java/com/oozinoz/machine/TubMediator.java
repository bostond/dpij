package com.oozinoz.machine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Challenge 10.4 (+class, + getMachine(), + setMachine())
 * @author bostond
 *
 */

public class TubMediator {

	protected Map<Tub, Machine> tubToMachine = new HashMap<Tub, Machine>();
	
	public Machine getMachine(Tub t) {
		return tubToMachine.get(t);
	}
	
	public Set<Tub> getTubs(Machine m) {
		
		Set<Tub> set = new HashSet<Tub>();
		Iterator<Map.Entry<Tub, Machine>> i = tubToMachine.entrySet().iterator();
		
		while (i.hasNext()) {
			Map.Entry<Tub, Machine> e = i.next();
			if (e.getValue().equals(m)) {
				set.add(e.getKey());
			}
		}
		
		return set;
		
	}
	
	public void set(Tub t, Machine m) {
		tubToMachine.put(t, m);
	}
	
	
}
