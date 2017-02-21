package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class OperatorDrive extends Command {

	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	double deadZone = 0.275;
	double scale = 1;
	int shuffleTicks = 0;
	int shuffleTickLimit = 3;

	public OperatorDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!DriverStation.getInstance().isNewControlData()) {
			return;
		}
		if (Math.IEEEremainder(Robot.oi.joystick.getDirectionDegrees() - gyro.getAngle(), 180) > 10) {
			scale = 1;
		}
		double twist = Math.pow(((Math.abs(Robot.oi.joystick.getX(Hand.kRight)) * (1 - deadZone) + deadZone)), 3);
		if (Robot.oi.joystick.getX(Hand.kRight) < 0) {
			twist *= -1;
		}
		if (Robot.oi.joystick.getPOV() != -1) {
			if (shuffleTicks <= shuffleTickLimit) {
				Robot.driveTrain.mecanumDrivePolar(scale, Robot.oi.joystick.getPOV() - gyro.getAngle(), twist);
				shuffleTicks++;
			}
		} else {
			double x = scale * Math.pow(Robot.oi.joystick.getX(), 3);
			double y = scale * Math.pow(Robot.oi.joystick.getY(), 3);
			Robot.driveTrain.mecanumDriveCartesian(x, y, twist);
			shuffleTicks = 0;
		}
		// Robot.intake.set(Robot.oi.joystick.getRawAxis(2) -
		// Robot.oi.joystick.getRawAxis(3));
		// Robot.belt.set((Robot.oi.joystick.getRawAxis(3) -
		// Robot.oi.joystick.getRawAxis(2)) * 0.6);
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