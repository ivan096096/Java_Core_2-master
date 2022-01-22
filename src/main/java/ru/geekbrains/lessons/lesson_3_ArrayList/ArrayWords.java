package ru.geekbrains.lessons.lesson_3_ArrayList;

/*1. `Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать сколько раз встречается каждое слово.`

2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи.
 С помощью метода get() искать номер телефона по фамилии.
 Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.

Желательно как можно меньше добавлять своего,
        чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
        делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner),
        тестировать просто из метода main() прописывая add() и get().*/



import java.lang.reflect.Array;
import java.util.*;

public class ArrayWords {
    public static void main(String[] args) {

        //WordsCollected();

         telephoneDirectory();


    }

    private static void telephoneDirectory() {

        Phone phone = new Phone();
        phone.add("Ivanov", "11111");
        phone.add("Ivanov", "2222");
        phone.add("Сидоров", "3333");
        phone.add("Сидоров", "4444");
        phone.add("Коклюшкин", "444744");
        phone.add("Коклюшкин", "55555");
        phone.add("Веселов", "66666");

        System.out.println(phone.get("Ivanov") );
        System.out.println(phone.get("Сидоров"));
        System.out.println(phone.get("Коклюшкин"));
        System.out.println(phone.get("Веселов"));
    }



    static class Phone {
        private final Map<String, List<String>> telephone = new HashMap<>();

        public void add(String supername, String phone_number) {
            List<String> phone_number_list;
            if (telephone.containsKey(supername)){
            phone_number_list = telephone.get(supername);
            phone_number_list.add(phone_number);
            }else {
                phone_number_list = new ArrayList<>();
                phone_number_list.add( phone_number);
                telephone.put(supername,phone_number_list);
            }

        }
        public List<String>get (String supername){
            return telephone.get(supername);
        }

    }

    private static void WordsCollected() {
                String[] world = {"Солнце", "Закат", "Расвет", "Дождь", "Дерево", "Травка", "Птичка",
                "Солнце", "Закат", "Расвет", "Дождь", "Расвет",};
        HashMap<String,Integer> map = new HashMap();


        for (String s : world) {
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
        }else {
                map.put(s,1);
            }
         }
        System.out.println(map);

        }


}


        


