package ru.geekbrains.lessons.lesson_1;

public class HomeWork {
    public static void main(String[] args) {



            Sportsman[] sportsman = {
                    new Robot(14, 15, "Robocop"),
                    new Human(15, 20, "Ivan"),
                    new Cat(155, 25, "Barsik"),
                    new Cat(20, 2, "Bolbes")
            };


            SportInvintar[] sportInvintars = {
                    new RunningTrack(14),
                    new Wall(10),

            };
            for (Sportsman s : sportsman) {
                for (SportInvintar inv : sportInvintars) {
                    if (!inv.TheEnd(s)) break;

                }
            }

        }


    }

