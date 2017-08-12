/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.entity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Admin_GYAN
 */
public class FileDemo {
    private Socket socket;
    private String fileName;
    private long fileSize;

    public FileDemo(Socket socket, String fileName, long fileSize) {
        this.socket = socket;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public FileDemo() {
    }

    public FileDemo(String fileName) {
        this.fileName = fileName;
    }

    public FileDemo(String fileName, long fileSize, Socket socket) {
        this.fileName = fileName;
        this.fileSize = fileSize;

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
    
    
    public void sendFile() throws FileNotFoundException, IOException{
        
    File myFile = new File("D://socket/gyan.pptx");
      byte[] mybytearray = new byte[(int) myFile.length()];
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
      bis.read(mybytearray, 0, mybytearray.length);
      OutputStream os = socket.getOutputStream();
      os.write(mybytearray, 0, mybytearray.length);
      
    }
}
