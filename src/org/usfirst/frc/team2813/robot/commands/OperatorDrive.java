package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperatorDrive extends Command {

	double deadZone = 0.275;
	double scale = 1;
	int shuffleTicks = 0;
	int shuffleTickLimit = 3;

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
		if (!robot.isNewDataAvailable()) {
			return;
		}
		if (Math.IEEEremainder(robot.oi.joystick.getDirectionDegrees() - robot.gyro.getAngle(), 180) > 10) {
			scale = 1;
		}
		double twist = Math.pow(((Math.abs(robot.oi.joystick.getRawAxis(4)) * (1 - deadZone) + deadZone)), 3);
		if (robot.oi.joystick.getRawAxis(4) < 0) {
			twist *= -1;
		}
		if (robot.oi.joystick.getPOV() >= 0) {
			if (shuffleTicks <= shuffleTickLimit) {
				robot.driveTrain.mecanumDrivePolar(scale, robot.oi.joystick.getPOV() - robot.gyro.getAngle(), twist);
				shuffleTicks++;
			}
		} else {
			double x = scale * Math.pow(robot.oi.joystick.getX(), 3);
			double y = scale * Math.pow(robot.oi.joystick.getY(), 3);
			robot.driveTrain.mecanumDriveCartesian(x, y, twist);
			shuffleTicks = 0;
		}
		// robot.intake.set(robot.oi.joystick.getRawAxis(2) -
		// robot.oi.joystick.getRawAxis(3));
		// robot.belt.set((robot.oi.joystick.getRawAxis(3) -
		// robot.oi.joystick.getRawAxis(2)) * 0.6);
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