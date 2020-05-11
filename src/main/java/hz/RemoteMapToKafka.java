package hz;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.jet.*;
import com.hazelcast.jet.pipeline.*;
import com.hazelcast.jet.KafkaSinks;
import com.hazelcast.map.journal.EventJournalMapEvent;
import com.hazelcast.jet.KafkaSources;

import java.util.Properties;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.*;


public class RemoteMapToKafka {
    private static final String MAP_NAME = "myMap";
    public final static String TOPIC = "test";
    
    public final static String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String AUTO_OFFSET_RESET = "earliest";

    public static void main(String[] args) {
        JetInstance jetInstance = Jet.newJetInstance();

        Pipeline pipeline = Pipeline.create();
       
        ClientConfig clientConfig = new ClientConfig();
        
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("key.serializer", StringSerializer.class.getCanonicalName());
        props.setProperty("key.deserializer", StringDeserializer.class.getCanonicalName());
        props.setProperty("value.serializer", IntegerSerializer.class.getCanonicalName());
        props.setProperty("value.deserializer", IntegerDeserializer.class.getCanonicalName());
        props.setProperty("auto.offset.reset", "earliest");

        Pipeline p = Pipeline.create();
       /*
        p.drawFrom(KafkaSources.kafka(props, "t1", "t2"))
        .withoutTimestamps()
        .drainTo(KafkaSinks.kafka(props, "t3"));
        */
         /*
         p.drawFrom(  KafkaSources.<Integer, String>kafka(props, "t1", "t2"))
         .withoutTimestamps()
         .drainTo(Sinks.map( "t3"));
         */
         
        
        jetInstance.newJob(pipeline).join();
    }
}
