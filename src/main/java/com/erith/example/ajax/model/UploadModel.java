package com.erith.example.ajax.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadModel {

    private String extraField;

    private MultipartFile[] files;

    //getters and setters
    public String getExtraField() {
        return extraField;
    }

    public void setExtraField(String extraField) {
        this.extraField = extraField;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}