package cn.itcast.mybatis.model;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("User")
public class User {
    private Long id;
    private String name;
    private String lastName;
}
