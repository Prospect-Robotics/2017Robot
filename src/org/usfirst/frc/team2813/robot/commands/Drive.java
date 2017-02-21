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
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.encoder.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.mecanumDriveCartesian(x, y, 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(Robot.driveTrain.encoder.getDistance()) >= targetInches;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.mecanumDriveCartesian(0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}