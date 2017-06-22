package com.mycompany.googledriveuploader;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nickolas
 */
public class RobotUploader implements Runnable, FileOptions {

    private String location = "";
    private boolean singleFile= false;
    private String fileName = "";

    public RobotUploader(String location) {
        this.location = location;    
    }

    public RobotUploader(String location, boolean singleFile, String fileName){
        this.location = location;
        this.singleFile = singleFile;
        this.fileName = fileName;
    }
    

    @Override
    public void run() {
        
        if(this.singleFile){
            singleFile();
        }else{
            allFiles();
        }
        
    }

    @Override
    public void singleFile() {
        Robot robot;
        try {
            robot = new Robot();
            StringSelection stringSelection = new StringSelection(this.location);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);

            //Navigate to directory.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            
            stringSelection = new StringSelection(this.fileName);
            clipboard.setContents(stringSelection, stringSelection);
            //Enter the file name
            robot.keyPress(KeyEvent.VK_F3);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);          
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
        } catch (AWTException ex) {
            Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RobotUploader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void multiFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void allFiles() {
        Robot robot;
        try {
            robot = new Robot();
            StringSelection stringSelection = new StringSelection(location);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            
            
            robot.keyPress(KeyEvent.VK_F3);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_A);
            
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException ex) {
            Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RobotUploader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
