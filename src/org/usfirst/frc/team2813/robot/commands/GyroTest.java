package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTest extends Command {

	public GyroTest() {
		requires(Robot.getInstance().driveTrain);
	}

	protected void initialize() {
		Robot.getInstance().driveTrain.pidDisable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.getInstance().driveTrain.mecanumDriveCartesian(0, 0, 1, false);
		System.out.println("Gyro rate:      " + Robot.getInstance().gyro.getRate());
		System.out.println("Gyro PID value: " + Robot.getInstance().gyro.pidGet());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.getInstance().driveTrain.pidEnable();
	}
}