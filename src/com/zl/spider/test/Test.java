package com.zl.spider.test;

import java.util.List;

import com.zl.spider.bean.LinkTypeData;
import com.zl.spider.core.ExtractService;
import com.zl.spider.rule.Rule;

public class Test {
    @org.junit.Test
    public void getDatasByClass() {
        Rule rule = new Rule(
                "http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
                new String[]{"query.enterprisename", "query.registationnumber"}, new String[]{"兴网", ""},
                "cont_right", Rule.CLASS, Rule.POST);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }

    @org.junit.Test
    public void getDatasByCssQuery() {
        Rule rule = new Rule("http://www.11315.com/search",
                new String[]{"name"}, new String[]{"兴网"},
                "div.g-mn div.con-model", Rule.SELECTION, Rule.GET);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }

    public void printf(List<LinkTypeData> datas) {
        for (LinkTypeData data : datas) {
            System.out.println(data.getLinkText());
            System.out.println(data.getLinkHref());
            System.out.println("***********************************");
        }

    }

    @org.junit.Test
    public void getDatasByCssQueryUserBaidu() {
        Rule rule = new Rule("http://news.baidu.com",
                new String[]{"word"}, new String[]{"支付宝"},
                null, -1, Rule.GET);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }


}
