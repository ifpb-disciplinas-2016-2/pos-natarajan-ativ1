/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketstcp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Natarajan
 */
public class Message {
    private String text;
    private int size; 
    private String name;

    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.size = this.text.length();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Message() {
    }
    
    
    
}
