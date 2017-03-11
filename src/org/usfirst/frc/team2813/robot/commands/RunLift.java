package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

public class RunLift extends RunMotor {

	public RunLift(double speed, double distance) {
		super(Robot.getInstance().lift, speed);
		this.distance = distance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Robot.getInstance().lift.encoder.reset();
	}

	protected void execute() {
		// if ((Robot.getInstance().lift.encoder.getDistance() <= distance &&
		// speed <= 0)
		// || (Robot.getInstance().lift.encoder.getDistance() >= distance + 37
		// && speed >= 0)) {
		// motor.set(speed / 2);
		// } else {
		// motor.set(speed);
		// }
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
		// return (Robot.getInstance().lift.encoder.getDistance() <= 0 && speed
		// <= 0)
		// || (Robot.getInstance().lift.encoder.getDistance() >= 37 && speed >=
		// 0);
	}
}