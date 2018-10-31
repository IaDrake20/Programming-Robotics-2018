//created by IanDrake 2/13/2018
//used to test pneumatics
///////////////////////////////////////////////////////////////////////////////////
package org.usfirst.frc.team3062.robot.commands;

import org.usfirst.frc.team3062.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CloseTestPneumatic extends Command {
	
    //Button a=new Button(); 	
	//InternalButton buttonPneu = new InternalButton();
	
	public CloseTestPneumatic() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.feeder);
	}
	
//public void TestPneu() {
		
	//	if (buttonPneu.get() == true) {
		//	System.out.print("ID:::::::::::::::::::::::::::::::::Solenoid moving forward");
			//solenoidTest.set(DoubleSolenoid.Value.kForward);
			//
		//}
	protected void initialize() {
	}
	
	
//	}
	protected void execute() {
			
	    System.out.print("ID:::::::::::::::::::::::::::::::::Pushed Back");

		Robot.feeder.retractIntake();;
		
	    
		isFinished();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}


	
}
