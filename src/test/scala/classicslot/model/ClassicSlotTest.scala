package classicslot.model

import games.model.{Money, NullWallet}
import org.junit.Assert.assertEquals
import org.junit.Test

class ClassicSlotTest {

  @Test
  def slots(): Unit = {
    assertEquals(List(List(3), List(5), List(2)), ClassicSlot(_ => List(0, 0, 0), NullWallet).window)
  }


  @Test
  def winningSpin(): Unit = {
    val slot = ClassicSlot(_ => List(0, 4, 6), NullWallet).spin(Money(1))
    assertEquals(List(List(3), List(3), List(3)), slot.window)
    assertEquals(List((List(0, 0, 0), 5)), slot.payouts)
  }
}
