package com.wkc.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoniao
 * @date 2023/2/17 13:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(value = "id",type = IdType.AUTO)
    public Integer id;//用户id
    public String name;//用户名
    public String password;//用户密码
    public Integer age;//用户年龄
    public String address;//是否为管理员


}
