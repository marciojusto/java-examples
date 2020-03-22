package com.simpleexample.kafka.controller;

import com.google.gson.Gson;
import com.simpleexample.kafka.model.MoreSimpleModel;
import com.simpleexample.kafka.model.SimpleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;

    @PostMapping
    public void post(@RequestBody SimpleModel simpleModel) {
        kafkaTemplate.send("myTopic", jsonConverter.toJson(simpleModel));
    }

    @PostMapping("/v2/")
    public void post(@RequestBody MoreSimpleModel moreSimpleModel) {
        kafkaTemplate.send("myTopic2", jsonConverter.toJson(moreSimpleModel));
    }

    @KafkaListener(topics = "myTopic")
    public void getFromKafka(String simpleModel) {
        System.out.println(simpleModel);
        SimpleModel simpleModel1 = jsonConverter.fromJson(simpleModel, SimpleModel.class);
        System.out.println(simpleModel1.getFieldOne());
        System.out.println(simpleModel1.getFieldTwo());
    }

    @KafkaListener(topics = "myTopic2")
    public void getFromKafkaTwo(String moreSimpleModel) {
        System.out.println(moreSimpleModel);
        MoreSimpleModel moreSimpleModel1 = jsonConverter.fromJson(moreSimpleModel, MoreSimpleModel.class);
        System.out.println(moreSimpleModel1.toString());
    }
}
