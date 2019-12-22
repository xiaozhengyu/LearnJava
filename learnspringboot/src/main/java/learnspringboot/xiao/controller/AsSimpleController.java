package learnspringboot.xiao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


/**
 * @author 肖政宇
 * @date 2019-10-10 09:28
 * 说明：用于测试使用的简单控制器
 */
@RestController
@RequestMapping("test/")
@Api("用于测试使用的简单控制器")
public class AsSimpleController {

    @ApiOperation(value = "hello", notes = "用于测试应用程序能够响应请求")
    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }

    @ApiOperation(value = "hello2", notes = "测试参数接收")
    @ApiImplicitParam(name = "string", value = "字符参数", required = true, dataType = "String")
    @GetMapping("hello2")
    public String hello2(@RequestParam String string) {
        return string;
    }
}
