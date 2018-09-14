package org.usfirst.frc.team3062.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ChassisFeederExtension extends Subsystem{
	
	Spark lWheel;
	Spark rWheel;
	
	DoubleSolenoid lPiston;
	DoubleSolenoid rPiston;
	
	DigitalInput seatedLimit;
	
	public ChassisFeederExtension(){
		
		rWheel = new Spark(0);
		lWheel = new Spark(3);
		
		seatedLimit = new DigitalInput(5);
		
		lPiston = new DoubleSolenoid(0,1);
		rPiston = new DoubleSolenoid(2,3);
		
	}
	
public void extendIntake() {
		
		lPiston.set(DoubleSolenoid.Value.kForward);
		rPiston.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void retractIntake() {
		
		lPiston.set(DoubleSolenoid.Value.kReverse);
		rPiston.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public void grabIntake() {
		
		rWheel.set(-.4);//-.50);
		lWheel.set(.4);
		
		//openSolo.set(DoubleSolenoid.Value.kReverse);
		//closeSolo.set(DoubleSolenoid.Value.kForward);
	}
	
	public void shootIntake() {
		
		rWheel.set(.4);//.35);
		lWheel.set(-.4);//-.35);
		
		//openSolo.set(DoubleSolenoid.Value.kForward);
		//closeSolo.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopIntake() {
		
		rWheel.set(.05);//.35);
		lWheel.set(-.05);//-.35);
		
	}
	
	public boolean getSeatedLimit() {
		
		return seatedLimit.get();
	}
/*	ID
 * Compiler doesnt like the stack below so i commented it out for now for testing
 * 
 * 
 * public void runIntake() {
		
		if(rSeatedLimit.get() == false) {

			chassisIntakeLeft.set(.6);
			chassisIntakeRight.set(-.6);
			
			elevatorIntakeLeft.set(.6);
			elevatorIntakeRight.set(-.6);
			
			chassisIntakeRampLeft.set(.6);
			chassisIntakeRampRight.set(-.6);
		}
		
		if(rSeatedLimit.get() == false) {
			chassisIntakeLeft.set(0);
			chassisIntakeRight.set(0);
			
			elevatorIntakeLeft.set(0);
			elevatorIntakeRight.set(0);
			
			chassisIntakeRampLeft.set(0);
			chassisIntakeRampRight.set(0);
		}
	}
*/
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
