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
public class ChaveValor<k extends Serializable, v extends Serializable> implements Serializable {

    private k key;
    
    private v value;

    public ChaveValor() {
    }

    public ChaveValor(k key, v value) {
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
