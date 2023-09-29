package co.simplon.alt6.Class;

import java.io.File;

public class Navigate {

    String path;

    public Navigate(String path) {
        this.path = path;
    }

    public String[] ShowFilesList() {
        String[] pathnames;
        File file = new File(this.path);
        pathnames = file.list();

        return pathnames;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
