package org.usfirst.frc.team4266.robot.commands;

import org.usfirst.frc.team4266.robot.Robot;
import org.usfirst.frc.team4266.robot.subsystems.ScissorLifter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UserClawOff extends Command {

    public UserClawOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.canClaw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.canClaw.stop();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
