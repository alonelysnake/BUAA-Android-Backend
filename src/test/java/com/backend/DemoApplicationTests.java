package com.backend;

import com.backend.entity.Activity;
import com.backend.entity.Indent;
import com.backend.mapper.ActivityMapper;
import com.backend.mapper.IndentMapper;
import com.backend.utils.RunPython;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

import static com.backend.utils.ChangeChinesePinyin.changeChinesePinyin;

@SpringBootTest
class DemoApplicationTests {
    
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private IndentMapper indentMapper;

    @Test
    void testPinyin() throws BadHanyuPinyinOutputFormatCombination {
        Map<String, String> fydmcPinYinMap = changeChinesePinyin("拼音");
        System.out.println(fydmcPinYinMap.get("fullPinyin"));
        String simplePinyin = fydmcPinYinMap.get("simplePinyin");
        System.out.println(simplePinyin);
        System.out.println(fydmcPinYinMap.get("groupPinyin"));
        System.out.println(simplePinyin+":最终");
    }

    @Test
    void testPython() {
        RunPython.runSpeech();
    }

    @Test
    void addData() {
        int N = 6;
        for (int i = 1;i<N;i++) {
            indentMapper.insert(new Indent(i, LocalDateTime.of(2022,12,30,8,11+i),
                    LocalDateTime.of(2022,12,30,9,30+i),100+i*3, Indent.OrderState.PAID,"学生7公寓303",Integer.toString(i%4+1),Integer.toString(i%3+2),Integer.toString(i%3+1),"",i%3+1));
        }
        for (int i = N;i<2*N;i++) {
                indentMapper.insert(new Indent(i, LocalDateTime.of(2022,12,30,8,11+i),
                        LocalDateTime.of(2022,12,30,8,30+i),100+i*3, Indent.OrderState.NOT_ACCEPT,"学生7公寓303",Integer.toString(i%4+1),Integer.toString(i%3+2),Integer.toString(i%3+1),"",i%3+1));
        }
        for (int i = 2*N;i<3*N;i++) {

                indentMapper.insert(new Indent(i, LocalDateTime.of(2022,12,30,8,11+i),
                        LocalDateTime.of(2022,12,30,8,30+i),100+i*3, Indent.OrderState.ACCEPTED,"学生7公寓303",Integer.toString(i%4+1),Integer.toString(i%3+2),Integer.toString(i%3+1),"",i%3+1));

        }

        for (int i = 3*N;i<4*N;i++) {

                indentMapper.insert(new Indent(i, LocalDateTime.of(2022,12,30,8,11+i),
                        LocalDateTime.of(2022,12,30,8,30+i),100+i*3, Indent.OrderState.DELIVERING,"学生7公寓303",Integer.toString(i%4+1),Integer.toString(i%3+2),Integer.toString(i%3+1),"",i%3+1));

        }

        for (int i = 4*N;i<5*N;i++) {

                indentMapper.insert(new Indent(i, LocalDateTime.of(2022,12,30,8,11+i),
                        LocalDateTime.of(2022,12,30,8,30+i),100+i*3, Indent.OrderState.FINISHED,"学生7公寓303",Integer.toString(i%4+1),Integer.toString(i%3+2),Integer.toString(i%3+1),"",i%3+1));

        }
    }

    @Test
    void testInsert() {
        // activityMapper.insertActivity(LocalDateTime.now(),LocalDateTime.now(),1);
    }

}
