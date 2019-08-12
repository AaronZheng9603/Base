package com.aaron.baselib.util;

import android.text.TextUtils;
import com.blankj.utilcode.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 *
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public final class StringUtil {

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String unicodeToString(String unicodeStr) {
        if (unicodeStr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int maxLoop = unicodeStr.length();
        for (int i = 0; i < maxLoop; i++) {
            if (unicodeStr.charAt(i) == '\\') {
                if ((i < maxLoop - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U')))
                    try {
                        sb.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException localNumberFormatException) {
                        sb.append(unicodeStr.charAt(i));
                    }
                else
                    sb.append(unicodeStr.charAt(i));
            } else {
                sb.append(unicodeStr.charAt(i));
            }
        }
        return sb.toString();
    }

    public static boolean isEmpty(CharSequence... args) {
        boolean isEmpty = false;
        for (CharSequence s : args) {
            isEmpty = TextUtils.isEmpty(s);
            if (isEmpty) break;
        }
        return isEmpty;
    }

    public static String reverse(String str) {
        return StringUtils.reverse(str);
    }

    private StringUtil() {

    }
}
