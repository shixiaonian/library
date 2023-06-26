package com.wkc.library.controller;

import com.wkc.library.entity.BookScore;
import com.wkc.library.entity.R;
import com.wkc.library.mapper.BookScoreMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * @author xiaoniao
 * @date 2023/4/10 16:00
 */
@RequestMapping("/bookScore")
@RestController
public class BookScoreController {
    @Autowired
    BookScoreMapper bookScoreMapper;

    @PostMapping("/score")
    public R score(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String bookId = request.getParameter("bookId");
        String score = request.getParameter("score");
        Date date = new Date();
        BookScore bookScore = new BookScore(Integer.parseInt(userId),Integer.parseInt(bookId),Integer.parseInt(score),null);
        Integer integer = bookScoreMapper.insetScore(bookScore);
        if(integer == 1){
            return R.success("评分成功");
        }
        return R.error("评分失败");
    }

    @GetMapping
    public R<List<BookScore>> getAll(){
        List<BookScore> all = bookScoreMapper.getAll();
        return R.success(all);
    }
}
