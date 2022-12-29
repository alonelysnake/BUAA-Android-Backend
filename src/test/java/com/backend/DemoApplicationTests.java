package com.backend;

import com.backend.entity.*;
import com.backend.mapper.*;
import com.backend.utils.RunPython;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import static com.backend.utils.ChangeChinesePinyin.changeChinesePinyin;

@SpringBootTest
class DemoApplicationTests {
    
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private IndentMapper indentMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishIndentMapper dishIndentMapper;
    @Autowired
    private ProviderMapper providerMapper;

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
    void addDishIndent() {
        Random random = new Random();
        for (int i = 1;i<=29;i++) {
            int id1 = random.nextInt(5) + 1;
            int id2 = random.nextInt(5) + 1;
            if (id1 == id2)
                id2 = (id2 + 1) % 5 + 1;
            int num1 = random.nextInt(3) + 1;
            int num2 = random.nextInt(3) + 1;
            dishIndentMapper.insert(new DishIndent(i,id1,num1));
            dishIndentMapper.insert(new DishIndent(i,id2,num2));
        }
    }

    @Test
    void addDishData() throws BadHanyuPinyinOutputFormatCombination {
        ArrayList<Dish> dishes = new ArrayList<>();
        Map<String, String> fydmcPinYinMap = changeChinesePinyin("麻婆豆腐");
        dishes.add(new Dish(1,4,5,10,1,1,"1",true,true,"豆腐、辣椒","麻婆豆腐",false,fydmcPinYinMap.get("fullPinyin")));
        fydmcPinYinMap = changeChinesePinyin("糖醋里脊");
        dishes.add(new Dish(1,10,12,12,1,1,"2",true,true,"里脊、白糖、陈醋","糖醋里脊",false,fydmcPinYinMap.get("fullPinyin")));
        fydmcPinYinMap = changeChinesePinyin("风味茄子");
        dishes.add(new Dish(1,5,6,19,4,1,"3",false,false,"茄子","风味茄子",false,fydmcPinYinMap.get("fullPinyin")));
        fydmcPinYinMap = changeChinesePinyin("梅菜扣肉");
        dishes.add(new Dish(1,10,12,14,4,1,"4",false,false,"咸菜、猪肉","梅菜扣肉",false,fydmcPinYinMap.get("fullPinyin")));
        fydmcPinYinMap = changeChinesePinyin("西红柿炒蛋");
        dishes.add(new Dish(1,4,4,14,4,1,"5",false,false,"西红柿、鸡蛋","西红柿炒蛋",true,fydmcPinYinMap.get("fullPinyin")));
        for (Dish dish:dishes) {
            dishMapper.insert(dish);
        }
    }

    @Test
    void addProviderData() {
        providerMapper.insertTest(new Provider("1","合一基本伙","123456",500,205,1,"1","18212682115"));
        providerMapper.insertTest(new Provider("2","合一精品伙","123456",550,205,1,"2","18212682115"));
        providerMapper.insertTest(new Provider("3","合一卤肉饭","123456",470,205,1,"3","18212682115"));
    }

    @Test
    void addIndentData() {
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
