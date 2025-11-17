package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class CirclingAuto {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);

        Pose2d beginPose = new Pose2d( 0, 48, Math.toRadians(90));

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(beginPose)
                .strafeToConstantHeading(new Vector2d(0, 54))
                .setTangent(Math.toRadians(180))
                .splineToSplineHeading(new Pose2d(-10, 48, Math.toRadians(0)), Math.toRadians(270))
                .splineToSplineHeading(new Pose2d(0, 38, Math.toRadians(90)), Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(10, 48, Math.toRadians(180)), Math.toRadians(90))
                .splineToSplineHeading(new Pose2d(0, 58, Math.toRadians(270)), Math.toRadians(180))

                .splineToSplineHeading(new Pose2d(-10, 48, Math.toRadians(0)), Math.toRadians(270))
                .splineToSplineHeading(new Pose2d(0, 38, Math.toRadians(90)), Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(10, 48, Math.toRadians(180)), Math.toRadians(90))
                .splineToSplineHeading(new Pose2d(0, 58, Math.toRadians(270)), Math.toRadians(180))

                .splineToSplineHeading(new Pose2d(-10, 48, Math.toRadians(0)), Math.toRadians(270))
                .splineToSplineHeading(new Pose2d(0, 38, Math.toRadians(90)), Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(10, 48, Math.toRadians(180)), Math.toRadians(90))
                .splineToSplineHeading(new Pose2d(0, 58, Math.toRadians(270)), Math.toRadians(180))

                .splineToSplineHeading(new Pose2d(-10, 48, Math.toRadians(0)), Math.toRadians(270))
                .splineToSplineHeading(new Pose2d(0, 38, Math.toRadians(90)), Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(10, 48, Math.toRadians(180)), Math.toRadians(90))
                .splineToSplineHeading(new Pose2d(0, 58, Math.toRadians(270)), Math.toRadians(180))

                .splineToSplineHeading(new Pose2d(-10, 48, Math.toRadians(0)), Math.toRadians(270))
                .splineToSplineHeading(new Pose2d(0, 38, Math.toRadians(90)), Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(10, 48, Math.toRadians(180)), Math.toRadians(90))
                .splineToSplineHeading(new Pose2d(0, 58, Math.toRadians(270)), Math.toRadians(180))

                .strafeToSplineHeading(new Vector2d(0, 48), Math.toRadians(90))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}