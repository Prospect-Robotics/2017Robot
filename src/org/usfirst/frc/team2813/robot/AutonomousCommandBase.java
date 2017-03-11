package org.usfirst.frc.team2813.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class AutonomousCommandBase extends CommandGroup {
	/**
	 * Called just before the command is started. Use this to get information
	 * form a SendableChooser or the like.
	 * 
	 * Exists so that subclasses may override it. (And so that Javac doesn't
	 * complain.)
	 */
	public void init() {
	}
}