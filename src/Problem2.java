// If the numbers 1 to 5 are written out in words: one, two, three, four, five,
// then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
//NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
// (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.


public class Problem2 {
    public static void main(String[] args){
        int letters = 0;
        for(int i = 1; i < 1001; i++) {
            letters += countDigits(i);
        }
        System.out.println(letters);
    }
    public static int countDigits(int n) {
        int count = 0;
        if(n < 1000) {
            int ones = n % 10;//remainder from n represents the ones
            int tens = n / 10;
            if(n >= 100) {
                tens %= 10;
                int hundreds = n / 100;
                //"one", "two" and "six" hundred => 3 letters in each
                if(hundreds <= 2 || hundreds == 6) {
                    count += 3;
                // "three", "seven" and "eight" hundred => 5 letters in each
                } else if(hundreds == 3 || hundreds == 7 || hundreds == 8) {
                    count += 5;
                 //"five", "four" and "nine" hundred => 4 letters each
                } else if(hundreds <= 5 || hundreds == 9){
                    count += 4;
                }
                //hundred => 7 letters
                count += 7;
                // Ex. "one hundred AND ten"
                if(ones != 0 || tens != 0) {
                    count += 3;
                }
            }
            if(tens == 1) {
                //ten => 3 letters
                if(ones == 0) {
                    count += 3;
                //eleven, twelve => 6 letters
                } else if(ones <= 2) {
                    count += 6;
                //thirteen, fourteen, eighteen, nineteen => 8 letters
                } else if(ones <= 4|| ones >= 8) {
                    count += 8;
                //fifteen and sixteen => 7 letters
                } else if(ones == 5 || ones == 6 ) {
                    count += 7;
                 //seventeen => 9 letters
                } else if(ones == 7) {
                    count += 9;
                }
            } else {
                if(tens != 0) {
                    //twenty, thirty, eighty, ninety => 6 letters
                    if(tens <= 3 || tens >= 8) {
                        count += 6;
                     //sixty, fifty,forty
                    } else if(tens <= 6) {
                        count += 5;
                    } else {
                        //seventy
                        count += 7;
                    }
                }

                if(ones != 0) {
                    //one, two, six => 3 letters
                    if(ones <= 2 || ones == 6) {
                        count += 3;
                    //three, seven, eight => 5 letters
                    } else if(ones == 3 || ones == 7 || ones == 8) {
                        count += 5;
                    //four, five, nine => 4 letters
                    } else if(ones <= 5 || ones == 9){
                        count += 4;
                    }
                }
            }
        } else {
            //one thousand => 11 letters
            count = 11;
        }
        return count;
    }
}