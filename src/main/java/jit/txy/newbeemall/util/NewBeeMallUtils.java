package jit.txy.newbeemall.util;

import org.springframework.util.StringUtils;

import java.net.URI;

/**
 * @author 唐星宇
 * @date 2022/9/18
 **/
public class NewBeeMallUtils {
    public static URI getHost(URI uri) {
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }
}
