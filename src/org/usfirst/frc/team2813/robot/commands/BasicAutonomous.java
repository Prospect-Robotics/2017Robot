package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.AutonomousCommandBase;
import org.usfirst.frc.team2813.robot.Robot;

public class BasicAutonomous extends AutonomousCommandBase {

	public BasicAutonomous() {
	}
	
	public void init() {
		addParallel(new Drive(0, -0.75, 4));
		addSequential(new RunMotor(Robot.getInstance().lift, 0.3, 3));
		addSequential(new RunMotor(Robot.getInstance().lift, -0.3, 3));
	}

}
