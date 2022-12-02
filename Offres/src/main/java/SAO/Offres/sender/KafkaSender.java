package SAO.Offres.sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
/*
@Component
class KafkaSender {
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }

}
 */

