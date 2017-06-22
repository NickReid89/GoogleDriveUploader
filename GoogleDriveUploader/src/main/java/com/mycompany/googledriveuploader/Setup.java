/*
Author: Nickolas Reid
Purpose: To provide a means to upload files effortlessly to a Google Drive account.
Usage: <email> <password> <overwrite (t or f)> <location> <filename (optional)>
 */
package com.mycompany.googledriveuploader;

import java.awt.AWTException;

public class Setup {

    public static void main(String[] args) throws InterruptedException, AWTException {

        //Object to store user info.
        UserData user = new UserData();
        user.setEmail(args[0]);
        user.setPassword(args[1]);
        user.setDirectory(args[3]);
        user.setOverwrite("t".equals(args[2].toLowerCase()));

        //Object designed to connect to Google Drive with user Info.
        new ConnectToDrive().upload(user);
    }

}
