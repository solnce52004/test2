package references;

import lombok.extern.java.Log;
import references.students.Student;

@Log
public class MainRefsClass {

    public static void main(String[] args) {
        Student s1 = new Student("Ivan", 1, 1.1);
        Student s2 = new Student("Petr", 2, 2.2);

        //1-------------
        // не можем менять референсы переменных на объекты, передавая их в методы!
        swap(s1, s2);//будут переданны КОПИИ ссылок!!!!

//        log.info(s1.getName());
//        log.info(s2.getName());

        //2-------------
        // тут работаем с оригиналами ссылок! сработает
//        Student s3 = s1;
//        s1 = s2;
//        s2 = s3;

//        log.info(s1.getName());
//        log.info(s2.getName());

        //3-------------
        changeName(s1);//передаем копию ссылки, но объект один и тот же!
        log.info(s1.getName());// имя изменится!

        /////
        //возвращаемые типы
        printTypes();
    }


   static void swap(Student s1, Student s2){
        Student s3 = s1;
        s1 = s2;
        s2 = s3;
    }
   static void changeName(Student s1){
        s1.setName("New Name");
    }

    /**
     * если указан возвращаемый тип, можно возвращать null
     * @return String, null
     */
    String abc(){
        return null;
    }

    /**
     * будет приведение типа
     * @return int
     */
    int abc2(){
        return 'q';
    }
    static void printTypes(){
        MainRefsClass mainRefsClass = new MainRefsClass();
        System.out.println(mainRefsClass.abc());
        System.out.println(mainRefsClass.abc2());
    }
}
