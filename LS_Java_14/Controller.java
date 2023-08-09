package LS_Java_14;

import java.io.IOException;

public class Controller {
    private WorkingWithAProfile profile = new Model();

   
    public void addUser() throws IOException {
        try {
            profile.SaveProfile(profile.addProfile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
