package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoLift extends Command {
	
	public AutoLift() {
		
		requires(Robot.elevator);
		requires(Robot.feeder);
		//requires(Robot.powerChassis);
	}
	
	protected void exectute() {
		
		Timer stopper = new Timer();
		stopper.start();
		
		while(stopper.get() < 1.5) {
			
			System.out.println("Auto Lifting");
			
			Robot.elevator.liftUp();
			
		}
		
		//Robot.elevator.liftStop();
		
		isFinished();
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
