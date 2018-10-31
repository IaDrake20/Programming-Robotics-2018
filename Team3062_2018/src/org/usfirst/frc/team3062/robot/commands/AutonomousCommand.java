package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends Command {
	
	double disCap = 100;
	int side = 1; // 0 for right, 1 for center, 2 for left
	int incr = 0; //0 for blue, 1 for red
	
	public AutonomousCommand() {
		
		requires(Robot.feeder);
		requires(Robot.powerChassis);
		requires(Robot.elevator);
		//color = c;
		//side = s;
	}
	
	protected void execute(){
		//this massive mess of an if statement is how I thought we choose the version of autonomous
		//color controls whether we after red team or blue team
		//side controls our starting position, so ideally we will have to talk to our team mates to get the side we need
		//I have also commented out and left the tab open for how it is recommended to set up encoders, I could not get it to work however
		// 
		
		Timer stopper = new Timer();
		stopper.start();
		
		while(stopper.get() < 6.5 && incr == 0) {
			
			Robot.powerChassis.driver(0, .3, 0);
			
			//if()
		}
		
		//Robot.powerChassis.driver(0, 0, 0);
		
		
		isFinished();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
