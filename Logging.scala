import org.apache.log4j.{Level, Logger}

class Logging {
  // Is it better to create it as a singleton object whose methods can be used directly in other classes?

  def log(data: Unit): Unit = {
    // Squelches the log messages (may squelch errors too, be careful)
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)
  }

}
