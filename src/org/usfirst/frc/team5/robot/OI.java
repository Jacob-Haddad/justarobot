package org.usfirst.frc.team5.robot;

import org.usfirst.frc.team5.robot.commands.ToggleDrive;
import org.usfirst.frc.team5.robot.commands.ToggleDriveDirection;
import org.usfirst.frc.team5.robot.commands.ToggleSpeed;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public OI(){
		ControllerConstants.driveA.toggleWhenPressed(new ToggleDrive());
		ControllerConstants.driveB.toggleWhenPressed(new ToggleSpeed());
		ControllerConstants.driveY.toggleWhenPressed(new ToggleDriveDirection());
	}
	public double driveLeftX(Joystick cont){
		return cont.getRawAxis(ControllerConstants.AXIS_LEFT_X);
	}
	public double driveLeftY(Joystick cont){
		return cont.getRawAxis(ControllerConstants.AXIS_LEFT_Y);
	}
	public double driveRightX(Joystick cont){
		return cont.getRawAxis(ControllerConstants.AXIS_RIGHT_X);
	}
	public double driveRightY(Joystick cont){
		return cont.getRawAxis(ControllerConstants.AXIS_RIGHT_Y);
	}

	
}
