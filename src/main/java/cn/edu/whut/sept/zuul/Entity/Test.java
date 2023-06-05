package cn.edu.whut.sept.zuul.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Test {
    private String sentence1;
    private String sentence2;
    public Test(){
        sentence1="this is sentence 1";
        sentence2="this is sentence 2";
    }
}
