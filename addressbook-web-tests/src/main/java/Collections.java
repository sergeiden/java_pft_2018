import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serg on 24.07.2018.
 */
public class Collections {

  public static void main(String[] args) {
    String langs[] = {"Java", "C#", "Python", "PHP"};

    for (int i = 0; i < langs.length; i++) {
      System.out.println(langs[i]);
    }
    for (String l : langs) {
      System.out.println(l);
    }

    List<String> languages = new ArrayList<>();
    languages.add("Java");
    languages.add("C#");
    for (String l : languages) {
      System.out.println(l);
    }

    List<String> languages1 = Arrays.asList("Java", "C#", "Python", "PHP");
    for (String l1 : languages1) {
      System.out.println(l1);
    }
      for (int i = 0; i < languages1.size(); i++) {
        System.out.println(languages1.get(i));
      }
    }
  }

