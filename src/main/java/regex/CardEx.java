package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardEx {
    static float f = Float.MIN_VALUE;

    public static void main(String[] args) {
        String s = "12341234123412341122123;" +
                        "12341234123412341122123;" +
                        "12341234123412341122123;";

        final Pattern pattern = Pattern.compile(
                "(\\d{4})(\\d{4})(\\d{4})(\\d{4})" +
                        "(\\d{2})(\\d{2})" +
                        "(\\d{3})"
        );

       Matcher matcher = pattern.matcher(s);

//        System.out.println(matcher.group());//вместе ошибка
        System.out.println(matcher.replaceAll("$5/$6 $7 $1 $2 $3 $4\n"));

        System.out.println(f);
    }
}
