package org.usfirst.frc.team4266.robot;

import org.usfirst.frc.team4266.robot.commands.LoadNextTote;
import org.usfirst.frc.team4266.robot.commands.UnloadTotes;
import org.usfirst.frc.team4266.robot.subsystems.ScissorLifter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(st ick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public static final Joystick driveStick = new Joystick(RobotMap.driveStick);
    public static final Joystick liftStick = new Joystick(RobotMap.joystick2);
    
    
    public static Button loadToteButton = new JoystickButton(driveStick,2);
    
    public static Button unLoadToStep = new JoystickButton(driveStick,3);
    
    public static Button unLoadToScoring = new JoystickButton(driveStick,1);
    
    public static Button stopLoading = new JoystickButton(driveStick,11);
    
    
    public OI (){
    	loadToteButton.whenPressed(new LoadNextTote());
    	unLoadToStep.whenPressed(new UnloadTotes(ScissorLifter.STEP_SETPOINT));
    	unLoadToScoring.whenPressed(new UnloadTotes(ScissorLifter.SCORING_SETPOINT));
    }
    
    /*
     * Three light sensors
     * Encoders - two new, two old encoders already on gear boxes
     * Six magnetic switches
     * 
     * 
     * 9 micro switches
     * 
     * 
     * 
     */
}

