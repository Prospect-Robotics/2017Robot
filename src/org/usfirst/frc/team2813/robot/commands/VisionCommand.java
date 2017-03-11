//package org.usfirst.frc.team2813.robot.commands;
//
//import java.util.ArrayList;
//
//import org.usfirst.frc.team2813.robot.commands.GripPipeline.Line;
//
//import edu.wpi.cscore.VideoSource;
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.vision.VisionRunner;
//import edu.wpi.first.wpilibj.vision.VisionThread;
//
//public class VisionCommand extends Command implements VisionRunner.Listener<GripPipeline> {
//	// threshold for lines that are close together (square radius around
//	// endpoints that must intersect)
//	private static final double THRESHOLD = 10;
//	private static final double ANGLE_THRESHOLD = 5;
//
//	private final VisionThread m_thread;
//
//	public VisionCommand(VideoSource camera) {
//		m_thread=new VisionThread(camera, new GripPipeline(), this);
//		// Use requires() here to declare subsystem dependencies
//		// eg. requires(chassis);
//	}
//
//	VisionCommand(VisionThread thread) {
//		m_thread = thread;
//	}
//
//	protected void execute() {
//		Thread.yield();
//	}
//
//	protected boolean isFinished() {
//		return false;
//	}
//
//	public void copyPipelineOutputs(GripPipeline pipeline) {
//		// collapse lines that are very close together
//		System.out.println(pipeline.findLinesOutput());
//
//		ArrayList<Line> lines = combineLines(pipeline.findLinesOutput());
//	}
//
//	/**
//	 * If the endpoints of line1 and line2 are close to each other and the two
//	 * lines are relatively the same slope (so they are effectively two segments
//	 * of the same line), return a new Line corresponding to the big line.
//	 * Otherwise return nulleturn null;
//	 */
//
//	static void addLine(ArrayList<Line> lines, Line line2) {
//		boolean flag = false;
//		for (int i = 0; i < lines.size(); i++) {
//			Line line1 = lines.get(i);
//			if (isClose(line1, line2)) {
//				if (isAngleClose(line1, line2)) {
//					lines.set(i, new Line(line1.x1, line1.y1, line2.x2, line2.y2));
//					flag = true;
//				} else {
//					lines.set(i, new Line(line2.x1, line2.y1, line1.x2, line1.y2));
//				}
//			} else if (isClose(line2, line1)) {
//				if (isAngleClose(line2, line1)) {
//					lines.set(i, new Line(line2.x1, line2.y1, line1.x2, line1.y2));
//					flag = true;
//				} else {
//					lines.set(i, new Line(line1.x1, line1.y1, line2.x2, line2.y2));
//				}
//				Line newLine = concatenateLines(lines.get(i), line2);
//				if (newLine != null) {
//					lines.set(i, newLine);
//					flag = true;
//				}
//			}
//			lines.add(line2); // nowhere for it to go, might as well put it on
//								// the end of the list.
//		}
//	}
//
//	private static Line concatenateLines(Line line, Line line2) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static boolean isAngleClose(Line line1, Line line2) {
//		return Math.abs(line1.angle() - line2.angle()) < ANGLE_THRESHOLD;
//	}
//
//	/**
//	 * Return true if the endpoint of line 1 is close to the startpoint of line
//	 * 2 (not vice versa).
//	 */
//	private static boolean isClose(Line line1, Line line2) {
//		return Math.abs(line2.x2 - line1.x1) < THRESHOLD && Math.abs(line2.y2 - line1.y1) < THRESHOLD;
//	}
//
//	private static ArrayList<Line> combineLines(ArrayList<Line> lines) {
//		// Parallelism!
//		/*
//		 * 1. Main processor starts to process large problem. 2. Main processor
//		 * breaks problem into mini-problems, each of whic is passed to another
//		 * processor. 3. Each processor computes its soultion to its own
//		 * mini-problem. 4. Main process assembles mini-solutions to solve
//		 * original problem.
//		 * 
//		 * Main process Subprocesses ╔═════════╗ -- Sub solutions are computed
//		 * by the second function argument ║ ╟──Sub-problem > Sub-Solution ┐ ║ ║
//		 * ├───┐ -- These joints are calls to the joiner function ║
//		 * ╟──Sub-problem > Sub-Solution ┘ │ (third argument) ║ ║ │ ╔══════════╗
//		 * ║ Main ╟──Sub-problem > Sub-Solution ┐ ╞══╣ MAIN ║ ║ Problem ║ ├─┐ │
//		 * ║ SOLUTION ║ ║ ╟──Sub-problem > Sub-Solution ┘ │ │ ╚══════════╝ ║ ║
//		 * ├─┘ ║ ╟──Sub-problem > Sub-Solution ┐ │ ║ ║ ├─┘ ║ ╟──Sub-problem >
//		 * Sub-Solution ┘ -- Sub-solutions are combined to solve original
//		 * problem ╚═════════╝
//		 * 
//		 * collect takes three arguments. The first one creates a new blank
//		 * sub-solution that the process will fill in. The second one is a thing
//		 * to compute the mini-solution. The third one is a function to put two
//		 * mini-solutions together to solve the original problem.
//		 */
//		return lines.parallelStream().collect(ArrayList<Line>::new, VisionCommand::addLine, (ArrayList<Line> array1,
//				ArrayList<Line> array2) -> array2.parallelStream().forEach((line) -> addLine(array1, line)));
//		/*
//		 * The code had a starting array filled with lines and a final array.
//		 * For every line in the starting array, it checks the final array. If
//		 * any lines in the final array are close enough to the new line, they
//		 * are combined together.
//		 */
//	}
//}