package org.usfirst.frc.team5.robot.subsystems;

import org.usfirst.frc.team5.robot.RobotMap;
import org.usfirst.frc.team5.robot.commands.TeleopDriveController;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {

    //List your Speed Controllers and what they control
	VictorSP leftFntMotor, leftBckMotor, rightFntMotor, rightBckMotor;
	RobotDrive driveController;
	
	public boolean isArcadeDrive = true;
	public boolean isDrivingBackwards = false;
	public boolean isHighSpeed = true;
	public double highSpeed = 1.0;
	public double lowSpeed = .75;
	
	public Chassis () {
		// Instantiate SpeedControllers and give them values (map to PWM numbers)
		leftFntMotor = new VictorSP(RobotMap.kleftFntMotor);
		leftBckMotor = new VictorSP(RobotMap.kleftBckMotor);
		rightFntMotor = new VictorSP(RobotMap.krightFntMotor);
		rightBckMotor = new VictorSP(RobotMap.krightBckMotor);
		
		driveController = new RobotDrive(leftFntMotor,leftBckMotor, rightFntMotor, rightBckMotor);
	}
	

    public void initDefaultCommand() {
        setDefaultCommand(new TeleopDriveController());
    }


public void tankDrive (double left, double right){
	//True to square inputs 
	//Results in Smoother Control
driveController.tankDrive(left, right, true);	
	
}
public void arcadeDrive(double moveValue, double rotateValue) {
	//True to square inputs 
	//Results in Smoother Control
	driveController.arcadeDrive(moveValue, rotateValue, true);
}

}
