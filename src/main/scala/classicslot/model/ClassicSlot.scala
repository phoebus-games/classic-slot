package classicslot.model

import games.model.Wallet
import slot.model.{Reels, Slot, Stops}

import scala.util.Random

object ClassicSlot {
  private val Melon = 0
  private val Bell = 1
  private val Seven = 2
  private val Lime = 3
  private val Cherry = 4
  private val Plum = 5
  private val Grapes = 6
  private val Orange = 7
  private val Bar = 9
  private val reel = List(Melon, Bell, Seven, Bell, Lime, Cherry, Plum, Grapes, Orange, Bar)
  private val reels = List(
    new Random(0).shuffle(reel),
    new Random(1).shuffle(reel),
    new Random(2).shuffle(reel)
  )
  private val payTable = Map(
    (Melon, 3) -> 5,
    (Bell, 3) -> 20,
    (Seven, 3) -> 5,
    (Lime, 3) -> 5,
    (Cherry, 3) -> 15,
    (Plum, 3) -> 5,
    (Grapes, 3) -> 5,
    (Orange, 3) -> 5,
    (Bar, 3) -> 20
  )
  private val payLines = List(List(0, 0, 0))

  def apply(random: (Reels => Stops), wallet: Wallet, stops: Stops = List(0, 0, 0)) =
    Slot(random, wallet, reels, payTable, payLines, 1, stops)
}
