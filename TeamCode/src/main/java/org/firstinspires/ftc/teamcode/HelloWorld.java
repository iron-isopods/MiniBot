package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Disabled
// Simple Logging
/*
@TeleOp
public class HelloWorld extends OpMode {
    @Override
    public void init() {
        telemetry.addData("hello","abhiram");
    }
    @Override
    public void loop(){
        telemetry.addData("hello","the isopod is iron." + System.currentTimeMillis());
        telemetry.update();
    }
}
*/
/*
// Slightly Modified Version of the Gamepad Edge Detection Sample Code
// "WasPressed" meaning in between frames to prevent data loss.
@TeleOp(name="Concept: Gamepad Edge Detection", group ="Concept")
public class HelloWorld extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Wait for the DS start button to be pressed
        waitForStart();

        while (opModeIsActive()) {
            // Update the telemetry
            telemetryButtonData();

            // Wait 2 seconds before doing another check
            sleep(16);
        }
    }

    public void telemetryButtonData() {
        // Add the status of the Gamepad 1 Left Bumper
        telemetry.addData("Gamepad 1 Left BumBum Pressed", gamepad1.leftBumperWasPressed());
        //telemetry.addData("Gamepad 1 Left Bumper Released", gamepad1.leftBumperWasReleased());
        telemetry.addData("Gamepad 1 Left Bumper Status", gamepad1.left_bumper);

        // Add an empty line to separate the buttons in telemetry
        telemetry.addLine();

        // Add the status of the Gamepad 1 Right Bumper
        telemetry.addData("Gamepad 1 Right Bumper Pressed", gamepad1.rightBumperWasPressed());
        //telemetry.addData("Gamepad 1 Right Bumper Released", gamepad1.rightBumperWasReleased());
        telemetry.addData("Gamepad 1 Right Bumper Status", gamepad1.right_bumper);

        // Add an empty line to separate the buttons in telemetry
        telemetry.addLine();

        // Add the status of the Gamepad 1 Left trigger
        telemetry.addData("Gamepad 1 Left Trigger Pressed", gamepad1.leftTriggerWasPressed());
        //telemetry.addData("Gamepad 1 Left Trigger Released", gamepad1.leftTriggerWasReleased());
        telemetry.addData("Gamepad 1 Left Trigger Status", gamepad1.left_trigger_pressed);

        // Add an empty line to separate the buttons in telemetry
        telemetry.addLine();

        // Add the status of the Gamepad 1 Right trigger
        telemetry.addData("Gamepad 1 Right Trigger Pressed", gamepad1.rightTriggerWasPressed());
        //telemetry.addData("Gamepad 1 Right Trigger Released", gamepad1.rightTriggerWasReleased());
        telemetry.addData("Gamepad 1 Right Trigger Status", gamepad1.right_trigger_pressed);

        // Add a note that the telemetry is only updated every 2 seconds
        telemetry.addLine("\nTelemetry is updated every 2 seconds.");

        // Update the telemetry on the DS screen
        telemetry.update();
    }
}

 */

/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

//package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/*
 * This OpMode scans a single servo back and forward until Stop is pressed.
 * The code is structured as a LinearOpMode
 * INCREMENT sets how much to increase/decrease the servo position each cycle
 * CYCLE_MS sets the update period.
 *
 * This code assumes a Servo configured with the name "left_hand" as is found on a Robot.
 *
 * NOTE: When any servo position is set, ALL attached servos are activated, so ensure that any other
 * connected servos are able to move freely before running this test.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

