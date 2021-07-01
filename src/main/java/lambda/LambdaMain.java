package lambda;

public class LambdaMain {

   static void getStudentInfo(StudentInterface i){
      int res = i.test("Hello");

       System.out.println(res);
    }

    public static void main(String[] args) {
        getStudentInfo(String::length);
    }
}

@FunctionalInterface
interface StudentInterface{
     int ST_VAR = 5;//final static - по умолчанию!
    static int getA(){
        return ST_VAR;
    }
    default void printHello(){
        System.out.println("Hello");
    }

    int test(String s);
//    int test2(String s);// - 2-ой НЕЛЬЗЯ для функциональных интерфейсов (для исп-ия в лямбда)
}