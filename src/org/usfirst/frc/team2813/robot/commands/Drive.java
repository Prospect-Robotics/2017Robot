package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	double x, y, targetInches;
	private final DriveTrain driveTrain;

	public Drive(double x, double y, double timeout) {
		driveTrain = Robot.getInstance().driveTrain;
		requires(driveTrain);
		this.x = x;
		this.y = y;
		setTimeout(timeout);
	}

	protected void initialize() {
		// driveTrain.encoder.setDistancePerPulse(6 * Math.PI / 360);
	}

	protected void execute() {
		driveTrain.drive.mecanumDrive_Cartesian(x, y, 0, Robot.getInstance().gyro.getAngle());
	}

	protected boolean isFinished() {
		// return Math.abs(driveTrain.encoder.getDistance()) >= targetInches;
		return false;
	}

	protected void end() {
		driveTrain.mecanumDriveCartesian(0, 0, 0, false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}