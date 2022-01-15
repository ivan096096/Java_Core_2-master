package ru.geekbrains.lessons.lesson_1;


public class Wall implements SportInvintar {

   private int height;

   public Wall(int height) {
      this.height = height;

   }


   @Override
   public boolean TheEnd(Sportsman sportsman) {
      if (sportsman.jump(this.height)) {
         System.out.printf("%s  Прыгнул %d\n", sportsman.getName(), height);
         return true;
      } else {
         System.out.printf("%s НЕ Прыгнул %d\n", sportsman.getName(), height);
         return false;
      }

   }
}

