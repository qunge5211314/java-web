package cn.itcast.lombok;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Command + 7查看类结构
 */


//@AllArgsConstructor
//@NoArgsConstructor
//@ToString(exclude = {"age", "email"})
//@EqualsAndHashCode(of = {"id", "password"})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
//    static String s = "";
//    final int i = 0;
    private Integer id;
    private String name;
    //    @Getter(AccessLevel.PRIVATE)
    //    @NonNull
    private Integer age;
    //    @Setter
    private String email;
    private String password;

    public void setId(Integer id) {
        System.out.println("test");
        this.id = id;

    }
}
