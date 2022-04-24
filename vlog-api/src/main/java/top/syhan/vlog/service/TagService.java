package top.syhan.vlog.service;

import top.syhan.vlog.model.entity.Tag;

import java.util.List;

/**
 * @program: vlog-api
 * @description: TagService
 * @author: SYH
 * @create: 2022-04-23 19:57
 **/
public interface TagService {

    /**
     * 批量插入标签
     *
     * @param tags 标签集合
     */
    void insertTags(List<Tag> tags);

    /**
     * 查询所有标签
     *
     * @return 所有标签
     */
    List<Tag> selectAll();
}

