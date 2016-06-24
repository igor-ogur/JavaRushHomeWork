package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
   public static int[] getNumbers(int N) {

        ArrayList<Integer> preResult = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            int t = i;
            //int c = Integer.toString(i).length();
            int c = (int) (Math.log10(i)+1);
            int s = 0;
            while (t != 0){
                s += pow(t%10, c);
                t /= 10;
            }

            if (s == i) preResult.add(s);
        }
        int[] result = new int[preResult.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = preResult.get(i);
        }
        return result;
   }

   public static int pow (int x, int p){

        if (p == 1) return x;
        else {
            long res = 1;
            while (p != 0) {
                if (p % 2 == 1){
                    res *= x;
                    p--;
                }
                x *= x;
                p /= 2;
            }
            return (int) res;
        }
   }



   public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        int n = 100000000;
        int[] numbers = getNumbers(n);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();

   }

}
