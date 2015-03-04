package org.usfirst.frc.team4266.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drive train subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a range finder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
    public static final int driveStick = 0;
    public static final int joystick2 = 1;
    
    // jaguars
    public static final int rightMotor   = 0;//green
    public static final int leftMotor  = 1;//blue
    public static final int conveyor   = 2;
     //talons
    public static final int toteLifter = 4;
    public static final int canLifter = 3;
    public static final int scissorLifter   = 5;   
    public static final int canClaw = 6;
    
    
   
    
    //pot
    public static final int pot = 1;
    
    //Limit Switches
    public static final int conveyorSwitch  = 1;
    
    public static final int scissorLifterScoringSwitch  = 2;
    public static final int scissorLifterStepSwitch  = 3;
    public static final int scissorLifterLoadingSwitch  = 4;
    
    public static final int toteLifterLowerSwitch  = 5;
    public static final int toteLifterUpperSwitch  = 6;
    
    public static final int canLifterLowerSwitch  = 7;
    public static final int canLifterUpperSwitch  = 8;
    
    //encoders
    public static final int toteEncoder1 = 0;
    public static final int toteEncoder2 = 1;
    public static final int leftEncoder1 = 13;
    public static final int leftEncoder2 = 14;
    
    
    
    
    
    
    
    
	
}
