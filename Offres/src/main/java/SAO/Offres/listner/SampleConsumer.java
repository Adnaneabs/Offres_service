package SAO.Offres.listner;

import SAO.Offres.kafka.Sample;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//import com.example.kafka.demo.common.Sample;

@Component
public class SampleConsumer {

    @KafkaListener(id = "sampleGroup", topics = "sample-topic4", containerFactory = "jsonKafkaListenerContainerFactory")
    public void consumeMessage(ConsumerRecord<String, String> cr, @Payload Sample payload) {
        System.out.println("Received: " + payload.getOneString());
    }
}
