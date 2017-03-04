package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Rotate extends Command {
	protected final double rotate, targetDegrees;
	protected double startDegrees;

	public Rotate(double rotate, double degrees) {
		requires(Robot.getInstance().driveTrain);
		this.rotate = rotate;
		targetDegrees = degrees;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		startDegrees = Robot.getInstance().gyro.getAngle();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.getInstance().driveTrain.mecanumDriveCartesian(0, 0, rotate);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(Robot.getInstance().gyro.getAngle() + startDegrees) >= targetDegrees;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.getInstance().driveTrain.mecanumDriveCartesian(0, 0, 0);
	}
}