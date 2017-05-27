package classicslot

import classicslot.app.ClassicSlotController
import classicslot.infra.ClassicSlotRepo
import org.springframework.boot.SpringApplication

object App {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[App])
  }
}

class App extends games.App {
  register(classOf[ClassicSlotController])
  bind(new ClassicSlotRepo(mongo, writeConcern), classOf[ClassicSlotRepo])
}
