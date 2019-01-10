package org.usfirst.frc.team3062.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3062.robot.OI;

import org.usfirst.frc.team3062.robot.Robot;
//import org.usfirst.frc.team3062.robot.subsystems.Chassis;
import org.usfirst.frc.team3062.robot.subsystems.Chassis;

/**
 *
 */
public class DriveWithJoystick extends Command {

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() { //originaly protected, not static
    	
    	//Driver 1
    	
    	double leftSpeedDriver1 = Robot.oi.getLeftSpeedDriver1();
    	double rightSpeedDriver1 = Robot.oi.getRightSpeedDriver1();
    	System.out.println("Driver1's ::::::::::::::::::::::::::::::::::::::speed set");
    	
    	//Driver 2
    	double leftSpeedDriver2 = Robot.oi.getleftSpeedDriver2();
    	double rightSpeedDriver2 = Robot.oi.getrightSpeedDriver2();
    	System.out.println("Driver2's ::::::::::::::::::::::::::::::::::::::speed set");

    	
    	//Driver 1's joystick
    	if(leftSpeedDriver1 < .2 && leftSpeedDriver1 > -.2){
    		leftSpeedDriver1 = 0;
    	}
    	
    	System.out.println("entering if stack:::::::::::::::::::::::::");
    	if(rightSpeedDriver1 < .2 && rightSpeedDriver1 > -.2){
    		rightSpeedDriver1 = 0;
    	}
    	if(rightSpeedDriver1 > .8){
    		rightSpeedDriver1 = .6;
    	}
    	if(leftSpeedDriver1 > .8){
    		leftSpeedDriver1 = .6;
    	}
    	if(rightSpeedDriver1 < -.8){
    		rightSpeedDriver1 = .6;
    	}
    	if(leftSpeedDriver1 < -.8){
    		leftSpeedDriver1 = .6;
    	}
    	
    	//Driver 2's joystick
    	if(leftSpeedDriver2 < .2 && leftSpeedDriver2 > -.2){
    		leftSpeedDriver2 = 0;
    	}
    	
    	System.out.println("Entering D2's if stack:::::::::::::::::::::::::::::::::::::::::::");
    	if(rightSpeedDriver2 < .2 && rightSpeedDriver2 > -.2){
    		rightSpeedDriver2 = 0;
    	}
    	if(rightSpeedDriver2 > .8){
    		rightSpeedDriver2 = .6;
    	}
    	if(leftSpeedDriver2 > .8){
    		leftSpeedDriver2 = .6;
    	}
    	if(rightSpeedDriver2 < -.8){
    		rightSpeedDriver2 = .6;
    	}
    	if(leftSpeedDriver2 < -.8){
    		leftSpeedDriver2 = .6;
    	}
    	
    	// This might have been first if statement, like so:
    	// if( ( leftSpeed < -.2 || leftSpeed > .2 ) && ( rightSpeed < -.2 || rightSeed > .2 ) ) {
    	//Robot.chassis.driveWithJoystick1( leftSpeedDriver1, rightSpeedDriver1 );
    	//Robot.chassis.driveWithJoystick2( leftSpeedDriver2, rightSpeedDriver2 );

    	// }
    	// Might be wrong, though.
    	
    	//display? Need to find out what it does
    	SmartDashboard.putNumber("Left Speed", Robot.oi.getLeftSpeedDriver1());
    	SmartDashboard.putNumber("Right Speed", Robot.oi.getRightSpeedDriver1());
    	
    	
    	
    }    
    
   

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}