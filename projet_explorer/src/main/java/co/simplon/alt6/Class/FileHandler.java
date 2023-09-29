package co.simplon.alt6.Class;

import java.io.File;
import java.sql.Date;

public class FileHandler {
    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    public String properties(String fileName) {
        String name = this.path + fileName;
        File file = new File(name);
        if (file.exists()) {
            String fileNameProp = file.getName();
            long fileSize = file.length();
            String absolutePath = file.getAbsolutePath();
            Date lastModified = new Date(file.lastModified());
            return "Nom du fichier : " + fileNameProp + "\n" + "Taille du fichier : " + fileSize + " octets\n"
                    + "Chemin absolu du fichier : " + absolutePath + "\n" + "Derniere modification du fichier : "
                    + lastModified;
        } else {
            return "Le fichier n'existe pas.";
        }
    }

    public boolean createFolder(String folderName) {
        try {
            String name = this.path + folderName;

            File file = new File(name);
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("Le dossier a été créé avec succès.");
                    return true;
                } else {
                    System.out.println("Impossible de créer le dossier.");
                }
            } else {
                System.out.println("Le dossier existe déjà.");
            }
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de la création du dossier : " + e.getMessage());
        }
        return false;
    }

    public boolean updateFileName(String filename, String newName) {
        try {
            String name = this.path + filename;
            File file = new File(name);
            File newFile = new File(this.path, newName);
            if (file.renameTo(newFile)) {
                return true;
            }
            ;
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de la modification du fichier : " + e.getMessage());
        }
        return false;
    }

    public boolean createFile(String fileName) {
        try {
            String name = this.path + fileName;

            File file = new File(name);
            if (!file.exists()) {
                // Créez le fichier
                if (file.createNewFile()) {
                    System.out.println("Le fichier a été créé avec succès.");
                    return true;
                } else {
                    System.out.println("Impossible de créer le fichier.");
                }
            } else {
                System.out.println("Le fichier existe déjà.");
            }
        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de la création du fichier : " + e.getMessage());
        }
        return false;
    }

    public boolean deleteFolderAndContents(String folderName) {
        String name = this.path + folderName;
        File folder = new File(name);
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        this.path += folderName + "/";
                        System.out.println("Nous rentrons dans " + file.getName());
                        deleteFolderAndContents(file.getName());
                    } else {
                        file.delete();
                        System.out.println("Le fichier " + file.getName() + " a été supprimés.");
                        return true;
                    }
                }
            }
            folder.delete();
            System.out.println("Le dossier " + folder.getName() + " et son contenu ont été supprimés.");
            return true;
        } else {
            System.out.println("Le dossier n'existe pas.");
        }
        return false;
    }
}
