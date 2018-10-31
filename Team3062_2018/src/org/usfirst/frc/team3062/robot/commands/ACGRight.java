package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ACGRight extends CommandGroup  { // Autonomous Command Group Right
	
	String gameData;
	boolean switchLeft;
	boolean scaleLeft;
	boolean switchRight;
	boolean scaleRight;
	
	double strafeTime = 3;
	double forwardTime = 3;
	double liftTime = .5;
	//AutonomousCommand fc = new ;
	//AutoLift al;
	
	public ACGRight() {
		
		//requires(Robot.elevator);
		//requires(Robot.feeder);
		//requires(Robot.powerChassis);
		
		//addSequential(new AutonomousCommand());
		addSequential(new AutoLift());
		//addParallel(new AutoLift());
		//gameData = DriverStation.getInstance().getGameSpecificMessage();
		//switchLeft = gameData.charAt(0) == 'L';
		//scaleLeft = gameData.charAt(1) == 'L';
		
		//switchRight = gameData.charAt(0) == 'R';
		//scaleRight = gameData.charAt(1) == 'R';
		
		/*
		if(switchLeft == true) {
			
			Timer t = new Timer();
			
			t.start();
			
			while(t.get() < strafeTime) {
				Robot.powerChassis.driver( -.3, 0, 0);
			}
			
			Robot.powerChassis.driver( 0, 0, 0);
			
			t.reset();
			t.start();
			
			while(t.get() < forwardTime) {
				Robot.powerChassis.driver( 0, .3, 0);
			}
			
			Robot.powerChassis.driver( 0, 0, 0);
		}
		
		
		else if(switchLeft == false) {
			
			Timer t = new Timer();
			
			t.start();
			
			while(t.get() < strafeTime) {
				Robot.powerChassis.driver( .3, 0, 0);
			}
			
			Robot.powerChassis.driver( 0, 0, 0);
			
			t.reset();
			t.start();
			
			while(t.get() < forwardTime) {
				Robot.powerChassis.driver( 0, .3, 0);
			}
			
			Robot.powerChassis.driver( 0, 0, 0);
			
		}
		*/

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
