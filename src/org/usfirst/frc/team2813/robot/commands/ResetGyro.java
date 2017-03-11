package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class ResetGyro extends InstantCommand {
	public ResetGyro() {
		super();
		// Use requires() here to declare subsystem dependencies
		requires(Robot.getInstance().driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.getInstance().gyro.reset();
	}
}