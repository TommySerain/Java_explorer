package co.simplon.alt6.Class;

import java.io.File;

public class FileHandler {
    private String path;
    private String fileName;

    public FileHandler(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public void read() {

    }

    public void updateFileName() {

    }

    public void create() {
        try {
            String name = this.path + this.fileName;
            // Créez un objet File pour représenter le fichier
            System.out.println(this.path);
            System.out.println(this.fileName);
            File file = new File(name);
            if (!file.exists()) {
                // Créez le fichier
                if (file.createNewFile()) {
                    System.out.println("Le fichier a été créé avec succès.");
                } else {
                    System.out.println("Impossible de créer le fichier.");
                }
            } else {
                System.out.println("Le fichier existe déjà.");
            }
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de la création du fichier : " + e.getMessage());
        }
    }

    public void delete() {
        try {
            String name = this.path + this.fileName;
            File file = new File(name);
            file.delete();
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de la suppression du fichier : " + e.getMessage());
        }
    }
}