// Tests Servo
/*
@TeleOp(name = "Concept: Scan Servo", group = "Concept")
//@Disabled
public class HelloWorld extends LinearOpMode {

    static final double INCREMENT   = 0.09;     // amount to slew servo each CYCLE_MS cycle
    static final int    CYCLE_MS    =   50;     // period of each cycle
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position

    // Define class members
    Servo   servo;
    double  position = (MAX_POS - MIN_POS) / 2; // Start at halfway position
    boolean rampUp = true;


    @Override
    public void runOpMode() {

        // Connect to servo (Assume Robot Left Hand)
        // Change the text in quotes to match any servo name on your robot.
        servo = hardwareMap.get(Servo.class, "left_hand");

        // Wait for the start button
        telemetry.addData(">", "Press Start to scan Servo." );
        telemetry.update();
        waitForStart();


        // Scan servo till stop pressed.
        while(opModeIsActive()){

            // slew the servo, according to the rampUp (direction) variable.
            if (rampUp) {
                // Keep stepping up until we hit the max value.
                position += INCREMENT ;
                if (position >= MAX_POS ) {
                    position = MAX_POS;
                    rampUp = !rampUp;   // Switch ramp direction
                }
            }
            else {
                // Keep stepping down until we hit the min value.
                position -= INCREMENT ;
                if (position <= MIN_POS ) {
                    position = MIN_POS;
                    rampUp = !rampUp;  // Switch ramp direction
                }
            }

            // Display the current value
            telemetry.addData("Servo Position", "%5.2f", position);
            telemetry.addData(">", "Press Stop to end test." );
            telemetry.update();

            // Set the servo to the new position and pause;
            servo.setPosition(position);
            sleep(CYCLE_MS);
            idle();
        }

        // Signal done;
        telemetry.addData(">", "Done");
        telemetry.update();
    }
}

*/

/*
Copyright (c) 2023 FIRST

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of FIRST nor the names of its contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
//package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;

/*
 * This OpMode illustrates how to use the DFRobot HuskyLens.
 *
 * The HuskyLens is a Vision Sensor with a built-in object detection model.  It can
 * detect a number of predefined objects and AprilTags in the 36h11 family, can
 * recognize colors, and can be trained to detect custom objects. See this website for
 * documentation: https://wiki.dfrobot.com/HUSKYLENS_V1.0_SKU_SEN0305_SEN0336
 *
 * For detailed instructions on how a HuskyLens is used in FTC, please see this tutorial:
 * https://ftc-docs.firstinspires.org/en/latest/devices/huskylens/huskylens.html
 *
 * This sample illustrates how to detect AprilTags, but can be used to detect other types
 * of objects by changing the algorithm. It assumes that the HuskyLens is configured with
 * a name of "huskylens".
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */


