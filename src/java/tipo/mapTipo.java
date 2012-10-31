/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

import java.io.Serializable;

/**
 *
 * @author discover
 */
public class mapTipo<k extends Serializable, v extends Serializable> implements Serializable {

    private k key;
    
    private v value;

    public mapTipo() {
    }

    public mapTipo(k key, v value) {
        this.key = key;
        this.value = value;
    }

    public k getKey() {
        return key;
    }

    public void setKey(k key) {
        this.key = key;
    }

    public v getValue() {
        return value;
    }

    public void setValue(v value) {
        this.value = value;
    }
    
    
    
    

    
}
