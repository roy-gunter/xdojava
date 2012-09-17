//******************************************************************************
//  Provide cross-platform keystroke emulation for automation testing.
//
//  Requires Oracle Java SE 7u7 
//  http://www.oracle.com/technetwork/java/javase/downloads/index.html
//
//  Windows: Set default java as 1.7 in Control Panel | Java
//  Mac OSx: Set default java as 1.7 in Java Preferences
//  Linux:   Set default java as 1.7 using $ update-alternatives --config java
//
//  Compiling from ./java/src/ :
//      javac xdojava.java -d ../bin
//
//  Execution:
//      java -classpath <application root>/java/bin xdojava <options>
//
//******************************************************************************

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.io.*;
import java.util.*;

public class xdojava
{
    // CONSTANTS
    // Escape seq. ,  Keystroke         ,  Comment
    public String  ALT = "{ALT}"; // [Alt_L]           
    public String  ALT_GR = "{ALT_GR}"; // [ISO_Level3_Shift]
    public String  BACKSPACE = "{BACKSPACE}"; // [BackSpace]       
    public String  BS = "{BS}"; // [BackSpace]       
    public String  CTRL = "{CTRL}"; // [Control_L]       
    public String  DEL = "{DEL}"; // [Delete]          
    public String  ENTER = "{ENTER}"; // [Enter]             
    public String  END = "{END}"; // [End]             
    public String  ESC = "{ESC}"; // [Escape]          
    public String  HOME = "{HOME}"; // [Home]            
    public String  INS = "{INS}"; // [Insert]          
    public String  MENU = "{MENU}"; // [Menu]            
    public String  NUM_ADD = "{NUM_ADD}"; // [KP_Add]          
    public String  NUM_COMMA = "{NUM_COMMA}"; // [KP_Separator]    
    public String  NUM_DEL = "{NUM_DEL}"; // [KP_Delete]       
    public String  NUM_DIV = "{NUM_DIV}"; // [KP_Divide]       
    public String  NUM_ENTER = "{NUM_ENTER}"; // [KP_Enter]        
    public String  NUM_INS = "{NUM_INS}"; // [KP_Insert]       
    public String  NUM_MUL = "{NUM_MUL}"; // [KP_Multiply]     
    public String  NUM_SUB = "{NUM_SUB}"; // [KP_Subtract]     
    public String  NUM0 = "{NUM0}"; // [KP_0]..[KP_9]    
    public String  NUM1 = "{NUM1}"; // [KP_0]..[KP_9]    
    public String  NUM2 = "{NUM2}"; // [KP_0]..[KP_9]    
    public String  NUM3 = "{NUM3}"; // [KP_0]..[KP_9]    
    public String  NUM4 = "{NUM4}"; // [KP_0]..[KP_9]    
    public String  NUM5 = "{NUM5}"; // [KP_0]..[KP_9]    
    public String  NUM6 = "{NUM6}"; // [KP_0]..[KP_9]    
    public String  NUM7 = "{NUM7}"; // [KP_0]..[KP_9]    
    public String  NUM8 = "{NUM8}"; // [KP_0]..[KP_9]    
    public String  NUM9 = "{NUM9}"; // [KP_0]..[KP_9]    
    public String  PAUSE = "{PAUSE}"; // [Pause]           
    public String  PGDN = "{PGDN}"; // [Next]            
    public String  PGUP = "{PGUP}"; // [Prior]           
    public String  PRINT = "{PRINT}"; // [Print]           
    public String  SHIFT_TAB = "{SHIFT_TAB}"; // [Tab]             
    public String  SUPER = "{SUPER}"; // [Super_L]         
    public String  TAB = "{TAB}"; // [Tab]             
    public String  WIN = "{WIN}"; // [Super_L]         
    
    private Robot robot;
    
