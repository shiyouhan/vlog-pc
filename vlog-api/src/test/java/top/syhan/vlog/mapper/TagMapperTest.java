package top.syhan.vlog.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.syhan.vlog.model.entity.Tag;
import top.syhan.vlog.task.TagTask;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 21:48
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class TagMapperTest {
    @Resource
    private TagTask tagTask;
    @Resource
    private TagMapper tagMapper;

    @Test
    void batchInsert() throws Exception {
        //线程池核心线程数为6，最大线程数为10。超时时间为5秒
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        Future<List<Tag>> future = executor.submit(tagTask);
        List<Tag> tags = future.get();
        int count = tagMapper.insertTags(tags);
        System.out.println(count);

    }

    @Test
    void selectAll() {
        List<Tag> tags = tagMapper.selectAll();
        tags.forEach(tag -> System.out.println(tag.getTagName() + "," + tag.getTagColor()));
    }
}
