package org.usfirst.frc.team2813.robot;

import org.usfirst.frc.team2813.robot.commands.BasicAutonomous;
import org.usfirst.frc.team2813.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2813.robot.subsystems.Lift;
import org.usfirst.frc.team2813.robot.subsystems.MotorSubsystem;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public MotorSubsystem intake, belt, climber;
	public Lift lift;
	public ADXRS450_Gyro gyro;
	public DriveTrain driveTrain;
	public OI oi; // Operator Interface
	public Servo servoL, servoR;
	// public UsbCamera camera;
	private static Robot instance;

	AutonomousCommandBase autonomousCommand;
	SendableChooser<AutonomousCommandBase> chooser = new SendableChooser<AutonomousCommandBase>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		instance = this;
		// This chooser will be used to select Autonomous Commands
		// when they're funcitonal enough to actually be run.
		chooser.addDefault("Basic autonomous", new BasicAutonomous());
		chooser.addObject("Just sit there for 15 sec", null);
		SmartDashboard.putData("Auto mode", chooser);
		// camera = CameraServer.getInstance().startAutomaticCapture();
		intake = new MotorSubsystem(VictorSP.class, RobotMap.intakePort, "Intake");
		belt = new MotorSubsystem(VictorSP.class, RobotMap.beltPort, "Belt");
		climber = new MotorSubsystem(VictorSP.class, RobotMap.climberPort, "Climber");
		// Sparks have built-in support for limit switches, so the robot program
		// doesn't have to be aware of their existence
		lift = new Lift();
		servoL = new Servo(RobotMap.servoLPort);
		servoR = new Servo(RobotMap.servoRPort);
		gyro = new ADXRS450_Gyro(); // Initialize before driveTrain
		driveTrain = new DriveTrain();

		// CameraServer.getInstance().addServer(new MjpegServer("RoboRIO MJPEG",
		// 50007));

		/**
		 * It is very important that OI is initialized LAST. If it is not
		 * initialized after all subsystems it may try to instantiate a command
		 * that references a subsystem that hasn't been initialized yet, which
		 * will crash the robot program.
		 */
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
	}

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
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		// retrieve the value associated with the currently selected radio
		// button
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (if one is selected)
		if (autonomousCommand != null) {
			autonomousCommand.init();
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		/**
		 * This makes sure that the autonomous stops running when teleop starts
		 * running. If you want the autonomous to continue until interrupted by
		 * another command, remove this line or comment it out.
		 */
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	public static Robot getInstance() {
		return instance;
	}
}