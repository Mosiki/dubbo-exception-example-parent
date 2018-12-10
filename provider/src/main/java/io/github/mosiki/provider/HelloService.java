package io.github.mosiki.provider;

import com.alibaba.dubbo.config.annotation.Service;
import io.github.mosiki.IHelloService;
import io.github.mosiki.common.exception.ServiceException;
import io.github.mosiki.common.status.EnumBaseError;

/**
 * 类名称：HelloService
 * 类描述：
 * 创建人：WeJan
 * 创建时间：2018-12-10 22:06
 */
@Service(version = "1.0.0")
public class HelloService implements IHelloService {

    @Override
    public String sayHello(String name) {
        if (name == null) {
            throw new ServiceException(EnumBaseError.MISSING_PARAMETERS);
        }
        return "Hello " + name;
    }
}
