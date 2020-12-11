package dataflow.abs;

import java.util.HashMap;
import java.util.Map; 


public class ZeroAbstractSet {

	private final HashMap<String, ZeroAbstractValue> map;


	public ZeroAbstractSet(){
		this.map = new HashMap<String, ZeroAbstractValue>();
	}

	public Boolean hasValue(String variable){
		return this.map.containsKey(variable);
	}


	public ZeroAbstractValue getValue(String variable){
		return this.map.get(variable);
	}

	public void setValue(String variable, ZeroAbstractValue value) {
	  if (value != null) {
	    this.map.put(variable, value);
	  }
	}

	public ZeroAbstractSet union(ZeroAbstractSet another){
		// Instanciar un nuevo ZeroAbstractSet
	    ZeroAbstractSet result = new ZeroAbstractSet();

	    // Copiar el conjunto actual
	    result.putAll(this);

	    // Recorrer el otro y mergearlo con el resultante
	    for (Map.Entry<String,ZeroAbstractValue> entry : another.map.entrySet()) {
            String key = entry.getKey();
            ZeroAbstractValue val = entry.getValue();

            // Si existe la clave, se mergean
            if (result.hasValue(key))
            	val = result.getValue(key).merge(val);
            
            // Agregar la clave, haya sido mergeada o no
            result.setValue(key, val);
	    }
	    return result;

	}

	public void clear(){
		this.map.clear();
	}

	public void putAll(ZeroAbstractSet another){
		this.map.putAll(another.map);
	}

}
