package com.wkc.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaoniao
 * @date 2023/2/28 13:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public Integer bookId;//书本id
    public String bookName;//书名
    public double bookPrice;//书本价格
    public String bookPublic;//书本出版社
    public String bookClassify;//书籍分类
    public String bookAuthor;//书本作者
    public String bookImge;//书本图片
    public String bookDescription;//书本描述
}
