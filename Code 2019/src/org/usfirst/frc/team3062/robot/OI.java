package org.usfirst.frc.team3062.robot;

//import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


import org.usfirst.frc.team3062.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
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
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

/*
 * The buttons on the controller follow this mapping
1: A
2: B
3: X
4: Y
5: Left Bumper
6: Right Bumper
7: Back
8: Start
9: Left Joystick
10: Right Joystick
The axis on the controller follow this mapping
(all output is between -1 and 1)
1: Left Stick X Axis
-Left:Negative ; Right: Positive
2: Left Stick Y Axis
-Up: Negative ; Down: Positive
3: Triggers
-Left: Positive ; Right: Negative
4: Right Stick X Axis
-Left: Negative ; Right: Positive
5: Right Stick Y Axis
-Up: Negative ; Down: Positive
6: Directional Pad (Not recommended, buggy)
 */
	
	//Driver 1
	XboxController driverStick1 = new XboxController(1);
	//Driver 2
	XboxController driverStick2 = new XboxController(2);
	
	
	
	//XboxController alternateStick = new XboxController(1);
	JoystickButton launchButton = new JoystickButton(driverStick1, 6);
	
	public OI() {
		//shooterOnButton.whenPressed(shooterOn);
		//shooterOffButton.whenPressed(shooterOff);
		
		//launchButton.whenPressed(launchCmd);
		//launchButton.whenPressed(checkCmd);
		
		//retractButton.whenPressed(retractCmd);
		//retractButton.whenPressed(checkCmd);
		
	}
//refer here for joystick creation info: https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599723-joysticks
	
	public double getLeftSpeedDriver1() {	
		System.out.println("hi::::::::::::::::::::::::::::::::::::::::::::::");

		return -driverStick1.getRawAxis(0);
	}
	
	public double getRightSpeedDriver1() {
		return -driverStick1.getRawAxis(0);//does this number need to be same as above?
	}
	
	public double getleftSpeedDriver2() {
		System.out.println("hi::::::::::::::::::::::::::::::::::::::::::::::");

		return -driverStick2.getRawAxis(1);
	}
	
	public double getrightSpeedDriver2() {
		return -driverStick2.getRawAxis(1);
	}
	
}