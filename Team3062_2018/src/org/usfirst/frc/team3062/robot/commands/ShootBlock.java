package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootBlock  extends Command {
	
	
	public ShootBlock() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.feeder);
	}
	
	protected void initialize() {
	}
	
	
//	}
	protected void execute() {
			
	    System.out.print("ID:::::::::::::::::::::::::::::::::Pushed Back");

		Robot.feeder.shootIntake();
		
	    
		isFinished();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}

