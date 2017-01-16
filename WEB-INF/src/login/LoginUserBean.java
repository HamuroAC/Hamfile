package login;


import java.io.Serializable;


public class LoginUserBean implements Serializable {


    private static final long serialVersionUID = 1L;


    private String id;
    private String name;
    private String imagepath;
    private String profile;


    public LoginUserBean() {
    }


    public LoginUserBean(String id, String name,String imagepath,String profile) {
        this.id = id;
        this.name = name;
        this.imagepath = imagepath;
        this.profile = profile;
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

    public void setImagepath(String imagepath){
         this.imagepath=imagepath;
    }

    public String getImagepath(){
        return this.imagepath;
    }

    public void setProfile(String profile){
        this.profile=profile;
    }

    public String getProfile(){
        return this.profile;
    }



}