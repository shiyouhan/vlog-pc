package top.syhan.vlog.service.impl;

import org.springframework.stereotype.Service;
import top.syhan.vlog.mapper.TagMapper;
import top.syhan.vlog.model.entity.Tag;
import top.syhan.vlog.service.TagService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 20:10
 **/
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public void insertTags(List<Tag> tags) {
        tagMapper.insertTags(tags);
    }

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }
}
