
package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants.IntakeState;

public class Intake extends SubsystemBase{
    private CANSparkFlex m1;  
    private CANSparkFlex m2; 
    private IntakeState intakeState; 


    public Intake() {
        m1=new CANSparkFlex(Constants.IntakeConstants.m1id, MotorType.kBrushless);
        m2=new CANSparkFlex(Constants.IntakeConstants.m2id, MotorType.kBrushless);
        m2.follow(m1);
        m2.setInverted(true); 
    }
    @Override 
    public void periodic(){
        m1.set(intakeState.speed);
    }

    public void setState(IntakeState state){
        intakeState=state; 
    }
}


