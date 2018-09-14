package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithJoystick extends Command {
	
		public DriveWithJoystick() {
			// Use requires() here to declare subsystem dependencies
			requires(Robot.powerChassis);
		}

		
		 protected void execute() {
		    	
			    //	System.out.println("Drive");
			 
			 /*Swapped getStrafeSpeed and getXSpeed to fix the strafe to the proper stick. For some reason they are backwards.
			  * You can find the problem and fix it or leave it as is. 
			  * I also added a negative sign because they were running opposite the Left Right controls. Forward and Backward is correct.
			  * 
			  * Left and right are opposite when backing up. 
			  */ 	
			    	double ySpeed = Robot.oi.getYSpeed();// ySpeed stands for forward and backward movement
			    	double turnSpeed = -Robot.oi.getStrafeSpeed(); // strafeSpeed stands for side to side movement
			    	double strafeSpeed = -Robot.oi.getXSpeed(); // xSpeed is stands for the rotation of the robot 
			    	
			    	
			    	if(ySpeed < .25 && ySpeed > -.25){
			    		ySpeed = 0;
			    	}
			    	if(turnSpeed < .25 && turnSpeed > -.25){
			    		turnSpeed = 0;
			    	}
			    	if(strafeSpeed < .25 && strafeSpeed > -.25){
			    		strafeSpeed = 0;
			    	}
			    	
			    	
			    	
			    	if(ySpeed > .5) {
			    		ySpeed = .5;
			    	}
			    	
			    	if  (ySpeed < -.5){
			    		
			    		ySpeed = -.5;
			    	}
			    	
			    	if(turnSpeed > .5) {
			    		turnSpeed = .5;
			    	}
			    	
			    	if  (turnSpeed < -.5){
			    		
			    		turnSpeed = -.5;
			    	}
			    	
			    	if(strafeSpeed > .5) {
			    		strafeSpeed = .5;
			    	}
			    	
			    	if  (strafeSpeed < -.5){
			    		
			    		strafeSpeed = -.5;
			    	}
			    	
			    	
			    	
			    	//Arcade drive
			    	//Robot.chassis.driveWithJoystick( ySpeed, turnSpeed );
			    
			    	//Mecanum drive
			    	//Robot.chassisPower.driveWithMeccanum(strafeSpeed, ySpeed, turnSpeed);
			    	//Robot.kExampleSubsystem.driveWithMeccanum(strafeSpeed, ySpeed, turnSpeed);
			    	Robot.powerChassis.driver(strafeSpeed, ySpeed, turnSpeed);
			    	
			    	SmartDashboard.putNumber("Left Speed", Robot.oi.getYSpeed());
			    	SmartDashboard.putNumber("Right Speed", Robot.oi.getXSpeed());
			    	
			    	/////////////////
			    	//isFinished();
			    	//end();
			    	
			    	
			    	
			    }    
			    
		// Called just before this Command runs the first time
		@Override
		protected void initialize() {
		}


		// Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
			return false;
		}

		// Called once after isFinished returns true
		@Override
		protected void end() {
		}

		// Called when another command which requires one or more of the same
		// subsystems is scheduled to run
		@Override
		protected void interrupted() {
		}

}
