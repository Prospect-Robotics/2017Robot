package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.subsystems.MotorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class RunMotor extends Command {
	MotorSubsystem motor;
	double speed;

	public RunMotor(MotorSubsystem motor, double speed) {
		requires(motor);
		this.motor = motor;
		this.speed = speed;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		motor.set(speed); // keep the watchdog fed
		// ((PWMSpeedController) motor.motor).Feed(); // this would also feed the watchdog
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false; // run until we're stopped
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void end() {
		motor.set(0.0);
	}
}