package learnspringboot.xiao.boot.Service;

import org.springframework.stereotype.Service;

/**
 * @author xzy
 * @date 2019-11-22 10:36
 * 说明：Profile控制Bean的创建
 */
public class DemoBeanService {
    private String content;

    public DemoBeanService() {

    }

    public DemoBeanService(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
