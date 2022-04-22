package launcher

import producers.TwitterKafkaProducer

object Main {
  def main(args: Array[String]): Unit = {
    val producer = TwitterKafkaProducer()
    producer.run()
  }
}
