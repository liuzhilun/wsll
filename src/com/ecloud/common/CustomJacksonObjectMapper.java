package com.ecloud.common;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;


public class CustomJacksonObjectMapper extends ObjectMapper {


	public CustomJacksonObjectMapper() {
		disable(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS);
		//json转换null为空字符串
		 this.getSerializerProvider().setNullValueSerializer(  
                 new JsonSerializer<Object>() {  
                     @Override  
                     public void serialize(Object value, JsonGenerator jgen,  
                             SerializerProvider provider) throws IOException,  
                             JsonProcessingException {  
                         jgen.writeString("");  
                     }  
                 });  
	}
}