//@TeleOp(name = "Sensor: HuskyLens", group = "Sensor")
//public class HelloWorld extends LinearOpMode {
//
//    private final int READ_PERIOD = 1;
//
//    private HuskyLens huskyLens;
//
//    @Override
//    public void runOpMode()
//    {
//        huskyLens = hardwareMap.get(HuskyLens.class, "huskylens");
//
//        /*
//         * This sample rate limits the reads solely to allow a user time to observe
//         * what is happening on the Driver Station telemetry.  Typical applications
//         * would not likely rate limit.
//         */
//        Deadline rateLimit = new Deadline(READ_PERIOD, TimeUnit.SECONDS);
//
//        /*
//         * Immediately expire so that the first time through we'll do the read.
//         */
//        rateLimit.expire();
//
//        /*
//         * Basic check to see if the device is alive and communicating.  This is not
//         * technically necessary here as the HuskyLens class does this in its
//         * doInitialization() method which is called when the device is pulled out of
//         * the hardware map.  However, sometimes it's unclear why a device reports as
//         * failing on initialization.  In the case of this device, it's because the
//         * call to knock() failed.
//         */
//        if (!huskyLens.knock()) {
//            telemetry.addData(">>", "Problem communicating with " + huskyLens.getDeviceName());
//        } else {
//            telemetry.addData(">>", "Press start to continue");
//        }
//
//        /*
//         * The device uses the concept of an algorithm to determine what types of
//         * objects it will look for and/or what mode it is in.  The algorithm may be
//         * selected using the scroll wheel on the device, or via software as shown in
//         * the call to selectAlgorithm().
//         *
//         * The SDK itself does not assume that the user wants a particular algorithm on
//         * startup, and hence does not set an algorithm.
//         *
//         * Users, should, in general, explicitly choose the algorithm they want to use
//         * within the OpMode by calling selectAlgorithm() and passing it one of the values
//         * found in the enumeration HuskyLens.Algorithm.
//         *
//         * Other algorithm choices for FTC might be: OBJECT_RECOGNITION, COLOR_RECOGNITION or OBJECT_CLASSIFICATION.
//         */
//        huskyLens.selectAlgorithm(HuskyLens.Algorithm.FACE_RECOGNITION);
//        telemetry.update();
//        waitForStart();
//
//        /*
//         * Looking for AprilTags per the call to selectAlgorithm() above.  A handy grid
//         * for testing may be found at https://wiki.dfrobot.com/HUSKYLENS_V1.0_SKU_SEN0305_SEN0336#target_20.
//         *
//         * Note again that the device only recognizes the 36h11 family of tags out of the box.
//         */
//        while(opModeIsActive()) {
//            if (!rateLimit.hasExpired()) {
//                continue;
//            }
//            rateLimit.reset();
//
//            /*
//             * All algorithms, except for LINE_TRACKING, return a list of Blocks where a
//             * Block represents the outline of a recognized object along with its ID number.
//             * ID numbers allow you to identify what the device saw.  See the HuskyLens documentation
//             * referenced in the header comment above for more information on IDs and how to
//             * assign them to objects.
//             *
//             * Returns an empty array if no objects are seen.
//             */
//            HuskyLens.Block[] blocks = huskyLens.blocks();
//            telemetry.addData("Block count", blocks.length);
//            for (int i = 0; i < blocks.length; i++) {
//                telemetry.addData("Block", blocks[i].toString());
//                /*
//                 * Here inside the FOR loop, you could save or evaluate specific info for the currently recognized Bounding Box:
//                 * - blocks[i].width and blocks[i].height   (size of box, in pixels)
//                 * - blocks[i].left and blocks[i].top       (edges of box)
//                 * - blocks[i].x and blocks[i].y            (center location)
//                 * - blocks[i].id                           (Color ID)
//                 *
//                 * These values have Java type int (integer).
//                 */
//            }
//
//            telemetry.update();
//        }
//    }
//}

//Controller moves servo
@TeleOp(name = "Concept: Scan Servo", group = "Concept")
//@Disabled
public class HelloWorld extends LinearOpMode {

    static final double INCREMENT   = 0.09;     // amount to slew servo each CYCLE_MS cycle
    static final int    CYCLE_MS    =   20;     // period of each cycle
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position

    // Define class members
    Servo   servo;
    double  position = (MAX_POS - MIN_POS) / 2; // Start at halfway position
    double toggle_value = 0;
    boolean lastx, currx = false;

    @Override
    public void runOpMode() {

        // Connect to servo (Assume Robot Left Hand)
        // Change the text in quotes to match any servo name on your robot.
        servo = hardwareMap.get(Servo.class, "left_hand");

        // Wait for the start button
        telemetry.addData(">", "Press Start to scan Servo." );
        telemetry.update();
        waitForStart();


        // Scan servo till stop pressed.
        while(opModeIsActive()){

            // slew the servo, according to the rampUp (direction) variable.
           position = toggle_value;
           currx = gamepad1.x;
           if (currx && !lastx){
               toggle_value = 1 - toggle_value;
           }
            lastx = currx;
            // Display the current value
            telemetry.addData("Servo Position", "%5.2f", toggle_value);
            telemetry.addData(">", "Press Stop to end test." );
            telemetry.update();

            // Set the servo to the new position and pause;
            servo.setPosition(position);
            sleep(CYCLE_MS);
            idle();
        }

        // Signal done;
        telemetry.addData(">", "Done");
        telemetry.update();
    }
}
