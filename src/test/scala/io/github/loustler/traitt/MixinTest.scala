package io.github.loustler.traitt

import io.github.loustler.traitt.mixin.{
  BasicIntQueue,
  DecrementIntQueue,
  Doubling,
  DoublingIntQueue,
  Filtering,
  IncrementIntQueue,
  Incrementing
}
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author loustler
  * @since 09/04/2018
  */
class MixinTest extends FlatSpec with Matchers {
  "Queue Mixin" should "be DoublingQueue" in {
    val queue: DoublingIntQueue = new DoublingIntQueue()

    queue.put(5)
    queue.put(1)
    queue.put(4)

    queue.get() shouldEqual 10
    queue.get() shouldEqual 2
    queue.get() shouldEqual 8
  }

  it should "be IncrementQueue" in {
    val queue: IncrementIntQueue = new IncrementIntQueue()

    queue.put(8)
    queue.put(4)
    queue.put(13)

    queue.get() shouldEqual 9
    queue.get() shouldEqual 5
    queue.get() shouldEqual 14
  }

  it should "be FilterQueue" in {
    val queue: BasicIntQueue with Filtering = new BasicIntQueue() with Filtering

    queue.put(0)
    queue.put(1)
    queue.put(5)
    queue.put(-1)

    queue.size shouldBe 3
    queue.get() shouldBe 0
    queue.get() shouldBe 1
    queue.get() shouldBe 5
  }

  "New mixin implementation" should "filtering with incrementing" in {
    val queue = new BasicIntQueue() with Filtering with Incrementing

    queue.put(-1)
    queue.put(1)
    queue.put(3)

    queue.size shouldBe 3
    queue.get() shouldBe 0
    queue.get() shouldBe 2
    queue.get() shouldBe 4
  }

  it should "incrementing with filtering" in {
    val queue: BasicIntQueue with Incrementing with Filtering =
      new BasicIntQueue() with Incrementing with Filtering

    queue.put(-1)
    queue.put(0)
    queue.put(4)

    queue.size shouldBe 2
    queue.get() shouldBe 1
    queue.get() shouldBe 5
  }

  it should "filtering with doubling with incrementing" in {
    val queue: BasicIntQueue with Filtering with Doubling with Incrementing =
      new BasicIntQueue() with Filtering with Doubling with Incrementing

    queue.put(-1)
    queue.put(0)
    queue.put(4)

    queue.size shouldBe 3
    queue.get() shouldBe 0
    queue.get() shouldBe 2
    queue.get() shouldBe 10
  }

  it should "doubling with filtering with incrementing" in {
    val queue: BasicIntQueue with Doubling with Filtering with Incrementing =
      new BasicIntQueue() with Doubling with Filtering with Incrementing

    queue.put(-1)
    queue.put(-2)
    queue.put(4)

    queue.size shouldBe 2
    queue.get() shouldBe 0
    queue.get() shouldBe 10
  }

  it should "doubling with incrementing with filtering" in {
    val queue: BasicIntQueue with Doubling with Incrementing with Filtering =
      new BasicIntQueue() with Doubling with Incrementing with Filtering

    queue.put(-1)
    queue.put(0)
    queue.put(4)

    queue.size shouldBe 2
    queue.get() shouldBe 2
    queue.get() shouldBe 10
  }

  it should "incrementing with doubling with filtering" in {
    val queue: BasicIntQueue with Incrementing with Doubling with Filtering =
      new BasicIntQueue() with Incrementing with Doubling with Filtering

    queue.put(-1)
    queue.put(0)
    queue.put(4)

    queue.size shouldBe 2
    queue.get() shouldBe 1
    queue.get() shouldBe 9
  }

  it should "incrementing with doubling with filtering with decrementing" in {
    val queue: BasicIntQueue
      with Incrementing
      with Doubling
      with Filtering
      with DecrementIntQueue = new BasicIntQueue() with Incrementing
    with Doubling with Filtering with DecrementIntQueue

    queue.put(1)
    queue.put(0)
    queue.put(-1)
    queue.put(4)

    queue.size shouldBe 2
    queue.get() shouldBe 1
    queue.get() shouldBe 7
  }
}
