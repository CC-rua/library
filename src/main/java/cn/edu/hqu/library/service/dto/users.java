package cn.edu.hqu.library.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class users {
    @NotNull(message = "users.name.void")
    @Size(min = 1,max = 20,message = "users.name.size_not_fit")
    private String name;
    @NotNull(message = "users.pwd.void")
    @Size(min = 1,max = 20,message = "users.pwd.size_not_fit")
    private String pwd;
    private Date birthday;
    private List<users> usersList;
}
