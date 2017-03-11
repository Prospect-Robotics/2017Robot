//package org.usfirst.frc.team2813.robot.commands;
//
//import org.usfirst.frc.team2813.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.vision.VisionRunner;
//import edu.wpi.first.wpilibj.vision.VisionThread;
//
//public class StartVision extends Command implements VisionRunner.Listener<GripPipeline> {
//	VisionThread thread;
//	VisionCommand vcmd;
//
//	public StartVision() {
//		thread = new VisionThread(Robot.getInstance().camera, new GripPipeline(), this);
//		vcmd = new VisionCommand(thread);
//	}
//
//	// Called just before this Command runs the first time
//	protected void initialize() {
//	}
//
//	// Called repeatedly when this Command is scheduled to run
//	protected void execute() {
//	}
//
//	// Make this return true when this Command no longer needs to run execute()
//	protected boolean isFinished() {
//		return false;
//	}
//
//	// Called once after isFinished returns true
//	protected void end() {
//	}
//
//	// Called when another command which requires one or more of the same
//	// subsystems is scheduled to run
//	protected void interrupted() {
//	}
//
//	@Override
//	public void copyPipelineOutputs(GripPipeline pipeline) {
//		// if target acquired
//		vcmd.start();
//	}
//}
