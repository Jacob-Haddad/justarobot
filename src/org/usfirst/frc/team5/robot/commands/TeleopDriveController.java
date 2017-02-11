package org.usfirst.frc.team5.robot.commands;

import org.usfirst.frc.team5.robot.ControllerConstants;
import org.usfirst.frc.team5.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopDriveController extends Command {
	double speedRatio = Robot.chassis.highSpeed;
	double driveDirection = 1;

	public TeleopDriveController() {
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.chassis.isHighSpeed) {
			speedRatio = Robot.chassis.highSpeed;
		} else {
			speedRatio = Robot.chassis.lowSpeed;

		}
		
		if (Robot.chassis.isDrivingBackwards) {
			driveDirection = -1;
		} else{
			driveDirection = 1;
			}
		

		if (Robot.chassis.isArcadeDrive) {
			Robot.chassis.arcadeDrive(Robot.oi.driveLeftY(ControllerConstants.driveController) * speedRatio*driveDirection,
					Robot.oi.driveRightX(ControllerConstants.driveController) * speedRatio*driveDirection);
		} else {
			Robot.chassis.tankDrive(Robot.oi.driveLeftY(ControllerConstants.driveController) * speedRatio*driveDirection,
					Robot.oi.driveRightY(ControllerConstants.driveController) * speedRatio*driveDirection);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
