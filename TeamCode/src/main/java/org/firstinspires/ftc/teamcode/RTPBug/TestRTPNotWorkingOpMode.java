package org.firstinspires.ftc.teamcode.RTPBug;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="RTP Not Working")
public class TestRTPNotWorkingOpMode extends LinearOpMode {

    private DcMotor motor;

    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.get(DcMotor.class, "testMotor");

        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(1000);

        waitForStart();

        while (opModeIsActive() && motor.isBusy()) {
            motor.setPower(0.5);
        }
        motor.setPower(0);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

}
