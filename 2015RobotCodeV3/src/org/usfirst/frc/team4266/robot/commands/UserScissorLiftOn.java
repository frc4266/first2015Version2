package org.usfirst.frc.team4266.robot.commands;

import org.usfirst.frc.team4266.robot.Robot;
import org.usfirst.frc.team4266.robot.subsystems.ScissorLifter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserScissorLiftOn extends Command {

	double power = 0;
	boolean isOn  = false;
	
    public UserScissorLiftOn(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.scissorLifter);
    	this.power = power;
    	isOn = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isOn = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.scissorLifter.drive(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !isOn;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("OFF");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	isOn = false;
    	
    }
}
