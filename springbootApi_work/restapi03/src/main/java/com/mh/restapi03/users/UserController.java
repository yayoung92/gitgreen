package com.mh.restapi03.users;

import com.mh.restapi03.exception.ErrorCode;
import com.mh.restapi03.exception.UsersException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "User-Controller", description = "유저 조회 등록 수정 삭제")
public class UserController {
    /*
    get 사용자 조회
    post 사용자 등록
    put 사용자 수정
    delete 사용자 삭제
     */
    private final UserService userService;
    private final UserRepository userRepository;

    @Operation(summary = "사용자 전체 목록보기",description = "사용자 전체 전보를 조회 할 수 있습니다.")
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "사용자들이 없을 때 나오는 코드")
            }
    )
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
    @Operation(summary = "사용자 한명 보기", description = "사용자 한명의 정보를 조회 할 수 있습니다.")
    @Parameters(
            @Parameter( description = "조회하고자 하는 사용자 ID 를 입력하세요",
            name = "id",
            required = true)
    )
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

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.delete(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("삭제됨");
    }

    @DeleteMapping("users/all")
    public ResponseEntity<String> deleteUserAll(){
        userService.deleteAll();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("전체 삭제됨");
    }
    //@Transactional  // 영속성에 의해서 setter 메서드 사용시  dbUpdate 실행됨
    @Transactional(readOnly = true)  // 무분별한 세터메서드를 사용해도 된다.
    @GetMapping("users/tran")
    public String userstran(){
        // Optional<User> dbUser = userRepository.findById(1L).orElseThrow();
        User dbUser = userRepository.findById(1L).orElseThrow();
        dbUser.setUsername("김길동");  // 자동 업데이트 된다.

        return "tran";
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