package org.example04.atomic;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *
 *
 * @author zhangyf
 * CAS + AtomicStampedReference 防止ABA问题
 * LongAdder和AtomicLong
 * @date 2024/6/27 13:31
 */

public class TestAtomicStampedReference {

    public static void main(String[] args) {

        String str1 = "aaa";
        String str2 = "bbb";
        //创建AtomicStampedReference对象
        AtomicStampedReference<String> reference = new AtomicStampedReference<>(str1,1);

        //  = 比较和设置
        reference.compareAndSet(str1,str2,reference.getStamp(),reference.getStamp()+1);

        System.out.println("reference.getReference() = " + reference.getReference());

        boolean b = reference.attemptStamp(str2, reference.getStamp() + 1);
        System.out.println("b: "+b);
        System.out.println("reference.getStamp() = "+reference.getStamp());

        boolean c = reference.weakCompareAndSet(str2,"ccc",4, reference.getStamp()+1);
        System.out.println("reference.getReference() = "+reference.getReference());
        System.out.println("c = " + c);
    }

//    输出:
//            reference.getReference() = bbb
//    b: true
//            reference.getStamp() = 3
//            reference.getReference() = bbb
//            c = false
//    c为什么输出false呢, 因为版本戳不一致啦

    @Test
    public void test() {


                // 这是你的无横杠UUID字符串
                String noDashUUID = "550e8400e29b41d4a716446655440000";

                // 将字符串转换为long数组，分别代表timeLow, timeMid, timeHiAndVersion,
                // clockSeqHiAndReserved, clockSeqLow, node
                long mostSigBits = Long.parseUnsignedLong(noDashUUID.substring(0, 16), 16);
                long leastSigBits = Long.parseUnsignedLong(noDashUUID.substring(16), 16);
                // 创建UUID对象
                UUID uuid = new UUID(mostSigBits, leastSigBits);

                // 输出带有横杠的UUID
                System.out.println(uuid.toString());

    }
}
