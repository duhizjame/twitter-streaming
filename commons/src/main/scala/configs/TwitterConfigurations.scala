package scala.configs

object TwitterConfigurations {
  val CONSUMER_KEY = "TIaSM5jTQmSdb7tL58ErnyNRN"
  val CONSUMER_SECRET = "XZpi497hQk9d8yabYEcybiaJwRgI3Nhp7OyrIRI4YngYYFHhEr"
  val ACCESS_TOKEN = "1390540512-eUlrkAdnOH6c2vc8ukq6XmtxdlEdMfmK2FUzA4i"
  val TOKEN_SECRET = "duuEC9fktqQEzFcVYLC15TXbCUkof2bXmjHafFjct72KM"
  val HASHTAG = "#bigdata"
}

case class TwitterConfigurations(consumerKey: String,
                                 consumerSecret: String,
                                 accessToken: String,
                                 tokenSecret: String)