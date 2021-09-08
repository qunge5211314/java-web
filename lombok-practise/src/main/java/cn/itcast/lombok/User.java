package cn.itcast.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Command + 7查看类结构
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String password;

    public void setId(Integer id){
        System.out.println("test");
        this.id = id;

    }
}
