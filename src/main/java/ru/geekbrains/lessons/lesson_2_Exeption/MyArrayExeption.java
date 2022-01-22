
/* 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод,
обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета
(сумму элементов, при условии что подали на вход корректный массив).
     Заметка: Для преобразования строки к числу используйте статический метод класса Integer:
Integer.parseInt(сюда_подать_строку);
   Заметка: Если Java не сможет преобразовать входную строку (в строке число криво написано),
то будет сгенерировано исключение NumberFormatException.
 */

package ru.geekbrains.lessons.lesson_2_Exeption;




public class MyArrayExeption {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "35", "3", "4"},
                {"4", "5", "5", "6"},
                {"11", "2", "7", "8"},
                {"7", "8", "12", "11"},
                {"11", "2", "7", "8"}};

            try {
                Array(arr);

            } catch (MyArraySizeException e) {
                System.out.println("Очень большой массив");
            }

        catch (MyArrayDataException e){
            System.out.println("Неправельное значение");
        }

    }


    public static void Array(String[][] arr) throws MyArrayDataException, MyArraySizeException {

        int sum = 0;
        if (arr.length != 4)
            throw new MyArraySizeException();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4)
                throw new MyArraySizeException();
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);

                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
            System.out.print(sum);

    }
}




