package com.javarush.test.level19.lesson03.task01;

/* TableAdapter
Измените класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".
Пример, "[Amigo] : DashboardTable"
*/

public class Solution {
    public static void main(String[] args) {
        //это пример вывода

        int i = 3456526;
        String s = String.format("%010d", i);
        System.out.println(String.format("+%d(%s)%s-%s-%s", 38, s.substring(0,3), s.substring(3,6), s.substring(6,8), s.substring(8)));

        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable {

        private ATable aTable;

        public TableAdapter(ATable aTable){
            this.aTable = aTable;
        }

        @Override
        public String getHeaderText() {
            return String.format("[%s] : %s", aTable.getCurrentUserName(), aTable.getTableName());
        }
    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}