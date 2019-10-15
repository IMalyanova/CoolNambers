import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoolNumbers {
    public static void main(String[] args) throws IOException {

        ArrayList<String> coolNumbers = new ArrayList<>();
        String str = "00";
        coolNumbers.add("000");
        coolNumbers.add("ААА");          coolNumbers.add("АОО");
        coolNumbers.add("МОО");          coolNumbers.add("ЕЕЕ");
        coolNumbers.add("ККК");          coolNumbers.add("МММ");
        coolNumbers.add("ННН");          coolNumbers.add("ООО");
        coolNumbers.add("ССС");          coolNumbers.add("УУУ");
        coolNumbers.add("ХХХ");          coolNumbers.add("БОО");

        for (int i = 1; i < 10; i ++){
            coolNumbers.add(str + Integer.toString(i));
            coolNumbers.add(Integer.toString(i) + str);
        }

        int i = 0;
        while (i < 999){
            i += 111;
            coolNumbers.add(Integer.toString(i));
        }

        // Вводится номер и происходит проверка:
        System.out.println("Введите номер (на кирилице): ");
        String scrn = (new BufferedReader(new InputStreamReader(System.in))).readLine();

        Pattern pattern = Pattern.compile("\\s*[А-Яа-я]{1}\\d{3}[А-Яа-я]{2}\\s*+");
        Matcher matcher = pattern.matcher(scrn);
        Boolean result = matcher.matches();

        if (!result){
            System.out.println("Вы неверно ввели данные.");
        } else{
            scrn = scrn.trim();
            String scrn1 = scrn.substring(1,4);
            String[] scrn2 = scrn.split("\\d+");
            String scrn3 = scrn2[0] + scrn2[1];
            if (  (coolNumbers.contains(scrn1))|(coolNumbers.contains(scrn3)) ){
                 System.out.println(scrn + ": *** блатной номер ***");
            }else {
                 System.out.println("Это обычный номер.");
            }
        }

    }
}
