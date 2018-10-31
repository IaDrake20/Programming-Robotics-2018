package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftLeft extends Command {
	
	
	public ShiftLeft() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.feeder);
	}
	
	protected void initialize() {
	}
	
	
//	}
	protected void execute() {
			
	    System.out.print("ID:::::::::::::::::::::::::::::::::Pushed Back");

		//Robot.feeder.adjustLeft();
		
	    
		isFinished();
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		
		return true;
	}
}
