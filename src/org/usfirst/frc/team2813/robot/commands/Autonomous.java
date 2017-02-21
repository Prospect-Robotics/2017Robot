package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class Autonomous extends Command {
	SendableChooser<Integer> positionChooser, airshipChooser;

	public Autonomous() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		ADXRS450_Gyro gyro = Robot.gyro;
		Encoder encoder = Robot.driveTrain.encoder;
		encoder.setDistancePerPulse(240 / (6 * Math.PI));
		int position = positionChooser.getSelected() + airshipChooser.getSelected() * 3;
		switch (position) {
		case 2:
			// Drive forward
			while (encoder.getDistance() < 27.16) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			}
			// Drive right
			encoder.setDistancePerPulse(6 * Math.PI);
			while (encoder.getDistance() < 0.99) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(1, 0, 0, gyro.getAngle());
			}
			// Turn clockwise
			while (gyro.getAngle() < 30) {
				Robot.driveTrain.drive.mecanumDrive_Polar(0, 0, 1);
			}
			break;

		case 3:
			// Drive forward
			while (encoder.getDistance() < 27.16) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			}
			// Drive left
			encoder.setDistancePerPulse(6 * Math.PI);
			while (encoder.getDistance() > -32.48) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(-1, 0, 0, gyro.getAngle());
			}
			// Turn clockwise
			while (gyro.getAngle() < 30) {
				Robot.driveTrain.drive.mecanumDrive_Polar(0, 0, 1);
			}
			break;

		case 4:
			// Drive forward
			while (encoder.getDistance() < 27.16) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			}
			// Drive left
			encoder.setDistancePerPulse(6 * Math.PI);
			while (encoder.getDistance() > -93.62)
				Robot.driveTrain.drive.mecanumDrive_Cartesian(-1, 0, 0, gyro.getAngle());
			// Turn clockwise
			while (gyro.getAngle() < 30) {
				Robot.driveTrain.drive.mecanumDrive_Polar(0, 0, 1);
			}
			break;

		case 5:
			// Drive forward
			while (encoder.getDistance() < 27.16) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			}
			// Drive right
			encoder.setDistancePerPulse(6 * Math.PI);
			while (encoder.getDistance() < 33.46) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(1, 0, 0, gyro.getAngle());
			}
			break;

		case 6:
			break;

		case 7:
			// Drive forward
			while (encoder.getDistance() < 27.16) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			}
			// Drive left
			encoder.setDistancePerPulse(6 * Math.PI);
			while (encoder.getDistance() > -61.14) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(-1, 0, 0, gyro.getAngle());
			}
			break;

		case 8:
			// Drive forward
			while (encoder.getDistance() < 27.16) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			}
			// Drive right
			encoder.setDistancePerPulse(6 * Math.PI);
			while (encoder.getDistance() < 93.62) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(1, 0, 0, gyro.getAngle());
			}
			// Turn counterclockwise
			while (gyro.getAngle() > -30) {
				Robot.driveTrain.drive.mecanumDrive_Polar(0, 0, -1);
			}
			break;

		case 9:
			// Drive forward
			while (encoder.getDistance() < 27.16) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			}
			// Drive right
			encoder.setDistancePerPulse(6 * Math.PI);
			while (encoder.getDistance() < 61.14) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(1, 0, 0, gyro.getAngle());
			}
			// Turn counterclockwise
			while (gyro.getAngle() > -30) {
				Robot.driveTrain.drive.mecanumDrive_Polar(0, 0, -1);
			}
			break;

		case 10:
			// Drive forward
			while (encoder.getDistance() < 27.16) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(0, -1, 0, gyro.getAngle());
			}
			// Drive left
			encoder.setDistancePerPulse(6 * Math.PI);
			while (encoder.getDistance() > -28.67) {
				Robot.driveTrain.drive.mecanumDrive_Cartesian(-1, 0, 0, gyro.getAngle());
			}
			// Turn counterclockwise
			while (gyro.getAngle() > -30) {
				Robot.driveTrain.drive.mecanumDrive_Polar(0, 0, -1);
			}
			break;
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
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