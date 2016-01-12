/*
This class is under http://www.gnu.org/licenses/gpl-3.0.en.html license


 */


package pl.grzegorz2047.bukkitalikeClasses;


import java.util.Map;
import java.util.regex.Pattern;


import cn.nukkit.utils.Color;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.Validate;

/**
 * Created by grzegorz2047 on 12.01.2016.
 */
public enum ChatColor {


    BLACK('0', Color.blackColor),

    DARK_BLUE('1', Color.blueColor),

    DARK_GREEN('2', Color.greenColor),

    DARK_AQUA('3', Color.blueColor),

    DARK_RED('4', Color.redColor),

    DARK_PURPLE('5', Color.purpleColor),

    GOLD('6', Color.goldColor),

    GRAY('7', Color.grayColor),

    DARK_GRAY('8', Color.grayColor),

    BLUE('9', Color.blueColor),

    GREEN('a', Color.greenColor),

    AQUA('b', Color.waterColor),

    RED('c', Color.redColor),

    LIGHT_PURPLE('d', Color.purpleColor),

    YELLOW('e', Color.yellowColor),

    WHITE('f', Color.whiteColor);

    public static final char COLOR_CHAR = '\u00A7';
    private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)" + String.valueOf(COLOR_CHAR) + "[0-9A-FK-OR]");

    private final char code;
    private final String toString;
    private final static Map<Character, ChatColor> BY_CHAR = Maps.newTreeMap();
    private final Color color;


    private ChatColor(char code, Color intCode) {
        this.code = code;
        this.color = intCode;
        this.toString = new String(new char[]{COLOR_CHAR, code});
    }

    public char getChar() {
        return code;
    }

    @Override
    public String toString() {
        return toString;
    }


    public static ChatColor getByChar(char code) {
        return BY_CHAR.get(code);
    }

    public static ChatColor getByChar(String code) {
        Validate.notNull(code, "Code cannot be null");
        Validate.isTrue(code.length() > 0, "Code must have at least one char");

        return BY_CHAR.get(code.charAt(0));
    }

    public static String stripColor(final String input) {
        if (input == null) {
            return null;
        }

        return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }

    public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == altColorChar && "0123456789AaBbCcDdEeFf".indexOf(b[i + 1]) > -1) {
                b[i] = ChatColor.COLOR_CHAR;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }
        return new String(b);
    }

    public static String getLastColors(String input) {
        String result = "";
        int length = input.length();

        for (int index = length - 1; index > -1; index--) {
            char section = input.charAt(index);
            if (section == COLOR_CHAR && index < length - 1) {
                char c = input.charAt(index + 1);
                ChatColor color = getByChar(c);

                if (color != null) {
                    result = color.toString() + result;
                }
            }
        }

        return result;
    }

    static {
        for (ChatColor color : values()) {
            BY_CHAR.put(color.code, color);
        }
    }
}

