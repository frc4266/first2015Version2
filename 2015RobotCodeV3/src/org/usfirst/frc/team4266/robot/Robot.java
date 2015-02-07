
package org.usfirst.frc.team4266.robot;



import org.usfirst.frc.team4266.robot.commands.AutoDoNothing;
import org.usfirst.frc.team4266.robot.commands.AutoDriveToDistance;
import org.usfirst.frc.team4266.robot.subsystems.CanLifter;
import org.usfirst.frc.team4266.robot.subsystems.Conveyor;
import org.usfirst.frc.team4266.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4266.robot.subsystems.ScissorLifter;
import org.usfirst.frc.team4266.robot.subsystems.ToteLifter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//testing 1/31/20015

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */ 

/*
 * 2015RobotNotes
 * 
 * Subsystems
 * 1.) Drive train - two motors
 * 
 * 2.) Conveyor - 1 motor
 * 
 * 		on until a tote is loaded
 * 
 * 3.) toteLifter - 1 motor
 * 
 * 		position for highest point
 * 		position for lowest point
 *      
 * 
 * 4.) scissorLifter - 1 motor
 * 
 * 		position for feeding, 
 * 		position for step scoring, 
 * 		position  for scoring platform(Lowest)
 * 
 * 5.) canLifter - 2 motors
 * 		one motor up and down
			 
 * 		the other motor opens/closes on can
 */

/*
 * Loading Procedure
 * 1.) Scissor Lift to load position and toteLifter to top
 * 2.) Turn on conveyor until tote loaded then conveyor off
 * 3.) toteLifter to load position
 * 4.) toteLifter lift to top
 * 5.) repeat steps 2 to 5
 */
public class Robot extends IterativeRobot {
	
	public static boolean isLoadingTote = false;

	//Subsystems
	public static DriveTrain driveTrain;
	public static Conveyor conveyor;
	public static ScissorLifter scissorLifter;
	public static ToteLifter toteLifter;
	public static CanLifter canLifter;
	
	
	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

    Command autonomousCommand;
    public SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
		oi = new OI();
		
		//Create new subsystems
		driveTrain = new DriveTrain();
		
		SmartDashboard.putData(driveTrain);
		
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Drive to Auto Zone", new AutoDoNothing());
		autoChooser.addObject("Drive to Auto Zone", new AutoDriveToDistance(10,0.5));
		//autoChooser.addObject("Lift Can and Drive", new AutonomousLiftAndDrive());
		SmartDashboard.putData("Auto Mode", autoChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		updateData();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) autonomousCommand.start();
    	autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateData();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
       
        updateData();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    private void updateData() {
		
		//SmartDashboard.putNumber("Pivot Pot Value", Robot.pivot.getAngle());
		SmartDashboard.putNumber("Left Distance", Robot.driveTrain.getLeftEncoder().getDistance());
		SmartDashboard.putNumber("Right Distance", Robot.driveTrain.getRightEncoder().getDistance());
		SmartDashboard.putNumber("Distance", Robot.driveTrain.getDistance());
	}
}
