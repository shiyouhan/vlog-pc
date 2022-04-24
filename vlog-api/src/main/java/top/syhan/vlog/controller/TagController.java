package top.syhan.vlog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.syhan.vlog.model.entity.Tag;
import top.syhan.vlog.service.TagService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: vlog-api
 * @description: TagController
 * @author: SYH
 * @create: 2022-04-23 16:46
 **/
@RestController
@RequestMapping(value = "/api/tag")
@Slf4j
public class TagController {
    @Resource
    private TagService tagService;

    @GetMapping("all")
    public List<Tag> getTags() {
        return tagService.selectAll();
    }
}
