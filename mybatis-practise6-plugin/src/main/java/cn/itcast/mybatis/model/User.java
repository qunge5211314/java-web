package cn.itcast.mybatis.model;


import lombok.*;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;
    private String lastName;
    private Enterprise enterprise;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
