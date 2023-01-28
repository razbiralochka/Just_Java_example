import java.util.ArrayList;
import java.util.Scanner;
class Chelovek
{
    private
    int age;
    String name;

    public
    Chelovek(int age_, String name_)
    {
        name = name_;
        age = age_;
    }
    int age()
    {
        return age;
    }
    String name()
    {
        return name;
    }

    void set_name(String s)
    {
        name = s;
    }

    void set_age(int arg)
    {
        age = arg;
    }

}


class GetInputFromUser {
    public static void main(String args[])
    {
        ArrayList<Chelovek> base = new ArrayList<>();
        while(true)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("1-Показать список людей");
            System.out.println("2-Добавить человека");

            byte key = in.nextByte();
            if (key == 2)
            {
                in = new Scanner(System.in);
                System.out.println("Имя: ");
                String name = in.nextLine();
                System.out.println("Возраст: ");
                int age = in.nextInt();
                Chelovek person = new Chelovek(age, name);
                base.add(person);
            }
            if (key == 1)
            {
                for(int i = 0; i < base.size(); i++)
                {
                    System.out.println(base.get(i).name());
                }
            }
        }
    }
}

