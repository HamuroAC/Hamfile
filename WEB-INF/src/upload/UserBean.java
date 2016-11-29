package upload;

import java.io.Serializable;

public class UserBean implements Serializable {

    private static String id;
    private static String name;
    private static String imagePath;

    //reset
    public void UserBean() {
        this.id = "";
        this.name = "";
        this.imagePath = "";
    }

    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getImagePath() {
        return this.imagePath;
    }

 
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}