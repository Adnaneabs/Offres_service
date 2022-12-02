package SAO.Offres.config;

import SAO.Offres.kafka.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SampleContoller {
    @Autowired
    private KafkaTemplate<Object, Object> template;

    @PostMapping(path = "/send")
    public void sendFoo(@RequestParam("offre") String name) {
        this.template.send("sample-topic4", new Sample(name));
    }
}
