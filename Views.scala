package nl.ing.solsel.cram.frontend

/**
 * Created by M07C721 on 4-11-2015.
 */
object Main extends App {
  println("TEST1")

  val ui1 = Step(
    order = 1,
    hallo = "Hallo",
    Input[String](
      name = "test"
    ) :+
    Input[Int](
      name = "test"
    )
  ) :+
  Step(
    order = 1,
    hallo = "Hallo",
    Input[String](
      name = "test"
    ) :+
    Input[String](
      name = "test"
    )
  )

  val ui2 = Step(
    order = 1,
    Input[String](
      name = "test"
    ) :+
    Input[String](
      name = "test"
    )
  )

  val ui3 = Step(
    order = 1,
    components =
    Input[String](
      name = "test"
    ) :+
    Input[Int](
      name = "test"
    ) :+
    Button[Button.Back](
      name = "test"
    ) :+
    Button[Button.Next](
      name = "test"
    )
  )

  println(ui1)
}


trait Component {

  def apply(): BaseComponent = {
    println("TEST1")
    new BaseComponent(){}
  }

  def apply(component: BaseComponent): BaseComponent = {
    println("TEST2")
    new BaseComponent(){}
  }

  def apply(components: Seq[BaseComponent]): BaseComponent = {
    println("TEST3")
    new BaseComponent(){}
  }

  def apply(order: Int, components: Seq[BaseComponent]): BaseComponent = {
    println("TEST4")
    new BaseComponent(){}
  }

  def apply(order: Int, hallo: String, components: Seq[BaseComponent]): BaseComponent = {
    println("TEST5")
    new BaseComponent(){}
  }

}

trait BaseComponent {
  println("New Component")

  def add(component: BaseComponent): Seq[BaseComponent] = {
    Seq(this, component)
  }

  def :+ (component: BaseComponent): Seq[BaseComponent] = {
    Seq(this, component)
  }
}

trait StepComponent extends BaseComponent{
  println("New StepComponent")
}

trait InputComponent extends BaseComponent{
  println("New InputComponent")
}

trait ButtonComponent extends BaseComponent{
  println("New ButtonComponent")
}

object Step extends Component{

  def test(): Unit ={

  }
}

object Input extends Component {


  def apply[T](name: String = "test", title: String = "test"): BaseComponent = {
    new InputComponent() {}
  }
}

object Button extends Component {

  trait Event
  case class Back() extends Event
  case class Next() extends Event

  def apply[T](name: String = "test", title: String = "test"): BaseComponent = {
    new ButtonComponent(){}
  }
}


