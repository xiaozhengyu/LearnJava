package learnspringboot.xiao.learnjava.thread;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author xzy
 * @date 2019-12-14 16:23
 * 说明：
 */
@Data
public class Threadlocal {
    public static void main(String[] args) {
        List<Integer> integers = Threadlocal.randomIntegerList();
        System.out.println(Arrays.toString(integers.toArray()));

        int numBiggerThanSix = 0;
        for (Integer integer : integers) {
            if (integer > 6) {
                numBiggerThanSix++;
            }
        }
        System.out.println("the number bigger than six = " + numBiggerThanSix);

        Long numBiggerThanSix2 = integers.parallelStream().filter(integer -> integer > 6).count();
        System.out.println("the number bigger than six = " + numBiggerThanSix2);

        Stream<Integer> integerStream = integers.parallelStream().filter(integer -> integer > 6);
        System.out.println(Arrays.toString(integerStream.toArray()));

        integerStream = integers.parallelStream().map(integer -> integer + 1);
        System.out.println(Arrays.toString(integerStream.toArray()));

    }

    /**
     * 产生随机数组
     */
    public static List<Integer> randomIntegerList() {
        Random random = new Random();
        int length = random.nextInt(9) + 1;
        List<Integer> integers = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            integers.add(random.nextInt(9));
        }
        return integers;
    }
}