    public xdojava() throws AWTException
    {
        robot = new Robot();
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);
    }
  
    private void ActivateWindow(String windowTitle)
    {
        windowTitle = windowTitle.replaceAll("\"", "").trim();
        System.out.println(windowTitle);
    }
  
    private void SendKey(String keystring)
    {
        keystring = keystring.trim();
        
        if( keystring.equals("CONSTANTS") )
        {
            Constants();
        }
        else if( keystring.equals(ALT) )
        {
            Alt();
        }
        else if( keystring.equals(ENTER) )
        {
            Enter();
        }
        else if( keystring.equals(TAB) )
        {
            Tab();
        }
        else if( keystring.equals(SHIFT_TAB) )
        {
            ShiftTab();
        }
        else 
        {
            //Type each character individually
            byte[] byteArray = keystring.getBytes();
            for (byte byt : byteArray)  
            {
                int tempByt = (int)byt;
                if( tempByt == 32 )
                {
                    robot.keyPress(tempByt);
                    robot.keyRelease(tempByt);
                }
                else if( tempByt >= 48 && tempByt <= 57 )
                {
                    robot.keyPress(tempByt);
                    robot.keyRelease(tempByt);
                }
                else if( tempByt >= 65 && tempByt <= 90 )
                {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(tempByt);
                    robot.keyRelease(tempByt);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
                else if( tempByt >= 97 && tempByt <= 122 )
                {
                    tempByt = tempByt - 32;
                    robot.keyPress(tempByt);
                    robot.keyRelease(tempByt);
                }
                
            }
        }
    }
    
    private void Alt()
    {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }
    
    private void Enter()
    {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    private void Tab()
    {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }
    
    private void ShiftTab()
    {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }
    
    public void Constants()
    {
        System.out.println("Implemented");
        System.out.println("    ALT = {ALT}"); // [Alt_L]           
        System.out.println("    ENTER = {ENTER}"); // [Enter]                          
        System.out.println("    SHIFT_TAB = {SHIFT_TAB}"); // [Tab]             
        System.out.println("    TAB = {TAB}"); // [Tab]             
        System.out.println();
        
        System.out.println("Not Implemented");
        System.out.println("    ALT_GR = {ALT_GR}"); // [ISO_Level3_Shift]
        System.out.println("    BACKSPACE = {BACKSPACE}"); // [BackSpace]       
        System.out.println("    BS = {BS}"); // [BackSpace]       
        System.out.println("    CTRL = {CTRL}"); // [Control_L]       
        System.out.println("    DEL = {DEL}"); // [Delete]          
        System.out.println("    END = {END}"); // [End]
        System.out.println("    ESC = {ESC}"); // [Escape]          
        System.out.println("    HOME = {HOME}"); // [Home]            
        System.out.println("    INS = {INS}"); // [Insert]          
        System.out.println("    MENU = {MENU}"); // [Menu]            
        System.out.println("    NUM_ADD = {NUM_ADD}"); // [KP_Add]          
        System.out.println("    NUM_COMMA = {NUM_COMMA}"); // [KP_Separator]    
        System.out.println("    NUM_DEL = {NUM_DEL}"); // [KP_Delete]       
        System.out.println("    NUM_DIV = {NUM_DIV}"); // [KP_Divide]       
        System.out.println("    NUM_ENTER = {NUM_ENTER}"); // [KP_Enter]        
        System.out.println("    NUM_INS = {NUM_INS}"); // [KP_Insert]       
        System.out.println("    NUM_MUL = {NUM_MUL}"); // [KP_Multiply]     
        System.out.println("    NUM_SUB = {NUM_SUB}"); // [KP_Subtract]     
        System.out.println("    NUM0 = {NUM0}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM1 = {NUM1}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM2 = {NUM2}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM3 = {NUM3}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM4 = {NUM4}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM5 = {NUM5}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM6 = {NUM6}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM7 = {NUM7}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM8 = {NUM8}"); // [KP_0]..[KP_9]    
        System.out.println("    NUM9 = {NUM9}"); // [KP_0]..[KP_9]    
        System.out.println("    PAUSE = {PAUSE}"); // [Pause]           
        System.out.println("    PGDN = {PGDN}"); // [Next]            
        System.out.println("    PGUP = {PGUP}"); // [Prior]           
        System.out.println("    PRINT = {PRINT}"); // [Print]           
        System.out.println("    SUPER = {SUPER}"); // [Super_L]         
        System.out.println("    WIN = {WIN}"); // [Super_L]         
    }
   
    public static void main(String[] args)  throws AWTException
    {
        if( args.length == 0 )
        {
            Help();
            System.exit(0);
        }
        
        if( args.length > 0 )
        {
            if( args[0].startsWith("-h"))
            {
                Help();
                System.exit(0);
            }
        }
        
        xdojava XdoJava = new xdojava();
        String argString = new String();
    
        if( args[0].startsWith("-w"))
        {
            if( args.length > 1 )
            {
                for( int i = 1; i < args.length; i++)
                {
                    argString = argString + " " + args[i];
                }
                XdoJava.ActivateWindow(argString);
            }
            else
            {
                System.exit(0);
            }
        }
        else
        {
            for( int i = 0; i < args.length; i++)
            {
                argString = argString + " " + args[i];
            }
            XdoJava.SendKey(argString);            
        }

    }
    
    public static void Help()
    {
        System.out.println("java xdojava CONSTANTS          to list special character constants");
        System.out.println("java xdojava <string>           to send <string> to active window");
        System.out.println("                                currently only alpha-numerics");
        System.out.println("java xdojava <CONSTANT>         to send special character <CONSTANT>");
        System.out.println("                                to active window");
        //System.out.println("java xdojava -w <window name>   to make <window name> the active window");
        System.out.println("java xdojava -h                 for this help");
    }
    
}


