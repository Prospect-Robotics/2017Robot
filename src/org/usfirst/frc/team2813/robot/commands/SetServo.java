package org.usfirst.frc.team2813.robot.commands;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class SetServo extends InstantCommand {
	protected Servo servo;
	protected double angle;

	public SetServo(Servo servo, double angle) {
		super();
		// I don't think there's a need to require() the servo,
		// since A) it's not a subsystem and B) this is an InstantCommand
		// so it will run once and terminate.
		this.servo = servo;
		this.angle = angle;
	}

	// Called once when the command executes
	protected void initialize() {
		servo.setAngle(angle);
	}
}