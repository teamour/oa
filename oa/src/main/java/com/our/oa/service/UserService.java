
package com.our.oa.service;




import com.our.oa.dto.form.UserDTO;

//import org.springframework.security.core.userdetails.UserDetailsService;

import com.our.oa.dto.list.UserListDTO;
import com.our.oa.dto.list.UserListQueryDTO;


public interface UserService extends /* UserDetailsService, */ListQueryService<UserListDTO,UserListQueryDTO> {

	String save(UserDTO form);
}
