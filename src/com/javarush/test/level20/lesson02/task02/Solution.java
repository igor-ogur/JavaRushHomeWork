package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Igor");
            user1.setLastName("Ogerchuk");
            user1.setCountry(User.Country.UKRAINE);
            user1.setMale(true);
            Calendar calendar = Calendar.getInstance();
            calendar.set(1990, Calendar.SEPTEMBER, 4);
            user1.setBirthDate(calendar.getTime());
            javaRush.users.add(user1);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User x : loadedObject.users){
                System.out.println(x.getFirstName());
                System.out.println(x.getLastName());
                System.out.println(x.getBirthDate());
                System.out.println(x.getCountry());
                System.out.println(x.isMale());
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String s = this.users.isEmpty() ? "empty" : "not empty";
            printWriter.println(s);
            for (User x : this.users){
                printWriter.println(x.getFirstName());
                printWriter.println(x.getLastName());
                printWriter.println(x.getBirthDate().getTime());
                printWriter.println(x.getCountry().getDisplayedName());
                printWriter.println(x.isMale());
                //printWriter.println("end user");
            }
            printWriter.println("end");
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.readLine().equals("not empty")){
                String s = reader.readLine();
                while (!s.equals("end")){
                    User user = new User();
                    user.setFirstName(s);
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    s = reader.readLine();
                    if (s.equals(User.Country.UKRAINE.getDisplayedName())) user.setCountry(User.Country.UKRAINE);
                    if (s.equals(User.Country.RUSSIA.getDisplayedName())) user.setCountry(User.Country.RUSSIA);
                    if (s.equals(User.Country.OTHER.getDisplayedName())) user.setCountry(User.Country.OTHER);
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    this.users.add(user);
                    s = reader.readLine();
                }
            }else reader.readLine();
            reader.close();
        }
    }
}
