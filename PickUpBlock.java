package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PickUpBlock extends Command {
	
	
	public PickUpBlock() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.feeder);
	}
	
	protected void initialize() {
	}
	
	
//	}
	protected void execute() {
			
	    System.out.print("ID:::::::::::::::::::::::::::::::::Pushed Back");

		Robot.feeder.grabIntake();
		
	    
		isFinished();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
		
	}
}
