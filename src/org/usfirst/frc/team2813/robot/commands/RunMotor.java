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

	public RunMotor(MotorSubsystem motor, double speed, double timeout) {
		this(motor, speed);
		setTimeout(timeout);
	}

	protected void execute() {
		motor.set(speed);
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		motor.set(0.0);
	}
}