/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.Serializable;

/**
 *
 * @author nabana
 */
public class LoginUserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id_;
    private String name_;

    public LoginUserBean() {
        this.id_ = "";
        this.name_ = "";
    }
    
    public LoginUserBean(String id, String name) {
        this.id_ = id;
        this.name_ = name;
    }
    
    public void setId(String id){
        this.id_ = id;
    }
    public String getId(){
        return this.id_;
    }
    
    public void setName(String name){
        this.name_ = name;
    }
    public String getName(){
       return this.name_;
    }
    
}
