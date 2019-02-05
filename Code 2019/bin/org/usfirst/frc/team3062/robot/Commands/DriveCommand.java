/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {
  double driveValue;
  double speedValue;
  public DriveCommand() {
    requires(Robot.drivebase);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }
/*(Ian) This method here should be inside the execution of the class or Execute() method
  public void Forward()
  {
    //unfinished
    Robot.drivebase.driveArcade(5,5);
  }
  */
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveValue = Robot.oi.getXSpeedController_Speed();
    speedValue = Robot.oi.getYSpeedController_Drive();

    double throttle = (1.0 - Robot.oi.Left_Joystick.getThrottle() /2);

    Robot.drivebase.driveArcade(driveValue, speedValue);
    Robot.drivebase.setRaw(Robot.oi.getLeftJoystickXVal() *throttle, Robot.oi.getLeftJoystickYVal() *throttle);
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
