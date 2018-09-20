/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3062.robot;



import org.usfirst.frc.team3062.robot.commands.CloseTestPneumatic;
import org.usfirst.frc.team3062.robot.commands.LiftyDown;
import org.usfirst.frc.team3062.robot.commands.LiftyStop;
import org.usfirst.frc.team3062.robot.commands.LiftyUpMid;
import org.usfirst.frc.team3062.robot.commands.OpenTestPneumatics;
import org.usfirst.frc.team3062.robot.commands.PickUpBlock;
import org.usfirst.frc.team3062.robot.commands.ShootBlock;
import org.usfirst.frc.team3062.robot.commands.SlowIntake;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
////CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
//	1: A
//	2: B
//	3: X
//	4: Y
//	5: Left Bumper
//	6: Right Bumper
//	7: Back
//	8: Start
//	9: Left Joystick
//	10: Right Joystick
	
	XboxController driverStick = new XboxController(0); // controller for driving
	XboxController buttonStick = new XboxController(1); // controller for intake and elevator
	//XboxController alternateStick = new XboxController(1);
	JoystickButton pickUpBlock = new JoystickButton( buttonStick, 2 ); //B Button
	JoystickButton shootBlock = new JoystickButton( buttonStick, 1 ); //A Button
	JoystickButton holdBlock = new JoystickButton( buttonStick, 4 ); //Y Button
	JoystickButton raiseElevator = new JoystickButton( buttonStick, 6 ); //Right Bumper
	JoystickButton lowerElevator = new JoystickButton( buttonStick, 5 ); //Left Bumper 
	JoystickButton elevatorStop = new JoystickButton( buttonStick, 3 ); //X button
	JoystickButton extendWheels = new JoystickButton( driverStick, 8 ); //Start button
	JoystickButton retractWheels = new JoystickButton( driverStick, 7 ); //Select button
	
	
	OpenTestPneumatics openPneumatic = new OpenTestPneumatics();
	CloseTestPneumatic closePneumatic = new CloseTestPneumatic();
	LiftyUpMid lmu = new LiftyUpMid();
	LiftyDown ld = new LiftyDown();
	LiftyStop ls = new LiftyStop();
	PickUpBlock pub = new PickUpBlock();
	SlowIntake hb = new SlowIntake();
	ShootBlock sb = new ShootBlock();
	
	
	//LiftRamp launchCmd = new LiftRamp();
	//RetractRamp retractCmd = new RetractRamp();
	//CompressorCheck checkCmd = new CompressorCheck();
//	TestPneumatics testp = new TestPneumatics();
	
	
	
	
	public OI() {
		extendWheels.whenPressed(openPneumatic);
		retractWheels.whenPressed(closePneumatic);
		lowerElevator.whenPressed(ld);
		raiseElevator.whenPressed(lmu);
			
			
		elevatorStop.whenPressed(ls);
		pickUpBlock.whenPressed(sb); 
		shootBlock.whenInactive(pub);
		holdBlock.whenPressed(hb);
		
	}

	public double getYSpeed() {	
		return -driverStick.getRawAxis(1);
	}
	
	public double getXSpeed() {
		return -driverStick.getRawAxis(0); // Should this be 4?
	}
	
	public double getStrafeSpeed() {
		return -driverStick.getRawAxis(4);
		
	}
}
