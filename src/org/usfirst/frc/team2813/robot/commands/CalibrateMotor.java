package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.subsystems.MotorSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Calibrate a motor controller.
 * 
 * THIS SHOULD NOT BE DONE UNDER NORMAL OPERATING CONDITIONS!!!!!!!!!
 * <p>
 * To use: <br>
 * 0. MAKE SURE MOTORS ARE UNPLUGGED FROM ANY AFFECTED MOTOR CONTROLLERS. <br>
 * 1. Hold down the button on the desired motor controller(s) until the light
 * blinks white/blue (Spark) or red/green (anything else) and continue holding
 * it/them down. <br>
 * 2. Run this command and wait for the message in the robot console (which is
 * displayed as a warning) telling you to release the button. <br>
 * 3. Release the button. The light should blink green/white (Spark) or
 */
public class CalibrateMotor extends Command {
	SpeedController motor;
	double currentPower;
	int counter;

	public CalibrateMotor(MotorSubsystem motor) {
		requires(motor);
		this.motor = motor.motor;
		setInterruptible(false);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		currentPower = -1.0;
		DriverStation.reportWarning("Calibration Starting!!!", false);
		System.out.print("Calibrating...");
		counter = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		motor.set(currentPower);
		double progress = currentPower / 2 + 0.5;
		// Robot.servo1.set(progress);
		if (counter >= 25) {
			DriverStation.reportWarning("Calibration progress: " + progress * 100 + "%", false);
			counter = 0;
		}
		counter++;
		currentPower += (1.0D / 255.0D);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return currentPower >= 1.0;
	}

	// Called once after isFinished returns true
	protected void end() {
		motor.set(0);
		System.out.println("done.");
		DriverStation.reportWarning("Release the button now!", false);
	}
}
