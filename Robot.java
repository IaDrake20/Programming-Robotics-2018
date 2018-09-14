/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3062.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3062.robot.commands.AutonomousCommand;
import org.usfirst.frc.team3062.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team3062.robot.commands.OpenTestPneumatics;
import org.usfirst.frc.team3062.robot.subsystems.ChassisFeederExtension;
import org.usfirst.frc.team3062.robot.subsystems.Chassis_PowerUp;
import org.usfirst.frc.team3062.robot.subsystems.Elevator;
import org.usfirst.frc.team3062.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3062.robot.subsystems.GripPipeline;
import org.usfirst.frc.team3062.robot.subsystems.GripPipelineBlue;
import org.usfirst.frc.team3062.robot.subsystems.TestSolonoidsLimitSwitches;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final Chassis_PowerUp powerChassis = new Chassis_PowerUp();
	//public static final TestSolonoidsLimitSwitches testSol = new TestSolonoidsLimitSwitches();
	public static final GripPipelineBlue GPB = new GripPipelineBlue();
	public static final GripPipeline GPR = new GripPipeline();
	public static final Elevator elevator = new Elevator();
	public static final ChassisFeederExtension feeder = new ChassisFeederExtension();
	public static OI oi;
	public static GripPipelineBlue gb;
	
	//Static Objects not Classes (Do not use "requires" in commands)
	public static UsbCamera camera1;
	public static UsbCamera camera2;
	public static VisionThread visionThread;
	
	public static MecanumDrive mechRobot;
	//public static CvSink cvSink;

	Command m_autonomousCommand = new AutonomousCommand(1, 3);
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	 public double centerX = 0.0;
	 public final Object imgLock = new Object();
	
	//Compressor c = new Compressor(1);

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		m_chooser.addDefault("Default Auto", new DriveWithJoystick());
		//m_chooser.addDefault("Default Auto", new OpenTestPneumatics());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		////c.start();
		
		camera1 = CameraServer.getInstance().startAutomaticCapture(0);
		camera2 = CameraServer.getInstance().startAutomaticCapture(1);
	    camera1.setResolution(320, 240);
	    
	    
	    
	   // mechRobot = new MecanumDrive();
            //camera.setResolution(640, 480);
            
           // cvSink = CameraServer.getInstance().getVideo();
           // CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
    
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

		//c.setClosedLoopControl(true);
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = new AutonomousCommand(0,1);//= m_chooser.getSelected();

		
		//gb = new GripPipeline();
	    
	    
	    visionThread = new VisionThread(camera1, new GripPipeline(), pipeline -> {
	        if (!pipeline.findContoursOutput().isEmpty()) {
	            Rect r = Imgproc.boundingRect(pipeline.findContoursOutput().get(0));
	            synchronized (imgLock) {
	                centerX = r.x + (r.width / 2);
	            }
	        }
	    });
	    visionThread.start();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		
		if (m_autonomousCommand != null) {
			
			System.out.println("Initialized Autonomous");
			
			m_autonomousCommand.start();
		}
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
