/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.io.Serializable;

public class SignupUserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;

    public SignupUserBean() {
        this.id = "";
        this.name = "";
    }
    
    public SignupUserBean(String id, String password) {
        this.id = id;
        this.name = name;
    }
    
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
       return this.name;
    }
    
}
