package com.wkc.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import com.wkc.library.entity.Book;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaoniao
 * @date 2023/2/28 13:43
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    //根据书名查找书籍
    Book getByName(String name);

    //插入书籍
    Integer insertBook(@Param("book") Book book);
}
