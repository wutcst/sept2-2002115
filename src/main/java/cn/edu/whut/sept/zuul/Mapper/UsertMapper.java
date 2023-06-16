package cn.edu.whut.sept.zuul.Mapper;


import cn.edu.whut.sept.zuul.Entity.UserT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("usertMapper")
public interface UsertMapper
{   //获取用户表列
    int getCount();
    //获取用户表列
    List<UserT> getUsertListlimit(@Param("init_index") int index_font, @Param("size") int size);
    void addUser(UserT userT);

    UserT getUserbyId(int id);

    void updateUser(UserT userT);

    void deleteUser(int id);
    //同时获取用户和文章信息
    UserT getUserArticle(int id);
    //按照用户名模糊查找用户列表
    List<UserT> getUsertListByname(@Param("name") String name);
    //按照用户名精确查找用户
    UserT getUserByName(String name);
    //判断用户是否存在
    UserT isExist(UserT userT);
    //更新密码
    void updatePWD(UserT userT);
}
