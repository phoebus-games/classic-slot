package classicslot

import classicslot.app.ClassicSlotController
import classicslot.infra.ClassicSlotRepo

object App {
  def main(args: Array[String]): Unit = {
    new App().run()
  }
}

class App extends games.App {
  register(classOf[ClassicSlotController])
  bind(new ClassicSlotRepo(mongo, writeConcern), classOf[ClassicSlotRepo])
}
