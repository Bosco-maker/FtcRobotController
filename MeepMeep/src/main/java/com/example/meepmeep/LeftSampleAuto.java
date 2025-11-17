package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class LeftSampleAuto {

    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        Pose2d beginPose = new Pose2d(-7.125,63.25 , Math.toRadians(180));

        myBot.runAction(myBot.getDrive().actionBuilder(beginPose)
                .strafeToLinearHeading(new Vector2d(5,28), Math.toRadians(180))//get sample
                .strafeToConstantHeading( new Vector2d(-35.75, 53) )
                .strafeToConstantHeading(new Vector2d(-35.75,30))

                .stopAndAdd(new SleepAction(0.2))

                .splineToConstantHeading(new Vector2d(-47.6,17), Math.toRadians(180))
                .strafeToConstantHeading(new Vector2d( -47.6, 61))
                .strafeToLinearHeading(new Vector2d(-47.6, 48), Math.toRadians(180))

                //get sec spec
                .setTangent(Math.toRadians(270))
                .splineToConstantHeading(new Vector2d(-55, 71), Math.toRadians(90))
                .strafeToLinearHeading(new Vector2d(-40, 71), Math.toRadians(184))

                .stopAndAdd(new SleepAction(0.3))
                .strafeToLinearHeading(new Vector2d(-40, 60), Math.toRadians(180))

                .setTangent(0)
                .splineToLinearHeading(new Pose2d(new Vector2d(-5,30), Math.toRadians(180)), Math.toRadians(270))
                //get third spec
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(new Vector2d(-8,50),Math.toRadians(180)),Math.toRadians(90))

                .splineToConstantHeading(new Vector2d(-55, 71), Math.toRadians(90))
                .strafeToLinearHeading(new Vector2d(-40, 71), Math.toRadians(184))

                .stopAndAdd(new SleepAction(0.3))

                .strafeToLinearHeading(new Vector2d(-40, 60), Math.toRadians(180))
                .setTangent(0)
                .splineToLinearHeading(new Pose2d(new Vector2d(-8,30), Math.toRadians(180)), Math.toRadians(270))

                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-38, 70), Math.toRadians(180))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
    }
