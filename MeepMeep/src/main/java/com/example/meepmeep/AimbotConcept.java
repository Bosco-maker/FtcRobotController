package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Rotation2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class AimbotConcept {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);

        Pose2d beginPose = new Pose2d( 20, 24, Math.toRadians(90));

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        Pose2d RED_GOAL_POSE = new Pose2d(-60, 60 ,0);
        Pose2d BLUE_GOAL_POSE = new Pose2d(-60, -60, 0);
        Pose2d desiredPose = BLUE_GOAL_POSE;

        double goalPosX = desiredPose.position.x;
        double goalPosY = desiredPose.position.y;
        double robotPosX = beginPose.position.x;
        double robotPosY = beginPose.position.y;

        double dX = Math.abs(goalPosX - robotPosX);
        double dY = Math.abs(goalPosY - robotPosY);
        double targetHeading;
        if (desiredPose.equals(RED_GOAL_POSE)) {
            targetHeading = Math.toRadians(180) - Math.atan(dY / dX);
        } else {
            targetHeading = Math.atan(dY / dX) - Math.toRadians(180);
        }
        myBot.runAction(myBot.getDrive().actionBuilder(beginPose)
                .turnTo(targetHeading)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}