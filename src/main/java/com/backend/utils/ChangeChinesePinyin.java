package com.backend.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeChinesePinyin {
    public static Map<String, String> changeChinesePinyin(String chinese) throws BadHanyuPinyinOutputFormatCombination {
        Map<String, String> pinyin = new HashMap<String, String>();

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        StringBuffer fullPinyin = new StringBuffer();
        StringBuffer simplePinyin = new StringBuffer();
        StringBuffer firstPinyin = new StringBuffer();

        char[] chineseChar = chinese.toCharArray();
        for (int i = 0; i < chineseChar.length; i++) {
            String[] str = null;
            try {
                str = PinyinHelper.toHanyuPinyinStringArray(chineseChar[i],
                        format);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            if (str != null) {
                if (str.length == 0) {
                    continue;
                }
                fullPinyin = fullPinyin.append(str[0].toString());
                simplePinyin = simplePinyin.append(str[0].charAt(0));

            }
            if (str == null) {
                String regex = "^[0-9]*[a-zA-Z]*+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher m = pattern.matcher(String.valueOf(chineseChar[i]));
                if (m.find()) {
                    fullPinyin = fullPinyin.append(chineseChar[i]);
                    simplePinyin = simplePinyin.append(chineseChar[i]);
                }
            }
        }
        String[] name = PinyinHelper.toHanyuPinyinStringArray(chineseChar[0], format);
        if(name == null && fullPinyin.substring(0,1).matches("[a-zA-Z]")){
            name = new String[]{fullPinyin.substring(0,1)};
        }else if (name == null){
            name = new String[]{"#"};
        }
        firstPinyin = firstPinyin.append(name[0].charAt(0));
        pinyin.put("fullPinyin", fullPinyin.toString());
        pinyin.put("simplePinyin", simplePinyin.toString().toUpperCase());
        pinyin.put("groupPinyin", firstPinyin.toString().toUpperCase());
        return pinyin;
    }


}