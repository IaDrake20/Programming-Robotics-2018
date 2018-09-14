package org.usfirst.frc.team3062.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class TestSolonoidsLimitSwitches extends Subsystem {
	
	
	DigitalInput lim;
	DigitalInput hal;
	
	Spark sparky;
	Spark sparky2;
	Spark lifty;
	Spark lifty2;
	
	DoubleSolenoid openSolo;
	DoubleSolenoid closeSolo;

	public TestSolonoidsLimitSwitches(){
		System.out.println("ID: constructor called");
		//tLimit = new DigitalInput(0);
		//testSwitch= new DigitalInput(1);
		
		sparky = new Spark(6);
		//sparky2 = new Spark(5);
		
		lifty = new Spark(5);
		//lifty2 = new Spark(6);
		
		//lim = new DigitalInput(0);
		//hal = new DigitalInput(2);
		
		
		openSolo = new DoubleSolenoid(0,1);//(8,2,3)
		//closeSolo = new DoubleSolenoid(3,2);//(8,2,3)
		
		//c = new Compressor(1);
		//c.setClosedLoopControl(true);
		//c.start();
		
		//openSolo.set(DoubleSolenoid.Value.kForward);	
	}
	
	public void extendIntake() {
		
		openSolo.set(DoubleSolenoid.Value.kForward);
		closeSolo.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void retractIntake() {
		
		openSolo.set(DoubleSolenoid.Value.kReverse);
		closeSolo.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public void grabIntake() {
		
		sparky.set(-.4);//-.50);
		sparky2.set(.4);
		
		//openSolo.set(DoubleSolenoid.Value.kReverse);
		//closeSolo.set(DoubleSolenoid.Value.kForward);
	}
	
	public void shootIntake() {
		
		sparky.set(.4);//.35);
		sparky2.set(-.4);//-.35);
		
		//openSolo.set(DoubleSolenoid.Value.kForward);
		//closeSolo.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopIntake() {
		
		sparky.set(.05);//.35);
		sparky2.set(-.05);//-.35);
		
	}
	
	public void liftUp() {
		
		lifty.set(.4);
		//lifty2.set(.3);
		
	}
	
	public void liftStop() {
		
		lifty.set(0);
		//lifty2.set(0);
		
		//sparky.set(0);
		//sparky2.set(0);
		
	
	}
	
	public void liftDown() {
		
		lifty.set(-.4);
		//lifty2.set(-.3);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void justOpenSoloForward() {
		
		openSolo.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void justCloseSoloForward() {
		
		closeSolo.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void justOpenSoloReverse() {
		
		openSolo.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public void justCloseSoloReverse() {
		
		closeSolo.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public boolean getLim() {
		
		return lim.get();
	}
	
	public boolean getHal() {
		
		return hal.get();
	}

	//.
}
