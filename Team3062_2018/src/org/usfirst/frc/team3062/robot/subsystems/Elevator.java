package org.usfirst.frc.team3062.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	DigitalInput midLim;
	DigitalInput topLim;
	
	Spark lifty;
	
	public Elevator() {
		
		//midLim = new DigitalInput(1);
		//topLim = new DigitalInput(0);
		
		lifty = new Spark(1);
		
	}
	
	public void liftUp() {
		
		lifty.set(-1);
			
	}
	
	public void liftStop() {
		
		lifty.set(0);
		
	}
	
	public void liftDown() {
		
		lifty.set(.7);
	
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
	public boolean getLimit() {
		
		return topLim.get();
		
	}

}
