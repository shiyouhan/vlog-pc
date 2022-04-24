package top.syhan.vlog.controller;

import top.syhan.vlog.util.DataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.syhan.vlog.model.Card;

import java.util.List;

/**
 * @program: vlog-api
 * @description: CardController
 * @author: SYH
 * @create: 2022-04-23 16:44
 **/
@RestController
@RequestMapping(value = "api")
public class CardController {

    @GetMapping("cards")
    public List<Card> getCard() {
        return DataUtil.initCards();
    }
}
