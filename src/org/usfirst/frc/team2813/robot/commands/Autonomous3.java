package org.usfirst.frc.team2813.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous3 extends CommandGroup {
	SendableChooser<Integer> positionChooser, airshipChooser;

	public Autonomous3() {
		positionChooser = new SendableChooser<Integer>();
		for (int i = 1; i <= 3; i++) {
			positionChooser.addObject("Position " + i, i);
		}
		SmartDashboard.putData("What position is the Robot starting in?", positionChooser);
		airshipChooser = new SendableChooser<Integer>();
		for (int i = 1; i <= 3; i++) {
			airshipChooser.addObject("Gear Peg " + i, i);
		}
		SmartDashboard.putData("Which peg on the Airship?", airshipChooser);
	}

	protected void initialize() {
		int position = positionChooser.getSelected() + airshipChooser.getSelected() * 3;
		addSequential(new Drive(0, 0, 0));
		switch (position) {
		case 2:
			addSequential(new Drive(0, -1, 27.16));
			addSequential(new Drive(1, 0, 28.15));
			addSequential(new Rotate(1, 30));
			break;

		case 3:
			addSequential(new Drive(0, -1, 27.16));
			addSequential(new Drive(-1, 0, 5.32));
			addSequential(new Rotate(1, 30));
			break;

		case 4:
			addSequential(new Drive(0, -1, 27.16));
			addSequential(new Drive(-1, 0, 66.46));
			addSequential(new Rotate(1, 30));
			break;

		case 5:
			addSequential(new Drive(0, -1, 27.16));
			addSequential(new Drive(1, 0, 60.62));
			break;

		case 6:
			break;

		case 7:
			addSequential(new Drive(0, -1, 27.16));
			addSequential(new Drive(-1, 0, 33.98));
			break;

		case 8:
			addSequential(new Drive(0, -1, 27.16));
			addSequential(new Drive(1, 0, 120.78));
			addSequential(new Rotate(-1, 30));
			break;

		case 9:
			addSequential(new Drive(0, -1, 27.16));
			addSequential(new Drive(1, 0, 88.3));
			addSequential(new Rotate(-1, 30));
			break;

		case 10:
			addSequential(new Drive(0, -1, 27.16));
			addSequential(new Drive(1, 0, 1.51));
			addSequential(new Rotate(-1, 30));
			break;
		}
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}