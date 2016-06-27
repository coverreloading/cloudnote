
/*
* sql:id file_name file_url del_or_not file_time user_id
* */

package com.cloudnote.entity;

public class UserFile extends IdEntity {
    private String fileName;
    private String content;
    private String fileUrl;
    private int delOrNot;
    private String fileTime;
    private long userId;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDelOrNot() {
        return delOrNot;
    }

    public void setDelOrNot(int delOrNot) {
        this.delOrNot = delOrNot;
    }

    public String getFileTime() {
        return fileTime;
    }

    public void setFileTime(String fileTime) {
        this.fileTime = fileTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserFile{" +
                "fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                ", delOrNot=" + delOrNot +
                ", fileTime='" + fileTime + '\'' +
                ", userId=" + userId +
                '}';
    }


}
