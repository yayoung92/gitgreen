package com.mh.restapi03.users;

import com.mh.restapi03.exception.ErrorCode;
import com.mh.restapi03.exception.LogicException;
import com.mh.restapi03.exception.UsersException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User regist(User user){

        User emailuser = userRepository.findByEmail(user.getEmail());
        if(emailuser != null){
            //throw new LogException(ErrorCode.DUPLICATE);  // ErrorCode 클래스의 HttpStatus.BAD_REQUEST,"A001","중복된 내용이 있습니다." 들어가는거임
            //throw new LogException(ErrorCode.NOTFOUND);  // HttpStatus.NOT_FOUND, "B001","내용이 없습니다."
            throw new LogicException(ErrorCode.DUPLICATE);
        }

        // insert 구문 실행
        User dbUser = userRepository.save(user);
        return dbUser;
    }

    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }

    // 24.03.08
    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UsersException(ErrorCode.NOTFOUND);
        }
        else{
            return optionalUser.get();
        }
    }
    public User updateUser(User user){
        User emailUser = userRepository.findByEmail(user.getEmail());
        if(emailUser == null){
            throw new UsersException(ErrorCode.NOTUPDATE);
        }
        // 바꿀 수 있는 부분
        emailUser.setWdate(user.getWdate());
        emailUser.setUsername(user.getUsername());
        emailUser.setPassword(user.getPassword());
        emailUser.setGender(user.getGender());

        User dbUser = userRepository.save(user);
        return dbUser;
    }

    public void delete(Long id) {
        // 해당되는 아이디가 있으면 삭제해야함.
        // 해당되는 아이디가 없으면 삭제할 유저가 없다고 알려주야함
        Optional<User> dbUser = userRepository.findById(id);
        if(dbUser.isEmpty()){
            throw new UsersException(ErrorCode.NOTFOUND); //삭제할 유저가 없다는 이야기
        }
        userRepository.delete(dbUser.get());
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }
}
