package cn.edu.whut.sept.zuul.Service;


import cn.edu.whut.sept.zuul.Entity.UserT;
import cn.edu.whut.sept.zuul.Mapper.UsertMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("usertService")
public class UsertService implements IUsertService{
    @Resource
    UsertMapper usertMapper;
    public boolean userLogin(UserT user) {
        if(usertMapper.isExist(user)!=null){
            return true;
        }
        else{
            return false;
        }

    }
    public boolean userRegister(UserT user) {
        if (usertMapper.isExist(user) != null) {
            return false;
        } else {
            try {
                usertMapper.addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }
    public boolean userChange_Password(UserT user){
        UserT input=usertMapper.getUserByName(user.getUsername());
        if(input!=null){
            try{
                input.setPassword(user.getPassword());
                usertMapper.updatePWD(input);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean userpdchange(String username, String password) {
        UserT userT=usertMapper.getUserByName(username);
        if(userT!=null)
        {
            userT.setPassword(password);
            usertMapper.updatePWD(userT);
            return true;
        }
        else {
            return false;
        }
    }
}
