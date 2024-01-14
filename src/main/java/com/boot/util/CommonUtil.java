package com.boot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommonUtil {

    public static void printJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String jsonMessage = null;
        try {
            jsonMessage = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.info("Json Processing exception");

        }
        log.info("\n----------------------\n JSON Response Start:\n----------------------\n" +
                jsonMessage +
                "\n----------------------\nJSON Response End\n----------------------\n"
        );
    }
}
