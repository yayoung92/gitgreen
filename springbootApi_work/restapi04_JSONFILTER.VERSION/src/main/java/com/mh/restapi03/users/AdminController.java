package com.mh.restapi03.users;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mh.restapi03.exception.ErrorCode;
import com.mh.restapi03.exception.UsersException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor   // IOC 컨테이너에서 객체 가져오는 방법 -> @Autowired 안 쓰고 이거 넣기
public class AdminController {

    private final UserRepository userRepository;
    @GetMapping("users/{id}")
    public MappingJacksonValue getUserById(@PathVariable Long id){ // @PathVariable 주소의 값을 가지고 오려면 이 어노테이션을 써야 한다.
//        Optional<User> user = userRepository.findById(id);
//        if(user.isEmpty()) {
//            throw new UsersException(ErrorCode.NOTFOUND);
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsersException(ErrorCode.NOTFOUND)
        );

        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(user, adminUser);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(adminUser);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AdminUser",
                SimpleBeanPropertyFilter.filterOutAllExcept("") // 필터링 해서 json 파일로 출력
        );
        mappingJacksonValue.setFilters(filterProvider);

        System.out.println(adminUser);
        return mappingJacksonValue;
    }
    @DeleteMapping("users/{id}")
    public User deleteUserById(Long ig){
        return new User();
    }
}