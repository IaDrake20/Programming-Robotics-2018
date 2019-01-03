package org.usfirst.frc.team3062.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3062.robot.Robot;
import org.usfirst.frc.team3062.robot.subsystems.Chassis;

public class AutonomousCommand extends Command {

	double dis;
	double tDis;

	int step;
	int sPoint;

	double leftSpeed;
	double rightSpeed;

	public void AutonomousCommand() {

		requires(Robot.chassis);
		requires(Robot.ramp);

		dis = 0;
		tDis = 0;

		step = 0;

		leftSpeed = .5;
		rightSpeed = .5;
	}

	public void AutonomousCommand(int startPoint) {

		requires(Robot.chassis);
		// requires(Robot.ramp);

		dis = 0;
		tDis = 0;

		// step = 1;
		sPoint = startPoint;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	protected void execute() {

		if (step == 0 && dis == 0) {
			leftSpeed = .5;
			rightSpeed = .5;

			Robot.ramp.retract();

			// step++;
		}

		System.out.println("I am calling this way too long");

		// Robot.chassis.resetAllDis(0);
		// SmartDashboard.putNumber("Distance", dis);

		dis = Robot.chassis.getDis();
		tDis = Robot.chassis.getTurnDis();

		// SUGGESTED 2/14/17: Set dis to be less than 72
		if (step == 1 && 39 < dis) {

			// leftSpeed = 0;
			// rightSpeed = 0;

			// Timer.delay(.1);

			leftSpeed = .5;
			rightSpeed = -.5;

			step++;

		}

		// ADDES 2/14/17: Does -25 represent -90 degrees?
		if (-25 > tDis && step == 2) {

			// leftSpeed = 0;
			// rightSpeed = 0;

			// Timer.delay(.1);

			leftSpeed = .5;
			rightSpeed = .5;

			step++;
		}

		// SUGGESTED 2/14/17: Set dis to be less than 81
		if (40 < dis && step == 3) {

			// leftSpeed = 0;
			// rightSpeed = 0;

			// Timer.delay(.1);

			leftSpeed = -.5;
			rightSpeed = .5;

			step++;

		}

		// ADDED 2/14/17: Does 0 represent +90 degrees?
		if (0 < tDis && step == 4) {

			// leftSpeed = 0;
			// rightSpeed = 0;

			// Timer.delay(.1);

			leftSpeed = .5;
			rightSpeed = .5;

			step++;

		}

		// literally just a repeat of the statement above
		/*
		 * if(0 < tDis && step ==4){
		 * 
		 * //leftSpeed = 0; //rightSpeed = 0;
		 * 
		 * //Timer.delay(.1);
		 * 
		 * leftSpeed = .5; rightSpeed = .5;
		 * 
		 * step++;
		 * 
		 * }
		 */

		// SUGGESTED 2/14/17: Set dis to be less than 168
		if (70 < dis && step == 5) {

			leftSpeed = 0;
			rightSpeed = 0;
			step = 0;

		}

		Robot.chassis.driveWithJoystick(leftSpeed, rightSpeed);

		// }else if(rightSpeed > .8){
		// rightSpeed = .6;
		// }else if(leftSpeed > .8){
		// leftSpeed = .6;
		// }

	}

	@Override
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
