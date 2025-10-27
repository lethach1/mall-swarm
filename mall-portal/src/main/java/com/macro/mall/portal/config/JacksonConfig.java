package com.macro.mall.portal.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;


/**
 * Jackson Related Configuration Class
 * JSON does not return null fields
 * Created by macro on 2018/8/2.
 */
@Configuration
public class JacksonConfig {
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();

        // Configure the mapper object through this method, all serialized objects will be serialized according to this rule
        // Include.Include.ALWAYS default
        // Include.NON_DEFAULT properties with default values are not serialized
        // Include.NON_EMPTY properties that are empty ("") or NULL are not serialized, so the returned json does not have this field. This saves more traffic for mobile devices
        // Include.NON_NULL properties that are NULL are not serialized, that is, null fields do not participate in serialization
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Field retention, convert null values to ""
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()
//        {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator,
//                                  SerializerProvider serializerProvider)
//                    throws IOException, JsonProcessingException
//            {
//                jsonGenerator.writeString("");
//            }
//        });
        return objectMapper;
    }
}
