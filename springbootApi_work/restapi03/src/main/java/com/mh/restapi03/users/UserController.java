package com.mh.restapi03.users;

import com.mh.restapi03.exception.ErrorCode;
import com.mh.restapi03.exception.UsersException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    /*
    get 사용자 조회
    post 사용자 등록
    put 사용자 수정
    delete 사용자 삭제
     */
    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list = userService.getAllUsers();
        if(list.size()==0){
            throw new UsersException(ErrorCode.NOTFOUND);
        }
        //return ResponseEntity.ok(list);  // 같은 방식
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        System.out.println(id);

        User user = userService.getUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PostMapping("users")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserDTO userDTO){
        userDTO.setWdate(LocalDateTime.now());

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDTO,User.class);

        User dbUser = userService.regist(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
    }

    @PutMapping("users")
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDTO userDTO){
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDTO, User.class);
        user.setWdate(LocalDateTime.now());
        User dbUser = userService.updateUser(user);
        System.out.println(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbUser);
    }
}


//    @PostMapping("users")
//    public ResponseEntity<User> addUser(@RequestBody @Valid UserDTO userDTO){
//        // beanutils copy 방식
//        // BeanUtils.copyProperties(user, userDTO);
//
//        // modelmapper 방식
////        ModelMapper mapper = new ModelMapper();
////        User user = mapper.map(userDTO,User.class);
//
//        User user = UserDTO.of(userDTO);
//// 원래 방식
////        User user = User.builder()
////                .username(userDTO.getUsername())
////                .password(userDTO.getPassword())
////                .email(userDTO.getEmail())
////                .wdate(LocalDateTime.now())
////                .gender(userDTO.getGender())
////                .build();
//        User dbUser = userService.regist(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
//    }