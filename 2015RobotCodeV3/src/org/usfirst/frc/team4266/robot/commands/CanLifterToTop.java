package org.usfirst.frc.team4266.robot.commands;

import org.usfirst.frc.team4266.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CanLifterToTop extends Command {

    public CanLifterToTop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.canLifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.canLifter.raise();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.canLifter.isAtUpperLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.canLifter.stop();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
