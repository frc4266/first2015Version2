package org.usfirst.frc.team4266.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class ScissorLifter extends PIDSubsystem {
	
	public static final double LOAD_SETPOINT = 1;
	public static final double SCORING_SETPOINT = 2;
	public static final double STEP_SETPOINT = 3;
	
	private Potentiometer pot;
	
	public ScissorLifter() {
		super("ScissorLifter", 0.0, 0.0, 0.0);
		setAbsoluteTolerance(0.005);
		getPIDController().setContinuous(false);
		//pot = new AnalogPotentiometer(1); 
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		//return pot.get();
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
		//motor.pidWrite(output);
		
	}
	
	public double getAngle() {
		return pot.get();
	}
}

