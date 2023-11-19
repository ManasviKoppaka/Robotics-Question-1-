// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private Spark leftMotor 1 = new Spark(0);
  private Spark leftMotor 2 = new Spark(1);
  private Spark rightMotor 1 = new Spark(2);
  private Spark rightMotor 2 = new Spark(3);

  private Joystick joy1 = new Joystick(0);

  private double startTime;

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    startTime = Timer.getFGATimerstamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFGATimestamp();

  while (time-startTime < 10){
    leftMotor1.set(0.6);
    leftMotor2.set(0.6);
    rightMotor1.set(-0.6);
    rigtMotor2.set(-0.6);
  } elif (time-startTime<12){
    leftMotor1.set(0.6);
    leftMotor2.set(0.6);
    rightMotor1.set(0.6);
    rigtMotor2.set(0.6);
  } else{
    leftMotor1.set(0);
    leftMotor2.set(0);
    rightMotor1.set(0);
    rigtMotor2.set(0);
  }
    
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double speed = -joy1.getRawAxis(1) * 0.6;
    double turn  = joy1.getRawAxis(0) * 0.3;

    double left = speed + turn;
    double right = speed - turn; 

    leftMotor1.set(left);
    leftMotor2.set(left);
    rightMotor1.set(-right);
    rigtMotor2.set(-right);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
