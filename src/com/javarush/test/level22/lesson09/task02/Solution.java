package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> x : params.entrySet()){
            if (x.getKey() != null && x.getValue() != null) {
                if (s.length() != 0) s.append(" and ");
                s.append(String.format("%s = '%s'", x.getKey(), x.getValue()));
            }
        }
        return s;
    }

}
