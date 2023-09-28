package co.simplon.alt6.Class;

import java.sql.Date;

public class FileProperties {
    private String fileName;
    private long fileSize;
    private String absolutePath;
    private Date lastModified;

    public FileProperties(String fileName, long fileSize, String absolutePath, Date lastModified) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.absolutePath = absolutePath;
        this.lastModified = lastModified;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
