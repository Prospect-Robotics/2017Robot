package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperatorDrive extends Command {

	private double deadZone = 0.0;
	private double scale = 1;
	private double scalePOV = 0.15;
	public boolean fieldOriented = false;

	public OperatorDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.getInstance().driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot robot = Robot.getInstance(); // syntactic sugar, just for
											// readability
		scale = 0.5 - robot.oi.joystick.getRawAxis(3) / 2;
		if (!robot.isNewDataAvailable()) {
			return;
		}
		// if (Math.IEEEremainder(robot.oi.joystick.getDirectionDegrees() -
		// robot.gyro.getAngle(), 180) > 10) {
		// scale = 1;
		// }
		double twist = Math.pow(Math.abs(robot.oi.joystick.getTwist()), 3) * scale * (1 - deadZone) + deadZone;
		if (robot.oi.joystick.getTwist() < 0) {
			twist *= -1;
		}
		 if (robot.oi.joystick.getPOV() >= 0) {
		 robot.driveTrain.drive.mecanumDrive_Polar(scalePOV, robot.oi.joystick.getPOV(), twist);
		 } else {
		double x = scale * Math.pow(robot.oi.joystick.getX(), 3);
		double y = scale * Math.pow(robot.oi.joystick.getY(), 3);
		System.out.println(x+"x");
		System.out.println(y+"y");
		System.out.println(twist+"z");
		robot.driveTrain.drive.mecanumDrive_Cartesian(x, y, twist, fieldOriented ? robot.gyro.getAngle() : 0);
		 }
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
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