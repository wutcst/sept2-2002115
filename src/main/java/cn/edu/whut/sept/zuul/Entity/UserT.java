package cn.edu.whut.sept.zuul.Entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@Alias("UserT")
public class UserT {
    private int id;
    private String username;
    private String password;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private float money;
    //private List<Article> articleList;

}
