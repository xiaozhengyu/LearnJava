package learnspringboot.xiao.other.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 肖政宇
 * @date 2019-10-10 11:01
 * 说明：拦截器实例
 * 拦截器能够在处理每一个请求的前后做一些事情。
 * 可以让普通的Bean事项HandlerInterceptor接口
 * 或者继承HandlerInterceptorAdapter类来实现自定义的拦截器。
 * 拦截器需要在配置类中注册
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    /**
     * 本拦截器实现的功能：计算每一次请求的处理时间
     */

    /**
     * 在控制器处理web请求前执行的工作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、获取接收到请求时的系统时间，即开始处理请求的时间
        long startTime = System.currentTimeMillis();
        //2、将时间保存的request体中
        request.setAttribute("startTime", startTime);
        return super.preHandle(request, response, handler);
    }

    /**
     * 在控制器处理web请求后执行的工作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //1、从request体中取出之前存进去的“处理本次请求的开始时间”
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        //2、获取当前系统时间，即处理完当前请求的时间
        long endTime = System.currentTimeMillis();
        //3、计算得出处理本次请求的总时间
        long totalTime = endTime - startTime;

        System.out.println("本次请求的处理时常：" + totalTime);
        request.setAttribute("totalTime", totalTime);
        super.postHandle(request, response, handler, modelAndView);
    }
}
