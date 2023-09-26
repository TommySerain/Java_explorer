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

    public void createFolder() {
        try {
            String name = this.path + this.fileName;

            File file = new File(name);
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("Le dossier a été créé avec succès.");
                } else {
                    System.out.println("Impossible de créer le dossier.");
                }
            } else {
                System.out.println("Le dossier existe déjà.");
            }
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de la création du dossier : " + e.getMessage());
        }
    }

    public void updateFileName(String newName) {
        try {
            String name = this.path + this.fileName;
            File file = new File(name);
            File newFile = new File(this.path, newName);
            file.renameTo(newFile);
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de la modification du fichier : " + e.getMessage());
        }
    }

    public void createFile() {
        try {
            String name = this.path + this.fileName;

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

    public void deleteFolderAndContents() {
        String name = this.path + this.fileName;
        File folder = new File(name);
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteFolderAndContents();
                    } else {
                        file.delete();
                    }
                }
            }
            folder.delete();
            System.out.println("Le dossier " + folder.getName() + " et son contenu ont été supprimés.");
        } else {
            System.out.println("Le dossier n'existe pas.");
        }
    }

    public void deleteFile() {
        try {
            String name = this.path + this.fileName;
            File file = new File(name);
            file.delete();
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de la suppression du fichier : " + e.getMessage());
        }
    }
}
