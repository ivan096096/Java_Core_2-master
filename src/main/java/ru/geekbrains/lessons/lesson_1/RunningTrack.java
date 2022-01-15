package ru.geekbrains.lessons.lesson_1;


public class RunningTrack implements SportInvintar {
    private int len;

    public RunningTrack(int len) {
        this.len = len;
    }

    @Override
    public boolean TheEnd(Sportsman sportsman) {
        if (sportsman.run(this.len)) {
            System.out.printf("%s  Пробежал %d\n", sportsman.getName(), len);
            return true;
        } else {
            System.out.printf("%s Не Пробежал %d\n", sportsman.getName(), len);
            return false;
        }
    }
}
