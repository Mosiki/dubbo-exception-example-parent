package io.github.mosiki.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import io.github.mosiki.IHelloService;
import io.github.mosiki.common.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：HelloAction
 * 类描述：
 * 创建人：WeJan
 * 创建时间：2018-12-11 05:13
 */
@RestController
public class HelloAction {

    @Reference(version = "1.0.0")
    private IHelloService helloService;

    @GetMapping(value = "/hello")
    public Result<String> hello(String name) {
        return Result.success(helloService.sayHello(name));
    }
}
