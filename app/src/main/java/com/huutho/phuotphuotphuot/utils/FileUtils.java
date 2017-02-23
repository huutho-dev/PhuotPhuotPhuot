package com.huutho.phuotphuotphuot.utils;

import com.huutho.phuotphuotphuot.app.AppController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by nguyenhuutho on 2/2/17.
 */

public class FileUtils {

   public static void copyDatabase(String dbPath){
       try {
           InputStream inputStream = AppController.getInstance().getAssets().open("PhuotVietNam.sqlite");
           File file = new File(dbPath);
           if (!file.exists()) {
               File parent = file.getParentFile();  // lấy ra thằng file parent
               parent.mkdirs();                    // khởi tạo các folder cha chứa file
               file.createNewFile();

               FileOutputStream fileOutputStream = new FileOutputStream(file);
               byte[] b = new byte[1024];
               int count = inputStream.read(b);
               while (count != -1) {
                   fileOutputStream.write(b, 0, count);
                   count = inputStream.read(b);
               }
               fileOutputStream.close();
           }
           inputStream.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    public static boolean fileExist(String filePath){
        File file = new File(filePath);
        return file.exists();
    }
}
