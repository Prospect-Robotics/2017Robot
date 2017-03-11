package org.usfirst.frc.team2813.robot.commands;

import org.usfirst.frc.team2813.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDriveTrain extends Command {

	OperatorDrive operatorDrive = new OperatorDrive();

    public ToggleDriveTrain() {
    	requires(Robot.getInstance().driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {
    	operatorDrive.fieldOriented = true;
		Robot.getInstance().gyro.reset();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	operatorDrive.fieldOriented = false;
    }
}
