package login;

import java.io.Serializable;

public class LoginUserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public LoginUserBean() {
        this.id = "";
        this.name = "";
    }

    public LoginUserBean(String id, String password) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return this.name;
    }

}