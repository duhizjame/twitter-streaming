package consumers

object ConsumerMain {
  def main(): Unit = {
    TwitterKafkaConsumer.poll("bigdata-tweets")
  }

}
