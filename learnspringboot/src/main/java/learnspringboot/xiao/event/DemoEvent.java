package learnspringboot.xiao.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author xzy
 * @date 2019-11-22 11:19
 * 说明：自定义事件
 */
public class DemoEvent extends ApplicationEvent {
    private String message;

    public DemoEvent(Object source) {
        super(source);
    }

    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
