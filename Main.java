import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
class Chelovek
{
    private
    String name, city, phone;

    public
    Chelovek(String name_, String city_, String phone_)
    {
        name = name_;
        city = city_;
        phone = phone_;
    }

    String phone()
    {
        return phone;
    }
    String city()
    {
        return city;
    }
    String name()
    {
        return name;
    }
}



class database
{
    public
            Connection conn;
            Statement statement;
            ResultSet res;
    void Read_db() throws SQLException
    {
        res = statement.executeQuery("SELECT * FROM persons");
        while(res.next())
        {
            String  name = res.getString("name");
            String  city = res.getString("city");
            String  phone = res.getString("phone");
            System.out.println(name+" "+city+" "+phone);

        }
    }
    void Read_from_db(String arg) throws ClassCastException, SQLException
    {
        res = statement.executeQuery("SELECT * FROM persons WHERE name = '"+ arg+"'");
        String city = res.getString("city");
        String phone = res.getString("phone");
        System.out.println(arg+" "+city+" "+phone);

    }
    database()
    {
        String url = "jdbc:sqlite:mybase.db";
        try
        {
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            statement = conn.createStatement();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}




class GetInputFromUser {
    public static database base =  new database();
    public static void get_put_info()
    {   Scanner in = new Scanner(System.in);
        System.out.println("Имя: ");
        String name = in.nextLine();
        System.out.println("Город: ");
        String city = in.nextLine();
        System.out.println("Номер: ");
        String phone = in.nextLine();
        Chelovek person = new Chelovek(name, city,name);
        //base.add(person);

    }
    public static  void show_info() throws SQLException
    {
        base.Read_db();
    }

    public static void find() throws  SQLException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Имя: ");
        String name = in.nextLine();
        base.Read_from_db(name);
    }

    public static void main(String args[]) throws SQLException
    {
        ArrayList<Chelovek> base = new ArrayList<>();
        while(true)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("1-Показать список людей в БД");
            System.out.println("2-Добавить человека в БД");
            System.out.println("3-Удалить человека из БД");
            System.out.println("4-Поиск человека в БД по имени");
            System.out.println("0-Выход");

            byte key = in.nextByte();
            if (key == 0) break;
            if (key == 2) get_put_info();
            if (key == 1) show_info();
            if (key == 4) find();
        }
    }
}

