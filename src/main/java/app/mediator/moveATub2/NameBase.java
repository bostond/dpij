package app.mediator.moveATub2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Refactored from MoveATub. Challenges 10.1 and 10.2 we exercised on what would
 * change, but didn't ask for an implementation.
 * @author bostond
 *
 */

public class NameBase {
    private List boxes;
    
	protected Map<String, String> tubToMachine = null;

	public NameBase() {

		tubToMachine = new LinkedHashMap<String, String>();

		tubToMachine.put("T502", "Mixer-2201");
		tubToMachine.put("T503", "Mixer-2201");
		tubToMachine.put("T504", "Mixer-2201");
		tubToMachine.put("T101", "StarPress-2402");
		tubToMachine.put("T102", "StarPress-2402");
	
	}
 
    public Object[] boxes()
    {
        if (boxes == null) 
        {
            boxes = new ArrayList();
            boxes.add("Mixer-2201");
            boxes.add("Mixer-2202");  
            boxes.add("Fuser-2101");
            boxes.add("StarPress-2401");    
            boxes.add("StarPress-2402");
            boxes.add("Assembler-2301");
        }
        return boxes.toArray();
    }
    
    public Object[] tubNames(String machineName) {		
		Set<String> set = new LinkedHashSet<String>();
		Iterator<Map.Entry<String, String>> i = tubToMachine.entrySet().iterator();
		
		while (i.hasNext()) {
			Map.Entry<String, String> e = i.next();
			if (e.getValue().equals(machineName)) {
				set.add(e.getKey());
			}
		}
		
		return set.toArray();
		
	}

    public String getMachineContaining(String tubName) {
		return tubToMachine.get(tubName);
	}

    
	public void put(String tubName, String toMachineName) {
		tubToMachine.put(tubName, toMachineName);
	}
	
	

	
    
    
}
