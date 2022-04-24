package top.syhan.vlog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.syhan.vlog.model.entity.Tag;

import java.util.List;

/**
 * @program: vlog-api
 * @description: 标签Mapper
 * @author: SYH
 * @create: 2022-04-23 19:33
 **/
public interface TagMapper {
    /**
     * 批量插入tag
     *
     * @param tagList 标签集合
     * @return int
     */
    @Insert({
            "<script>",
            "INSERT INTO t_tag(tag_name, tag_color) VALUES ",
            "<foreach collection='tagList' item='item' index='index' separator=','>",
            "(#{item.tagName}, #{item.tagColor})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertTags(@Param(value = "tagList") List<Tag> tagList);

    /**
     * 查询所有标签
     *
     * @return List<Tag>
     */
    @Select("SELECT * FROM t_tag ")
    List<Tag> selectAll();
}
