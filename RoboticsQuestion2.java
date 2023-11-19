// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;

public class ElevatorSubsystem extends SubsystemBase {

    private Spark elevatorMotor = new Spark(ElevatorConstants.kMotorPort);
    private Encoder encoder = new Encoder(ElevatorConstants.kEncoderChannelA, ElevatorConstants.kEncoderChannelB);
    private PIDController pidController = new PIDController(2,0,0.8)

    public ElevatorSubsystem() {
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Elevator encoder value", getEncoderMeters());
    }

    public void setMotor(double speed) {
        elevatorMotor.set(speed);
    }

    public double getEncoderMeters() {
        return encoder.get() * ElevatorConstants.kEncoderTick2Meter;
    }

    public void moveUp(){
        setMotor(0.5);
    }

    public void moveDown(){
        setMotor(-0.5);
    }

    public void stop(){
        setMotor(0);
    }
}