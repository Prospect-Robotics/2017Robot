package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class Autonomous2 extends CommandGroup {
	SendableChooser<Integer> positionChooser, airshipChooser;
	int position = 2;
	boolean finished = false;
	
	public Autonomous2() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}
	
	public void initialize() {
		Robot.driveTrain.encoder.setDistancePerPulse(240 / (6 * Math.PI));
		position = positionChooser.getSelected() + airshipChooser.getSelected() * 3;
	}
	
	public void execute() {
		switch (position) {
		case 2:
			if (Robot.driveTrain.encoder.getDistance() < 27.16) {
				Robot.driveTrain.mecanumDriveCartesian(0, -1, 0);
			} else if (Robot.driveTrain.encoder.getDistance() < 28.15) {
				Robot.driveTrain.mecanumDriveCartesian(1, 0, 0);
			} else if (Robot.gyro.getAngle() < 30) {
				Robot.driveTrain.mecanumDriveCartesian(0, 0, 1);
			} else {
				finished = true;
			}
			break;

		case 3:
			if (Robot.driveTrain.encoder.getDistance() < 27.16) {
				Robot.driveTrain.mecanumDriveCartesian(0, -1, 0);
			} else if (Robot.driveTrain.encoder.getDistance() > -5.32) {
				Robot.driveTrain.mecanumDriveCartesian(-1, 0, 0);
			} else if (Robot.gyro.getAngle() < 30) {
				Robot.driveTrain.mecanumDriveCartesian(0, 0, 1);
			} else {
				finished = true;
			}
			break;
/**
 * 			v*			 {
 * 	*		|		*	 {
 * =|(:,o)( . )(. .)(   ){
 * 			|	*		 {
 * 		*	^			 {
 */
		case 4:
			if (Robot.driveTrain.encoder.getDistance() < 27.16) {
				Robot.driveTrain.mecanumDriveCartesian(0, -1, 0);
			} else if (Robot.driveTrain.encoder.getDistance() < -66.46) {
				Robot.driveTrain.mecanumDriveCartesian(-1, 0, 0);
			} else {
				finished = true;
			}
			break;

		case 5:
			if (Robot.driveTrain.encoder.getDistance() < 27.16) {
				Robot.driveTrain.mecanumDriveCartesian(0, -1, 0);
			} else if (Robot.driveTrain.encoder.getDistance() < 60.62) {
				Robot.driveTrain.mecanumDriveCartesian(1, 0, 0);
			} else {
				finished = true;
			}
			break;

		case 6:
			finished = true;
			break;

		case 7:
			if (Robot.driveTrain.encoder.getDistance() < 27.16) {
				Robot.driveTrain.mecanumDriveCartesian(0, -1, 0);
			} else if (Robot.driveTrain.encoder.getDistance() > -33.98) {
				Robot.driveTrain.mecanumDriveCartesian(-1, 0, 0);
			} else {
				finished = true;
			}
			break;

		case 8:
			if (Robot.driveTrain.encoder.getDistance() < 27.16) {
				Robot.driveTrain.mecanumDriveCartesian(0, -1, 0);
			} else if (Robot.driveTrain.encoder.getDistance() < 120.78) {
				Robot.driveTrain.mecanumDriveCartesian(1, 0, 0);
			} else if (Robot.gyro.getAngle() > -30) {
				Robot.driveTrain.mecanumDriveCartesian(0, 0, -1);
			} else {
				finished = true;
			}
			break;

		case 9:
			if (Robot.driveTrain.encoder.getDistance() < 27.16) {
				Robot.driveTrain.mecanumDriveCartesian(0, -1, 0);
			} else if (Robot.driveTrain.encoder.getDistance() < 88.3) {
				Robot.driveTrain.mecanumDriveCartesian(1, 0, 0);
			} else if (Robot.gyro.getAngle() > -30) {
				Robot.driveTrain.mecanumDriveCartesian(0, 0, -1);
			} else {
				finished = true;
			}
			break;

		case 10:
			if (Robot.driveTrain.encoder.getDistance() < 27.16) {
				Robot.driveTrain.mecanumDriveCartesian(0, -1, 0);
			} else if (Robot.driveTrain.encoder.getDistance() > -1.51) {
				Robot.driveTrain.mecanumDriveCartesian(1, 0, 0);
			} else if (Robot.gyro.getAngle() > -30) {
				Robot.driveTrain.mecanumDriveCartesian(0, 0, -1);
			} else {
				finished = true;
			}
			break;
		}
	}
	
	protected boolean isFinished() {
		return finished;
	}
}