/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.util;

import com.gyan.chatapp.entity.FileDemo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin_GYAN
 */
public class FileList {

    List<FileDemo> fileList = new ArrayList<>();

    public void addFile(FileDemo fileDemo) {
        fileList.add(fileDemo);
    }
 public void removeFle(FileDemo fileDemo){
        fileList.remove(fileDemo);
        
    }
    public List<FileDemo>getFile(){
        return fileList;
    }    
    public FileDemo getByfileName(String  fileName){
        for(FileDemo file:fileList){
           if(file.getFileName().endsWith(fileName)){
               return file;
               
               
           }
            }
        return null;
    }
    
}
