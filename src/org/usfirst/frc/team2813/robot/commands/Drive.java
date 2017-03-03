package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	double x, y, targetInches;

	public Drive(double x, double y, double inches) {
		requires(Robot.driveTrain);
		this.x = x;
		this.y = y;
		this.targetInches = inches;
	}

	protected void initialize() {
		Robot.driveTrain.encoder.reset();
	}

	protected void execute() {
		Robot.driveTrain.mecanumDriveCartesian(x, y, 0);
	}

	protected boolean isFinished() {
		return Math.abs(Robot.driveTrain.encoder.getDistance()) >= targetInches;
	}

	protected void end() {
		Robot.driveTrain.mecanumDriveCartesian(0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}