package consumers

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG
import io.confluent.kafka.serializers.KafkaAvroDeserializer
import org.apache.avro.generic.IndexedRecord
import org.apache.kafka.clients.consumer.ConsumerConfig.{BOOTSTRAP_SERVERS_CONFIG, GROUP_ID_CONFIG, KEY_DESERIALIZER_CLASS_CONFIG, VALUE_DESERIALIZER_CLASS_CONFIG}
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.spark.sql.SparkSession

import scala.collection.JavaConverters.{mapAsJavaMapConverter, seqAsJavaListConverter}

object TwitterKafkaConsumer {

  val spark: SparkSession = SparkSession.builder().getOrCreate()

  val props: Map[String, Object] = Map(
    GROUP_ID_CONFIG -> "car-metrics-consumer",
    BOOTSTRAP_SERVERS_CONFIG -> "kafka:9092",
    KEY_DESERIALIZER_CLASS_CONFIG -> classOf[KafkaAvroDeserializer],
    VALUE_DESERIALIZER_CLASS_CONFIG -> classOf[KafkaAvroDeserializer],
    SCHEMA_REGISTRY_URL_CONFIG -> "http://schema-registry:8081"
  )

  def poll(topic: String): Unit = {
    val consumer = new KafkaConsumer[IndexedRecord, IndexedRecord](TwitterKafkaConsumer.props.asJava)
    consumer.subscribe(Seq(topic).asJava)
    val df = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "host1:port1,host2:port2")
      .option("subscribe", "topic1")
      .load()
  }
}
