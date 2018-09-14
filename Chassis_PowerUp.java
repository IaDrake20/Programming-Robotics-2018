/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3062.robot.subsystems;

import org.usfirst.frc.team3062.robot.RobotMap;
import org.usfirst.frc.team3062.robot.commands.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Chassis_PowerUp extends Subsystem {
	// Put methods for controlling this subsystem

	// here. Call these from Commands.
	 MecanumDrive mechRobot; // class that handles basic drive operations
		// uses only four speed controllers


		WPI_TalonSRX  leftFront;
		WPI_TalonSRX  leftRear;
		WPI_TalonSRX  rightFront;
		WPI_TalonSRX  rightRear;
		
		Encoder eRight;
		Encoder eLeft;
		Spark spark;
		
		DigitalInput tl;
		DigitalInput ml;
		DigitalInput bl;
		
		
	public Chassis_PowerUp(){
		
		/*
		leftFront = new WPI_TalonSRX (3);
    	leftRear = new WPI_TalonSRX (1);
    	rightFront = new WPI_TalonSRX (0);
    	rightRear = new WPI_TalonSRX (2);
    	*/
		
		leftFront = new WPI_TalonSRX(3);
		leftRear = new WPI_TalonSRX(2);
		rightFront = new WPI_TalonSRX(4);
		rightRear = new WPI_TalonSRX(1);
		
    	//tl = new DigitalInput(2);
    	//ml = new DigitalInput(3);
		//bl = new DigitalInput(4);
    	
    	eRight = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
    	
    	eRight.setMaxPeriod(.1);
    	eRight.setMinRate(1);
    	eRight.setDistancePerPulse((Math.PI*6));
    	eRight.setReverseDirection(true);
    	eRight.setSamplesToAverage(10);
    	eRight.reset();
    	
    	/*
    	eLeft = new Encoder(8, 9, false, Encoder.EncodingType.k4X);
    	eLeft.setMaxPeriod(.1);
    	eLeft.setMinRate(1);
    	eLeft.setDistancePerPulse((Math.PI*6));
    	eLeft.setReverseDirection(true);
    	eLeft.setSamplesToAverage(10);
    	eLeft.reset();
    	*/
    	/*
    	OperatorControl(){
           
        }
    	*/
    	//spark = new Spark(0);
    	
    	//limit = new DigitalInput(0);
		
    	mechRobot = new MecanumDrive(leftFront, leftRear, rightFront, rightRear);
    	 
  	  System.out.println("ID:::::::::::: 1");
  	  
	}
	
	
	private void OperatorControl() {
		// TODO Auto-generated method stub
		
	}


	public void driver(double rf, double lf, double rr) {
		
		mechRobot.driveCartesian(rf, lf, rr);
		//rightRear.set(rf);
	}
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public void driveWithMeccanum(double strafeValue, double yValue, double turnValue) {
		mechRobot.driveCartesian(strafeValue, yValue, turnValue, 0);
	}
	
	public double getDistance() {
		int countRight = eRight.get();
		System.out.println("number of rotations" + countRight);
		double distanceRight = eRight.getRaw();
		System.out.println("Some distance" + distanceRight);
		double distance1Right = eRight.getDistance();
		System.out.println("Some other distance" + distance1Right);
		double rateRight = eRight.getRate();
		System.out.println("Speed" + rateRight);
		boolean directionRight= eRight.getDirection();
		System.out.println("direction" + directionRight);
		boolean stoppedRight = eRight.getStopped();
		System.out.println("state of robot" + stoppedRight);
		
		int countLeft = eRight.get();
		System.out.println("number of rotations" + countLeft);
		double distanceLeft = eRight.getRaw();
		System.out.println("Some distance" + distanceLeft);
		double distance1Left = eRight.getDistance();
		System.out.println("Some other distance" + distance1Left);
		double rateLeft = eRight.getRate();
		System.out.println("Speed" + rateLeft);
		boolean directionLeft = eRight.getDirection();
		System.out.println("direction" + directionLeft);
		boolean stoppedLeft = eRight.getStopped();
		System.out.println("state of robot" + stoppedLeft);
		
		return distance1Right;
		
	}
	
	public boolean getMidLimit() {
		
		return ml.get();
		
	}
	
	public boolean getTopLimit() {
		
		return tl.get();
		
	}
	
	public boolean getBotttomLimit() {
		
		return bl.get();
		
	}
	
	
	
	
}
