import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex_practice {
    public static void main(String[] args) {
        String str = "Red, blue; Green yellow, purple; orange pink Black, white; gray teal";
        System.out.printf("Original: "+str);
        String clean = cleanedColors(str.toLowerCase());
        System.out.printf("\nCleaned: "+clean);
        String regex = "[,\\.\\s]";
        String[] split = clean.split(regex);
        int i = 1;
        for (String individual : split) {
            System.out.printf("\ncolor "+i+": "+individual);
            i += 1;
        }
        Pattern pattern = Pattern.compile("\\b\\S*b\\S*\\b");
        Matcher containB = pattern.matcher(clean);
        while (containB.find()) {
            System.out.printf("\nHas b: "+containB.group());
}
    }
    public static String cleanedColors(String str){
        str = str.replaceAll("\\p{Punct}", "");
        return str;
    }
}
