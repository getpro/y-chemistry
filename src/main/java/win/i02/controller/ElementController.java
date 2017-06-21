package win.i02.controller;

import org.apache.commons.lang3.StringUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import win.i02.bean.BaseResultBean;
import win.i02.bean.ElementBean;
import win.i02.enums.CodeStatus;

/**
 * 元素接口
 * Created by Qi on 2017/6/10.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/element")
public class ElementController {
    @Autowired
    private Dao dao;

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.PUT})
    public BaseResultBean add(@RequestBody(required = false) ElementBean bean) {

        if (StringUtils.isEmpty(bean.getcSymbol())) {
            return new BaseResultBean(CodeStatus.ErrorParams);
        }

        int count = dao.count(ElementBean.class, Cnd.where("c_symbol", "=", bean.getcSymbol()));
        if (count > 0) {
            return new BaseResultBean(CodeStatus.ExistResult);
        }
        ElementBean b = dao.insert(bean);
        return new BaseResultBean(b);
    }

    @RequestMapping(value = "/q", method = RequestMethod.GET)
    public BaseResultBean query(@RequestParam(required = false) String symbol,
                                @RequestParam(required = false) String nameCN,
                                @RequestParam(required = false) String nameEN) {
        ElementBean bean = null;
        Cnd cnd = null;
        if (!StringUtils.isEmpty(symbol)) {
            cnd = Cnd.where("c_symbol", "=", symbol);
        }
        if (!StringUtils.isEmpty(nameCN)) {
            if (cnd != null) {
                cnd.or("c_name_cn", "=", nameCN);
            } else {
                cnd = Cnd.where("c_name_cn", "=", nameCN);
            }
        }

        if (!StringUtils.isEmpty(nameEN)) {
            if (cnd != null) {
                cnd.or("c_name_en", "=", nameEN);
            } else {
                cnd = Cnd.where("c_name_en", "=", nameEN);
            }
        }

        if (cnd == null) {
            return new BaseResultBean(CodeStatus.ErrorParams);
        }

        bean = dao.fetch(ElementBean.class, cnd);
        if(bean==null){
            return new BaseResultBean(CodeStatus.EmptyResult);
        }
        return new BaseResultBean(bean);
    }


}
