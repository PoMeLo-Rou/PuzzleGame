package com.itheima.util;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

/**
 * CodeUtil 类用于生成随机验证码。
 */
public class CodeUtil {
    // 定义小写字母的ASCII起始值和大写字母的ASCII起始值
    private static final int LOWER_CASE_START = 97;
    private static final int UPPER_CASE_START = 65;
    private static final int NUMBER_COUNT = 10;
    private static final int LETTER_COUNT = 52;
    private static final int CODE_LENGTH = 5;

    /**
     * 生成一个包含大小写字母和数字的随机验证码。
     *
     * @return 随机生成的验证码字符串。
     */
    public static String getCode() {
        // 初始化结果字符串构建器
        StringBuilder result = new StringBuilder();
        // 创建安全随机数生成器
        SecureRandom r = new SecureRandom();

        // 生成前四个字符，随机选择大小写字母
        generateRandomLetters(result, r);

        // 生成一个随机数字，作为验证码的最后一位
        generateRandomNumber(result, r);

        // 将结果字符串数组进行随机交换
        shuffleCode(result, r);

        // 返回最终的验证码字符串
        return result.toString();
    }

    /**
     * 生成随机字母
     *
     * @param result 结果字符串构建器
     * @param r 随机数生成器
     */
    private static void generateRandomLetters(StringBuilder result, SecureRandom r) {
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(LETTER_COUNT);
            char letter = (char) (randomIndex % 26 + LOWER_CASE_START);
            if (randomIndex >= 26) {
                letter += UPPER_CASE_START - LOWER_CASE_START;
            }
            result.append(letter);
        }
    }

    /**
     * 生成随机数字
     *
     * @param result 结果字符串构建器
     * @param r 随机数生成器
     */
    private static void generateRandomNumber(StringBuilder result, SecureRandom r) {
        int randomNumber = r.nextInt(NUMBER_COUNT);
        result.append(randomNumber);
    }

    /**
     * 随机交换结果字符串中的两个字符
     *
     * @param result 结果字符串构建器
     * @param r 随机数生成器
     */
    private static void shuffleCode(StringBuilder result, SecureRandom r) {
        char[] chars = result.toString().toCharArray();
        int index = r.nextInt(chars.length);
        char temp = chars[4];
        chars[4] = chars[index];
        chars[index] = temp;
        result.replace(0, result.length(), new String(chars));
    }
}
