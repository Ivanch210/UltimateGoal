package org.firstinspires.ftc.teamcode.autonomous

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.HardwareMap

import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.vision.RingPipeline

import org.openftc.easyopencv.OpenCvCamera
import org.openftc.easyopencv.OpenCvCameraFactory
import org.openftc.easyopencv.OpenCvCameraRotation
import org.openftc.easyopencv.OpenCvInternalCamera

open class Vision(private val hardwareMap: HardwareMap) {

    lateinit var phoneCam: OpenCvCamera

    val ringPipeline = RingPipeline()

    fun initRingVision() {

        val cameraMonitorViewId = hardwareMap.appContext.resources.getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.packageName)
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId)

        phoneCam.setPipeline(ringPipeline)

        phoneCam.openCameraDeviceAsync { phoneCam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT) }

    }

}