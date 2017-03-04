package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	double x, y, targetInches;
	private final DriveTrain robot_driveTrain; // syntactic sugar
	public Drive(double x, double y, double inches) {
		robot_driveTrain=Robot.getInstance().driveTrain;
		requires(robot_driveTrain);
		this.x = x;
		this.y = y;
		this.targetInches = inches;
	}

	protected void initialize() {
		robot_driveTrain.encoder.reset();
	}

	protected void execute() {
		robot_driveTrain.mecanumDriveCartesian(x, y, 0);
	}

	protected boolean isFinished() {
		return Math.abs(robot_driveTrain.encoder.getDistance()) >= targetInches;
	}

	protected void end() {
		robot_driveTrain.mecanumDriveCartesian(0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}