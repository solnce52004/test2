package strings.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrIter {
    public static void printIter() {

        String s1 = "Dfgfgf dfdfdgfg. Dfgfgf dfdfdgfg, dfgdgfdg dfdfgf dfgdgdfg: dfgdgdfgdg. Gffgfggf fgfgdgf dfgdfgdg!";
        String s2 = s1.toUpperCase();

        char ch1;
        char ch2;
        Character[] c = {' ','!', ',', '.', ':'};
        List<Character> specChars = Arrays.asList(c);

        for (int i = 0; i < s1.length(); i++) {
            ch1 = s1.charAt(i);
            ch2 = s2.charAt(i);

            // слова с большой буквы выводим с новой строки
            // большие буквы (и не знаки препинания)
            boolean isSpec = specChars.contains(ch1);
            if (ch1 == ch2 && !isSpec){
                System.out.println();
                System.out.print(ch1);
                continue;
            }

            System.out.print(ch1);
        }
        System.out.println();
    }

}
