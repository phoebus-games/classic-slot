package classicslot.model

import games.model.{Money, MonteCarloSimulator}
import slot.model.Slot

object ClassicSlotSimulation extends MonteCarloSimulator[Slot](
  wallet => ClassicSlot(Slot.randomStops, wallet),
  slot => slot.spin(Money(10)),
  expectedReturnToPlayer = 0.95,
  expectedRange = 0.01
)
