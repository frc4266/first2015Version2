package org.usfirst.frc.team4266.robot.commands;

import org.usfirst.frc.team4266.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserToteLifterOn extends Command {

	double power = 0;
	boolean isOn = false;
	
    public UserToteLifterOn(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.toteLifter);
    	this.power = power;
    	isOn = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isOn = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.toteLifter.drive(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !isOn;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	isOn = false;
    }
}
