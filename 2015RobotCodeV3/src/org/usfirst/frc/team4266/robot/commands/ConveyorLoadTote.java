package org.usfirst.frc.team4266.robot.commands;

import org.usfirst.frc.team4266.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorLoadTote extends Command {

    public ConveyorLoadTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.isLoadingTote = true;
    	Robot.conveyor.onToLoadTote();;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.conveyor.hasTote();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.conveyor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
