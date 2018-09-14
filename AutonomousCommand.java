package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends Command {
	
	double disCap = 100;
	int side = 0; // 0 for right, 1 for center, 2 for left
	int color = 0; //0 for blue, 1 for red
	
	public AutonomousCommand(int c, int s) {
		
		requires(Robot.powerChassis);
		requires(Robot.elevator);
		color = c;
		side = s;
	}
	
	protected void execute(){
		//this massive mess of an if statement is how I thought we choose the version of autonomous
		//color controls whether we after red team or blue team
		//side controls our starting position, so ideally we will have to talk to our team mates to get the side we need
		//I have also commented out and left the tab open for how it is recommended to set up encoders, I could not get it to work however
		// 
		if(color == 0) {
			
			System.out.println("Color reached");
			
			if( side == 0){
			// if start at right for blue, we need to detect color and either strafe left or go straight
				while(disCap == 100) {
					
					disCap = Robot.powerChassis.getDistance();
					System.out.println(disCap);
					
					Robot.powerChassis.driver(3, 0, 0);
					
				}
				
				Timer.delay(3);
				
				Robot.elevator.liftUp();
				}else if(side == 1){
			// if start at center for blue, we need to detect color and go forward, then either strafe left or right depending on color
			while(disCap == 100) {
				
				Timer t = new Timer();
				t.start();
				
				disCap = Robot.powerChassis.getDistance();
				System.out.println(disCap);
				
				while(t.get() <1) {
					
				
					Robot.powerChassis.driver(0, .5, 0);
				}
			}
			
			Timer.delay(3);
			
			Robot.elevator.liftUp();
			
		}else if(side == 2){
			// if start is left and blue, we need to detect color, then either go straight, or strafe right
			while(disCap == 100) {
				
				disCap = Robot.powerChassis.getDistance();
				System.out.println(disCap);
				
				Robot.powerChassis.driver(3, 0, 0);
				
			}
			
			Timer.delay(3);
			
			Robot.elevator.liftUp();
		}
		}else if(color == 1){
			if( side == 0){
				while(disCap == 100) {
					
					disCap = Robot.powerChassis.getDistance();
					System.out.println(disCap);
					
					Robot.powerChassis.driver(3, 0, 0);
					
				}
				
				Timer.delay(3);
				
				Robot.elevator.liftUp();
				
			}else if(side == 1){
				while(disCap == 100) {
					
					disCap = Robot.powerChassis.getDistance();
					System.out.println(disCap);
					
					Robot.powerChassis.driver(3, 0, 0);
					
				}
				
				Timer.delay(3);
				
				Robot.elevator.liftUp();
				
			}else if(side == 2){
				
				while(disCap == 100) {
					
					disCap = Robot.powerChassis.getDistance();
					System.out.println(disCap);
					
					Robot.powerChassis.driver(3, 0, 0);
					
				}
				
				Timer.delay(3);
				
				Robot.elevator.liftUp();
			}
		}
		isFinished();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
