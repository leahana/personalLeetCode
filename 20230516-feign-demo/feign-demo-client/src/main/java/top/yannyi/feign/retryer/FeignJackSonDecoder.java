package top.yannyi.feign.retryer;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * @Author: LeahAna
 * @Date: 2023/6/14 16:31
 * @Desc: feign 请求结果解析
 */

public class FeignJackSonDecoder implements Decoder {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        try (Reader reader = response.body().asReader(StandardCharsets.UTF_8)) {
            return objectMapper.readValue(reader, objectMapper.constructType(type));
        }
    }
}
